function range(start, count) {
  if (count === undefined) {
    count = start;
    start = 0;
  }
  const result = [];
  for (let i = 0; i < count; i += 1) result.push(i + start);
  return result;
}

export default range;
