import React from "react";
import useSelect from "../../../lib/useSelect";
import getView from "../selectors/getView";

function makeSubView(field, Views) {
  Views.null = Views.null || Views.undefined;
  Views.undefined = Views.undefined || Views.null;

  function makeUnknownView(viewName) {
    return () => `Unknown view name "${viewName}" for "${field}".`;
  }

  function SubView() {
    const viewName = useSelect(getView, field);
    const View = Views[`${viewName}`] || makeUnknownView(viewName);

    return <View />;
  }
  return SubView;
}

export default makeSubView;
