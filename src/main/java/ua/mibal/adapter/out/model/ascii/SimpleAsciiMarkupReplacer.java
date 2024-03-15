package ua.mibal.adapter.out.model.ascii;

import ua.mibal.adapter.out.model.MarkupValidationException;
import ua.mibal.adapter.out.model.RegexpMarkupReplacer;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.text.MessageFormat.format;
import static java.util.regex.Pattern.MULTILINE;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public abstract class SimpleAsciiMarkupReplacer extends RegexpMarkupReplacer {
    private final String mdTag;

    public SimpleAsciiMarkupReplacer(String mdTag, int asciiCode) {
        super(
                format("{0}\\b([^{0}]+)\\b{0}", mdTag),
                format("ESC[{0}m$1ESC[{1}m", asciiCode, asciiCode + 20)
        );
        this.mdTag = mdTag;
    }

    @Override
    protected void validate(String input) {
        Pattern nestedTagsPattern = Pattern.compile(format("{0}((\\b_|ESC\\[3m\\b)|((((\\*\\*)|ESC\\[1m)|(`|ESC\\[7m))\\b))([^{0}]+)(((_\\b|\\bESC\\[23m))|(\\b((\\*\\*)|ESC\\[21m)|`|ESC\\[27m)){0}", mdTag), MULTILINE);
        Pattern notClosedPattern = Pattern.compile(format("{0}\\b([^{0}])*$", mdTag), MULTILINE);

        checkForViolation(input, Map.of(
                nestedTagsPattern, "Tags are nested",
                notClosedPattern, "Markdown tag is not closed"
        ));
    }

    private void checkForViolation(String input, Map<Pattern, String> patterns) {
        for (Map.Entry<Pattern, String> entry : patterns.entrySet()) {
            String message = entry.getValue();
            Pattern pattern = entry.getKey();

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                MarkupValidationException parentException = new MarkupValidationException(
                        "Exception for markdown '%s' tag".formatted(mdTag)
                );
                do {
                    String quote = matcher.group();
                    parentException.addSuppressed(new MarkupValidationException(
                            message + " for fragment '" + quote + "'"
                    ));
                } while (matcher.find());
                throw parentException;
            }
        }
    }
}
