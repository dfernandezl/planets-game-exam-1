import { fetchGame } from "../actions";

export async function whenLoginGame(store, action) {
  const { playerId } = action;
  store.dispatch(fetchGame(playerId));
}
