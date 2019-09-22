package com.drpicox.game.interpreter;

import org.junit.jupiter.api.DynamicTest;
import org.springframework.stereotype.Component;

@Component
class TestInterpreter {

    public DynamicTest interpretTest(String title, Context testContext, InstructionSequence instructionSequence) {
        return DynamicTest.dynamicTest(title, () -> {
            try {
                testContext.doBeforeEach();
            } catch (Throwable th) {
                throw new RuntimeException("No steps have been executed yet, test failed in an beforeEach()", th);
            }
            try {
                this.interpretTest(testContext, instructionSequence);
            } catch (Throwable e) {
                var snapshot = testContext.get(Snapshot.class);
                var message = new StringBuilder();
                message.append("Test failed at ");
                message.append(instructionSequence.getPreviousLine());
                message.append(" «");
                message.append(instructionSequence.getPreviousSource().trim());
                message.append("»:\n");
                message.append(instructionSequence);

                if (snapshot != null) {
                    message.append("\n\nLast Snapshot:\n");
                    message.append("  request        : ");
                    message.append(snapshot.getMethod());
                    message.append(" ");
                    message.append(snapshot.getUrl());
                    message.append("\n");
                    message.append("  request body   : ").append(snapshot.getRequest()).append("\n");
                    message.append("  response status: ").append(snapshot.getStatus()).append("\n");
                    message.append("  response body  : ").append(snapshot.getResponse()).append("\n");
                }

                message.append("\n\nContext:\n");
                for (var key: testContext.keys()) {
                    if (key.startsWith("com.drpicox.game.")) continue;
                    message.append("  ");
                    message.append(key);
                    if (key.length() < 15)
                        message.append("               ".substring(key.length()));
                    message.append(": ");
                    message.append(testContext.get(key).toString());
                    message.append("\n");
                }

                throw new RuntimeException(message.toString(), e);
            }
            try {
                testContext.doAfterEach();
            } catch (Throwable th) {
                throw new RuntimeException("All test steps have been executed correctly but the test failed in an afterEach()", th);
            }

            System.out.println("SUCCESS:");
            instructionSequence.deplete();
            System.out.print(instructionSequence);
        });
    }

    private void interpretTest(Context context, InstructionSequence instructionSequence) {
        while (instructionSequence.hasNext()) {
            var instruction = instructionSequence.next();
            instruction.interpret(context);
        }
    }
}
