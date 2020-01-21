/**
 * @param {array} array
 * @param {string | function} keyOrFn
 */
export function groupBy(array = [], keyOrFn = "id") {
  const keyFn = typeof keyOrFn === "string" ? o => o[keyOrFn] : keyOrFn;
  const result = {};
  array.forEach(o => {
    const key = keyFn(o);
    let items = result[key];
    if (!items) {
      items = [];
      result[key] = items;
    }
    items.push(o);
  });
  return result;
}
