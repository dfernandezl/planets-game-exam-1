import api from "../../../lib/api";
import { replaceGame } from "../actions";

export async function whenFetchGame(store, action) {
  const { playerId } = action;
  const result = await api.get(`/api/v1/players/${playerId}`);
  store.dispatch(replaceGame(result));
}
