import api from "../../../lib/api";
import { getPlayerId, replaceGame } from "../../game";
import { listCommands } from "../selectors";

export async function whenNextPlayer(store, action) {
  const state = store.getState();
  const playerId = getPlayerId(state);
  const commands = listCommands(state);

  const game = await api.put(`/api/v1/players/${playerId}/next`, commands);
  store.dispatch(replaceGame(game));
}
