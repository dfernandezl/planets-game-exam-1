import { useCallback, useState } from "react";

function useToggle() {
  const [value, setValue] = useState(false);
  const toggle = useCallback(() => setValue(!value), [value]);
  return [value, toggle];
}

export default useToggle;
