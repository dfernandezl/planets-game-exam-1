package com.drpicox.game.interpreter;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

class FileTokenizer {

    private String[] textLines;
    private int currentIndex;

    FileTokenizer(String file) {
        textLines = file.lines().toArray(String[]::new);
        currentIndex = 0;
    }

    boolean eof() {
        return currentIndex >= textLines.length;
    }

    int getLineNumber() {
        return currentIndex + 1;
    }

    String match(String regExp) {
        if (this.eof()) return null;
        var currentTextLine = textLines[currentIndex];

        var pattern = Pattern.compile(regExp);
        var isMatch = pattern.matcher(currentTextLine).find(0);
        if (!isMatch) return null;

        return currentTextLine;
    }

    FileTokenizer skipUntil(String regExp) {
        var match = this.match(regExp);
        while (match == null && !this.eof()) {
            currentIndex += 1;
            match = this.match(regExp);
        }
        return this;
    }

    String accept() {
        return this.accept(".*");
    }

    String accept(String regExp) {
        var result = this.match(regExp);
        if (result == null) return null;

        currentIndex += 1;
        return result;
    }

    List<String> acceptUntil(String regExp) {
        var result = new LinkedList<String>();
        var match = this.match(regExp);
        while (match == null && !this.eof()) {
            result.add(textLines[currentIndex]);
            currentIndex += 1;
            match = this.match(regExp);
        }
        return result;
    }
}
