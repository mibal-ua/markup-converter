package ua.mibal.adapter.out.model.html;

import ua.mibal.adapter.out.model.MarkupValidationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.MULTILINE;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public class PreformattedTagMarkupReplacer extends RegexpMarkupReplacer {

    public PreformattedTagMarkupReplacer() {
        super(
                "^```\\n" +
                "(((.|\\n)*\\n)?)" +
                "```(?=($|\\n))",
                "<pre>\n$1</pre>"
        );
    }

    @Override
    protected void validate(String input) {
        Pattern pattern = Pattern.compile("^```$", MULTILINE);
        Matcher matcher = pattern.matcher(input);

        long foundCount = matcher.results().count();
        if (isOdd(foundCount)) {
            throw new MarkupValidationException(
                    "Exception for markdown '```' tag: Markdown tag is not closed"
            );
        }
    }

    private boolean isOdd(long n) {
        return n % 2 == 1;
    }
}
