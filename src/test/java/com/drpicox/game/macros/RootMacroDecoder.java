package com.drpicox.game.macros;

import com.drpicox.game.interpreter.Instruction;

import java.util.List;

public interface RootMacroDecoder {
    List<Instruction> decodeInstructions(String pre, int lineNumber, List<String> instructionSources);
}
