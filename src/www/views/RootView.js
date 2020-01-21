import { makeSubView } from "../ducks";
import { BlogView, GameView, HomeView, NewView, PlayView } from "./";

export const RootView = makeSubView("root", {
  Home: HomeView,
  Play: PlayView,
  Game: GameView,
  New: NewView,
  Blog: BlogView,
});
