function indexBy(array, keyOrFn = "id") {
  const keyFn = typeof keyOrFn === "string" ? o => o[keyOrFn] : keyOrFn;
  const result = {};
  array.forEach(o => {
    const key = keyFn(o);
    result[key] = o;
  });
  return result;
}

export default indexBy;
