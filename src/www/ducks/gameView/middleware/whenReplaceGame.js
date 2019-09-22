import { setView } from "../../view/actions/setView";

export default async function whenReplaceGame(store, action) {
  store.dispatch(setView({ root: "Play", coordinates: null }));
}
