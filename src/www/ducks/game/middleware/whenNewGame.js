import api from "../../../lib/api";
import { replaceAlert } from "../../alert";
import { replaceGame } from "../actions";

export async function whenNewGame(store, action) {
  const { mapCode, players } = action;
  try {
    const game = await api.put("/api/v1/game", { mapCode, players });
    if (game.playerId) {
      store.dispatch(replaceGame(game));
      store.dispatch(replaceAlert("Game ready to play"));
    } else store.dispatch(replaceAlert("Game created successfully"));
  } catch (e) {
    store.dispatch(replaceAlert(e.data.message));
  }
}
