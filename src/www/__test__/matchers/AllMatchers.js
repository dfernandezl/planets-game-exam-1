import chalk from "chalk";

import cell_X_is_highlighted from "./cell_X_is_highlighted";
import click_at_coordinates_X from "./click_at_coordinates_X";
import click_its_button_to_X from "./click_its_button_to_X";
import click_that_message from "./click_that_message";
import click_the_X_button from "./click_the_X_button";
import click_X_in_the_main_header from "./click_X_in_the_main_header";
import debug from "./debug";
import it_has_a_X_of_Y from "./it_has_a_X_of_Y";
import it_has_no_X from "./it_has_no_X";
import it_has_X_typed_into_the_Y from "./it_has_X_typed_into_the_Y";
import it_is_of_X from "./it_is_of_X";
import it_is_the_turn_number_X from "./it_is_the_turn_number_X";
import now_you_see_the_X from "./now_you_see_the_X";
import select_X_into_the_Y from "./select_X_into_the_Y";
import the_current_player_is_X from "./the_current_player_is_X";
import the_current_race_is_X from "./the_current_race_is_X";
import there_is_a_message_telling_X from "./there_is_a_message_telling_X";
import there_is_a_X_at_coordinates_Y from "./there_is_a_X_at_coordinates_Y";
import there_is_no_message_telling_X from "./there_is_no_message_telling_X";
import there_is_something_of_yours_at_X from "./there_is_something_of_yours_at_X";
import type_X_into_the_Y from "./type_X_into_the_Y";
import type_your_username from "./type_your_username";
import wait_for_an_alert_saying_X from "./wait_for_an_alert_saying_X";
import you_cannot_type_into_the_Y from "./you_cannot_type_into_the_Y";
import you_see_no_X_Y from "./you_see_no_X_Y";
import you_see_no_X from "./you_see_no_X";
import you_see_the_X_Y from "./you_see_the_X_Y";

const matchers = [
  cell_X_is_highlighted,
  click_at_coordinates_X,
  click_its_button_to_X,
  click_that_message,
  click_the_X_button,
  click_X_in_the_main_header,
  debug,
  it_has_a_X_of_Y,
  it_has_no_X,
  it_has_X_typed_into_the_Y,
  it_is_of_X,
  it_is_the_turn_number_X,
  now_you_see_the_X,
  select_X_into_the_Y,
  the_current_player_is_X,
  the_current_race_is_X,
  there_is_a_message_telling_X,
  there_is_a_X_at_coordinates_Y,
  there_is_no_message_telling_X,
  there_is_something_of_yours_at_X,
  type_X_into_the_Y,
  type_your_username,
  wait_for_an_alert_saying_X,
  you_cannot_type_into_the_Y,
  you_see_no_X_Y,
  you_see_no_X,
  you_see_the_X_Y,
].map(Matcher => new Matcher());

const highlight = chalk.bgYellowBright.black.bold;
export default class AllMatchers {
  async interpretInstruction(instruction, context) {
    const candidates = matchers
      .map(matcher => [matcher, matcher.match(instruction)])
      .filter(([, match]) => match)
      .filter(this._filterLongestMatch);

    if (candidates.length === 0) {
      throw new Error(
        `No matcher for line ${instruction.line}: "${highlight(
          instruction.source,
        )}"`,
      );
    }
    if (candidates.length > 1) {
      throw new Error(
        `More than one matcher for line ${instruction.line}: "${
          instruction.source
        }"\n  Candidates:\n    ${candidates
          .map(c => c[0].regExp)
          .join("\n    ")}`,
      );
    }

    const [[finalMatcher, matchResult]] = candidates;
    await finalMatcher.interpretMatch(matchResult, instruction, context);
  }

  _getMatchLength([, match]) {
    const length = match[0].length;
    return length;
  }

  _filterLongestMatch = (current, index, all) => {
    const currentLength = this._getMatchLength(current);
    return all.every(m => this._getMatchLength(m) <= currentLength);
  };
}
