import listCommands from "../selectors/listCommands";
import getPlayerId from "../../game/selectors/getPlayerId";
import api from "../../../lib/api";
import replaceGame from "../../game/actions/replaceGame";

export default async function whenNextPlayer(store, action) {
  const state = store.getState();
  const playerId = getPlayerId(state);
  const commands = listCommands(state);

  const game = await api.put(`/api/v1/players/${playerId}/next`, commands);
  store.dispatch(replaceGame(game));
}
