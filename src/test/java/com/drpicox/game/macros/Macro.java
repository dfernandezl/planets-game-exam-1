package com.drpicox.game.macros;

import com.drpicox.game.interpreter.Instruction;

import java.util.List;

public interface Macro {
    List<Instruction> decodeInstructions(String lineNumber, String instructionSource, RootMacroDecoder rootDecoder);
}
