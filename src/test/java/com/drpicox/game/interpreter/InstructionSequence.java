package com.drpicox.game.interpreter;

import java.util.ArrayList;
import java.util.List;

class InstructionSequence {
    private List<Instruction> instructions;
    private int currentIndex;

    public InstructionSequence(List<Instruction> instructions) {
        this.instructions = new ArrayList<>(instructions);
        this.currentIndex = 0;
    }

    public boolean hasNext() {
        return currentIndex < instructions.size();
    }

    public Instruction next() {
        var currentInstruction = instructions.get(currentIndex);
        currentIndex += 1;
        return currentInstruction;
    }

    public String getPreviousSource() {
        var previousIndex = currentIndex - 1;
        if (previousIndex < 0) return "null";

        return instructions.get(previousIndex).getSource();
    }

    public String getPreviousLine() {
        var previousIndex = currentIndex - 1;
        if (previousIndex < 0) return "-1";

        return instructions.get(previousIndex).getLine();
    }

    @Override
    public String toString() {
        var size = instructions.size();
        var previousIndex = currentIndex - 1;
        var result = new StringBuilder();

        var index = 0;
        while (index < previousIndex && index < size) {
            result.append("   √ ").append(instructions.get(index)).append('\n');
            index += 1;
        }

        if (index < size) {
            result.append(">  X ").append(instructions.get(index)).append('\n');
            index += 1;
        } else {
            result.append("> EOS\n");
        }

        while (index < size) {
            result.append("   · ").append(instructions.get(index)).append('\n');
            index += 1;
        }

        return result.toString();
    }

    public void deplete() {
        currentIndex = instructions.size() + 1;
    }
}
