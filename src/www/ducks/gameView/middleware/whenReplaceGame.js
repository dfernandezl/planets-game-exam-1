import { setView } from "../../view";

export async function whenReplaceGame(store, action) {
  store.dispatch(setView({ root: "Play", coordinates: null }));
}
