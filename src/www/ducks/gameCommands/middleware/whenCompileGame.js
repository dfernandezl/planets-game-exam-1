import api from "../../../lib/api";
import { replaceAlert } from "../../alert/actions/replaceAlert";
import { getPlayerId, replaceGame } from "../../game";
import { listCommands } from "../selectors";

export async function whenCompileGame(store, action) {
  const state = store.getState();
  const playerId = getPlayerId(state);
  const commands = listCommands(state);

  const result = await api.post(
    `/api/v1/players/${playerId}/compile`,
    commands,
  );
  store.dispatch(replaceAlert("Game compiled"));
  store.dispatch(replaceGame(result));
}
