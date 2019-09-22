import chalk from "chalk";
const highlight = chalk.bgYellowBright.black.bold;

let contextId = 0;
export default class Context {
  contextId = contextId++;
  set = (key, value) => {
    this[key] = value;
    return this;
  };

  wantFor = key => {
    if (!(key in this))
      throw new Error(
        `Expected key ${highlight(
          `"${key}" to appear inside the context`,
        )} but it does not. Available keys are \n - "${Object.keys(this)
          .sort()
          .join('"\n - "')}"`,
      );
    return this[key];
  };

  clone = () => {
    const clone = new Context();
    Object.keys(this).forEach(key => {
      if (!(key in clone)) clone[key] = this[key];
    });
    return clone;
  };
}
