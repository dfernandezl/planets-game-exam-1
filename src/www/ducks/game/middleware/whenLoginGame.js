import fetchGame from "../actions/fetchGame";

export default async function whenLoginGame(store, action) {
  const { playerId } = action;
  store.dispatch(fetchGame(playerId));
}
