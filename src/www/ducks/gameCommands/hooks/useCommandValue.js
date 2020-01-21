import { useDispatch, useSelect } from "../../../lib";
import { getEntityCommand, setCommand } from "../";

export function useCommandValue(entityId, type, fallbackValue) {
  const command = useSelect(getEntityCommand, { entityId, type });
  const value = command ? command.value : fallbackValue;
  const setValue = useDispatch(setCommand, entityId, type);
  return [value, setValue];
}
