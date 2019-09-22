function mapEach(ob, mapFn) {
  const result = {};
  Object.keys(ob).forEach(key => {
    result[key] = mapFn(ob[key], key, ob);
  });
  return result;
}

export default mapEach;
