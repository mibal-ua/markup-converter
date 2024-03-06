package ua.mibal.adapter.out.model.replacers;

import org.springframework.stereotype.Component;
import ua.mibal.adapter.out.model.MarkupValidationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.MULTILINE;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@Component
public class ItalicTagMarkupReplacer extends RegexpMarkupReplacer {

    public ItalicTagMarkupReplacer() {
        super(
                "(?<=^| )\\b_(.+)_\\b",
                "<i>$1</i>"
        );
    }

    @Override
    protected void validate(String input) {
        Pattern pattern = Pattern.compile("_\\w.[^_]+\\b$", MULTILINE);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            MarkupValidationException parentException = new MarkupValidationException(
                    "Exception for markdown '_' tag"
            );
            do {
                String quote = matcher.group();
                parentException.addSuppressed(new MarkupValidationException(
                        "Markdown tag is not closed for fragment '" + quote + "'"
                ));
            } while (matcher.find());
            throw parentException;
        }
    }
}
