import React from "react";
import { Provider } from "react-redux";
import { createDucksStore } from "./ducks";
import { RootView } from "./views";
import { AppLayout } from "./layout";

export function makeApp(preloadedState, appCompose) {
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
