import React from "react";
import { Provider } from "react-redux";
import createDucksStore from "./ducks/createDucksStore";
import RootView from "./views/RootView";
import AppLayout from "./layout/AppLayout";

export default function makeApp(preloadedState, appCompose) {
  const store = createDucksStore(preloadedState, appCompose);

  function App() {
    return (
      <Provider store={store}>
        <AppLayout>
          <RootView />
        </AppLayout>
      </Provider>
    );
  }
  return App;
}
