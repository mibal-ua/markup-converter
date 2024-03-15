package ua.mibal.adapter.out.model.html;

import ua.mibal.adapter.out.model.MarkupValidationException;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.text.MessageFormat.format;
import static java.util.regex.Pattern.MULTILINE;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public abstract class SimpleTagMarkupReplacer extends RegexpMarkupReplacer {
    private final String mdTag;

    public SimpleTagMarkupReplacer(String mdTag, String htmlTag) {
        super(
                format("{0}\\b([^{0}]+)\\b{0}", mdTag),
                format("<{0}>$1</{0}>", htmlTag)
        );
        this.mdTag = mdTag;
    }

    @Override
    protected void validate(String input) {
        Pattern nestedTagsPattern = Pattern.compile(format("{0}((\\b_|<i>\\b)|((((\\*\\*)|<b>)|(`|<tt>))\\b))([^{0}]+)(((_\\b|\\b<\\/i>))|(\\b((\\*\\*)|<\\/b>)|`|<\\/tt>)){0}", mdTag), MULTILINE);
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
