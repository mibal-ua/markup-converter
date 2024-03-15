package ua.mibal.adapter.out.model.encoding;

import ua.mibal.adapter.out.model.MarkupEncoder;
import ua.mibal.adapter.out.model.MarkupReplacer;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.MULTILINE;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public class PreformattedInnerTagsEncoderMarkupReplacer implements MarkupReplacer {
    private final List<MarkupEncoder> innerTagEncoderMarkupEncoders = List.of(
            new PreformattedInnerBoldTagMarkupEncoder(),
            new PreformattedInnerItalicTagMarkupEncoder(),
            new PreformattedInnerMonospacedTagMarkupEncoder()
    );

    @Override
    public String replace(String input) {
        Pattern pattern = Pattern.compile("^```\\n" +
                                          "(((.|\\n)*\\n)?)" +
                                          "```(?=($|\\n))", MULTILINE);
        Matcher matcher = pattern.matcher(input);

        String result = input;
        for (MatchResult match : matcher.results().toList()) {
            result = replaceOccurrence(match, input);
        }
        return result;
    }

    private String replaceOccurrence(MatchResult match, String input) {
        String before = input.substring(0, match.start());
        String after = input.substring(match.end(), input.length());

        String protectedContent = protect(match.group());
        return before + protectedContent + after;
    }

    private String protect(String content) {
        String result = content;
        for (MarkupEncoder encoder : innerTagEncoderMarkupEncoders) {
            result = encoder.encode(result);
        }
        return result;
    }
}
