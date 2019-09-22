import makeSubView from "../ducks/view/components/makeSubView";
import BlogView from "./blog/BlogView";
import HomeView from "./home/HomeView";
import NewView from "./new/NewView";
import PlayView from "./play/PlayView";
import GameView from "./game/GameView";

const RootView = makeSubView("root", {
  Home: HomeView,
  Play: PlayView,
  Game: GameView,
  New: NewView,
  Blog: BlogView,
});

export default RootView;
