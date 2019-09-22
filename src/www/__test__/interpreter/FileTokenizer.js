export default class FileTokenizer {
  constructor(file) {
    this._textLines = file.split("\n");
    this._currentIndex = 0;
  }

  eof() {
    return this._currentIndex >= this._textLines.length;
  }

  getLineNumber() {
    return this._currentIndex + 1;
  }

  match(regExp = /.*/) {
    const textLine = this._textLines[this._currentIndex];
    const result = textLine && textLine.match(regExp);
    return result && textLine;
  }

  accept(regExp) {
    const match = this.match(regExp);
    if (match) {
      this._currentIndex += 1;
    }
    return match;
  }

  skipUntil(regExp) {
    let match = this.match(regExp);
    while (!match && !this.eof()) {
      this._currentIndex += 1;
      match = this.match(regExp);
    }
  }

  acceptUntil(regExp) {
    const result = [];
    let match = this.match(regExp);
    while (!match && !this.eof()) {
      result.push(this._textLines[this._currentIndex]);
      this._currentIndex += 1;
      match = this.match(regExp);
    }
    return result;
  }

  toString() {
    const textLines = this._textLines;
    const count = textLines.length;
    const currentIndex = this._currentIndex;
    const result = [];

    let index = 0;
    while (index < currentIndex && index < count) {
      result.push(`  ${this._format(index, textLines)}`);
      index += 1;
    }

    if (index < count) {
      result.push(`> ${this._format(index, textLines)}`);
      index += 1;
    } else {
      result.push(`> EOF`);
    }

    while (index < count) {
      result.push(`  ${this._format(index, textLines)}`);
      index += 1;
    }

    return result.join("\n");
  }

  _format(index, textLines) {
    const lineNumber = index + 1;
    const lineText = textLines[index];
    return `${`    ${lineNumber}`.slice(-5)}: ${lineText}`;
  }
}
