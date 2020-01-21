import api from "../../../lib/api";
import { replaceAlert } from "../../alert";
import { getPlayerId } from "../../game";
import { listCommands } from "../selectors";

export async function whenSaveCommands(store, action) {
  const state = store.getState();
  const playerId = getPlayerId(state);
  const commands = listCommands(state);

  await api.put(`/api/v1/players/${playerId}/commands`, commands);
  store.dispatch(replaceAlert("Game saved"));
}
