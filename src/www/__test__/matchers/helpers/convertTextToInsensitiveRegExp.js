import escapeStringRegexp from "escape-string-regexp";

export function convertTextToInsensitiveRegExp(text) {
  return new RegExp(escapeStringRegexp(text), "i");
}
