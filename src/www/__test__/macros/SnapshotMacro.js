import chalk from "chalk";
import { configure } from "@testing-library/dom";
import prettyFormat from "pretty-format";
import api from "../../lib/api";
import AbstractRegExpMacro from "./AbstractRegExpMacro";

// one second should be more than enough for any findBy*
// if you think that you require more time, look this first:
// https://jestjs.io/docs/en/timer-mocks.html
configure({ asyncUtilTimeout: 1000 });

const highlight = chalk.bgYellowBright.black.bold;

export default class PauseMatcherMacro extends AbstractRegExpMacro {
  constructor() {
    super(/\s*<!--\s+SNAPSHOT\s+([^\s]+)\s+status=\d+\s+-+->/);
  }

  async interpretMatch([, snapshotName], instruction, { snapshots }) {
    const snapshot = snapshots[snapshotName];
    const lastInteraction = await api.popLastInteraction();

    if (!snapshot)
      throw new Error(
        `${highlight(
          `Snapshot "${snapshotName}" not present`,
        )}, present names are:\n - "${Object.keys(snapshots).join(
          '"\n - "',
        )}"\nPlease, run backend test first to ensure that all snapshots are generated correctly.`,
      );

    const { request, response } = snapshot;
    if (!lastInteraction)
      throw new Error(
        `No recent API call detected. Expected an api call for ${highlight(
          `${request.method} ${request.url}`,
        )} and body:\n${prettyFormat(request.body)}`,
      );

    expect(lastInteraction.request).toEqual(request);
    lastInteraction.resolve(response.status, response.body);
  }
}
