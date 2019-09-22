import escapeStringRegexp from "escape-string-regexp";

export default function convertTextToInsensitiveRegExp(text) {
  return new RegExp(escapeStringRegexp(text), "i");
}
