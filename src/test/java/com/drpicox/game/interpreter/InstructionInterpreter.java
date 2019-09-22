package com.drpicox.game.interpreter;

public interface InstructionInterpreter {
    void interpretInstruction(Instruction instruction, Context context);
}
