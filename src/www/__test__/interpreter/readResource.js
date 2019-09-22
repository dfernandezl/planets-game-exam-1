import path from "path";
import fs from "fs";

export default function readResource(folder, name) {
  var fullName = path.join(
    __dirname,
    "..",
    "..",
    "..",
    "..",
    "target",
    "classes",
    folder,
    name,
  );
  var content = fs.readFileSync(fullName, { encoding: "utf8" });
  return content;
}
