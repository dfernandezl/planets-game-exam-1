package com.drpicox.game.matchers;

import com.drpicox.game.interpreter.Context;
import com.drpicox.game.interpreter.Instruction;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AllMatchers {

    private List<InstructionMatcher> instructionMatchers;

    public AllMatchers(List<InstructionMatcher> instructionMatchers) {
        this.instructionMatchers = instructionMatchers;
    }

    public void interpretInstruction(Instruction instruction, Context context) {
        var source = instruction.getSource();
        var preCandidates = instructionMatchers.stream()
                .map(c -> c.match(source))
                .filter(mr -> mr != null)
                .collect(Collectors.toList());

        var candidates = preCandidates.stream()
                .filter(mr -> mr.getInstructionMatcher().getPrecondition().test(context))
                .collect(Collectors.toList());

        if (candidates.size() == 0) {
            var message = new StringBuilder();
            message.append("There is no instruction matcher matching for.\n");
            message.append("  source   : '").append(source).append("'\n");
            if (preCandidates.size() > 0) {
                message.append("  context  : ").append(context.keys()).append("\n");
                preCandidates.stream()
                        .map(mr -> mr.getInstructionMatcher())
                        .forEach(im -> message.append("  candidate: ").append(im.getClass().getName()).append("\n"));
            }
            throw new Error(message.toString());
        }

        var largestMatch = candidates.stream().map(m -> m.size()).max(Math::max).get();
        candidates = candidates.stream()
                .filter(m -> m.size() == largestMatch)
                .collect(Collectors.toList());

        if (candidates.size() > 1)
            throw new Error("There is more than one matcher for '"+source+"' and context " + context.keys());

        var match = candidates.get(0);
        match.interpretInstruction(instruction, context);
    }
}
