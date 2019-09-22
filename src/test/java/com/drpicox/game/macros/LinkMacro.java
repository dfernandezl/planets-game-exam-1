package com.drpicox.game.macros;

import com.drpicox.game.blog.BlogController;
import com.drpicox.game.interpreter.Instruction;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Component
public class LinkMacro implements Macro {

    private Pattern IS_LINK = Pattern.compile("\\[[^\\]]*\\]\\(\\?root=Blog&postId=([^&#]+)(&[^#]+)?#(.+)\\)");

    private BlogController blogController;

    public LinkMacro(BlogController blogController) {
        this.blogController = blogController;
    }

    @Override
    public List<Instruction> decodeInstructions(String lineNumber, String instructionSource, RootMacroDecoder rootDecoder) {
        var matcher = IS_LINK.matcher(instructionSource);
        if (!matcher.find()) return null;

        var postId = matcher.group(1);
        var section = matcher.group(3);
        var replace = parseReplacements(matcher.group(2));

        try {
            var macroedText = blogController.getPost(postId).getSection(section);
            macroedText = replace.apply(macroedText);
            var sources = macroedText.lines().collect(Collectors.toList());
            var result = rootDecoder.decodeInstructions(lineNumber + ":[?" + postId + "#" + section + "]:", 1, sources);
            return result;
        } catch (Exception reason) {
            throw new RuntimeException("Cannot parse link " + instructionSource, reason);
        }
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
