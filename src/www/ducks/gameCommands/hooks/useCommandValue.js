import useSelect from "../../../lib/useSelect";
import getEntityCommand from "../selectors/getEntityCommand";
import useDispatch from "../../../lib/useDispatch";
import { setCommand } from "../actions/setCommand";

export function useCommandValue(entityId, type, fallbackValue) {
  const command = useSelect(getEntityCommand, { entityId, type });
  const value = command ? command.value : fallbackValue;
  const setValue = useDispatch(setCommand, entityId, type);
  return [value, setValue];
}
