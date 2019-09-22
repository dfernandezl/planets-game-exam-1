const ordinals = [
  "first",
  "second",
  "third",
  "fourth",
  "fifth",
  "sixth",
  "seventh",
  "eigth",
  "nineth",
  "tenth",
];

export function getOrdinalIndex(ordinal) {
  const index = ordinals.indexOf(ordinal);
  if (index === -1) return +ordinal - 1;
  return index;
}
