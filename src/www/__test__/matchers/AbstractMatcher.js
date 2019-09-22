export default class AbstractMatcher {
  constructor(regExp) {
    this._regExp = regExp;
  }

  match({ source }) {
    return source.match(this._regExp);
  }

  interpretMatch(match, instruction, context) {
    throw new Error(
      `Unimplemented method ${this.constructor.name}.interpretMatch(…)`
    );
  }
}
