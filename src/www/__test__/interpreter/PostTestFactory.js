import { renderApp } from "../renderApp";
import { FileInterpreter, readResource } from "./";
jest.mock("../../lib/api");

export class PostTestFactory {
  createTests(postId) {
    const body = readResource("blog", `${postId}.md`);
    const snapshots = JSON.parse(readResource("snapshots", `${postId}.json`));

    describe(`${postId}: ${body.split("\n")[0]}`, () => {
      new FileInterpreter()
        .beforeTest(context => {
          const { set } = context;
          const { container, debug } = renderApp();
          set("container", container);
          set("debug", debug);
        })
        .configure(({ set }) => set("snapshots", snapshots))
        .interpretFile(body);
    });
  }
}

process.on("uncaughtException", function(err) {
  // handle the error safely
  console.log(err);
});
process.on("unhandledRejection", function(err) {
  // handle the error safely
  console.log(err);
});
