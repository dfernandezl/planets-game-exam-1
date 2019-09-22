package com.drpicox.game.macros;

import com.drpicox.game.blog.BlogController;
import com.drpicox.game.interpreter.Instruction;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Component
@Order(1)
public class SkipTurnsMacro implements Macro {

    private Pattern IS_SKIP = Pattern.compile("^\\s+.*[Ss]kip\\s+turns\\s+from\\s+_(\\d+)_\\s+to\\s+_(\\d+)_");

    @Override
    public List<Instruction> decodeInstructions(String lineNumber, String instructionSource, RootMacroDecoder rootDecoder) {
        var matcher = IS_SKIP.matcher(instructionSource);
        if (!matcher.find()) return null;

        var sources = new ArrayList<String>();
        var start = Integer.parseInt(matcher.group(1));
        var end = Integer.parseInt(matcher.group(2));
        for (var turn = start + 1; turn <= end; turn += 1) {
            sources.add(" Click the _Compile_ button");
            sources.add(" <!-- SNAPSHOT skipping_" + start + ":" + end + "_" + turn + " status=200 -->");
            sources.add(" It is the turn number _" + turn + "_");
        }

        var result = rootDecoder.decodeInstructions(lineNumber + "[skip turns from "+start+" to "+end+"]:", 1, sources);
        return result;
    }

    private Function<String,String> parseReplacements(String query) {
        Function<String,String> result = s -> s;
        if (query == null) return result;

        query = query.substring(1);
        for (var replacement: query.split("&")) {
            var symbol = replacement.split("=")[0];
            var value = replacement.split("=")[1];
            result = result.andThen(text -> text.replace(symbol, value));
        }
        return result;
    }
}
