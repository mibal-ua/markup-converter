package ua.mibal.adapter.out.model.replacers;

import ua.mibal.adapter.out.model.MarkupValidationException;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.MULTILINE;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public class ItalicTagMarkupReplacer extends RegexpMarkupReplacer {
    private final MarkupReplacer italicSnakeCaseMarkupReplacer = new RegexpMarkupReplacer(
            "\\b_\\B([^ ><]+)\\B_\\b",
            "<i>$1</i>"
    ) {
        @Override
        protected void validate(String input) {
        }
    };

    public ItalicTagMarkupReplacer() {
        super(
                "\\b_\\B([^_><]+)\\B_\\b",
                "<i>$1</i>"
        );
    }

    @Override
    public String replace(String input) {
        String result = super.replace(input);
        return italicSnakeCaseMarkupReplacer.replace(result);
    }

    @Override
    protected void validate(String input) {
        Pattern notClosedAtTheEndPattern = Pattern.compile("\\b_\\B[^_]+\\b(?!.*\\B_\\b)", MULTILINE);
        Pattern notClosedAtTheMiddlePattern = Pattern.compile("\\b_\\B[^_]+\\b(?=\\b_\\B[^_><]+\\B_\\b)", MULTILINE);

        checkForViolation(input, Map.of(
                notClosedAtTheEndPattern, "Markdown tag is not closed",
                notClosedAtTheMiddlePattern, "Markdown tag is not closed"
        ));
    }

    private void checkForViolation(String input, Map<Pattern, String> patterns) {
        for (Map.Entry<Pattern, String> entry : patterns.entrySet()) {
            String message = entry.getValue();
            Pattern pattern = entry.getKey();

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                MarkupValidationException parentException = new MarkupValidationException(
                        "Exception for markdown '_' tag"
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
