export const REPLACE_ALERT = "alert/REPLACE_ALERT";
export function replaceAlert(text) {
  return {
    type: REPLACE_ALERT,
    text
  };
}
