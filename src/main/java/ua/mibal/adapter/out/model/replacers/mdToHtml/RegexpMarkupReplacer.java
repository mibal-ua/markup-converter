package ua.mibal.adapter.out.model.replacers.mdToHtml;

import ua.mibal.adapter.out.model.replacers.MarkupReplacer;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.MULTILINE;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public abstract class RegexpMarkupReplacer implements MarkupReplacer {
    private final String FIND_REGEXP;
    private final String REPLACE_REGEXP;

    protected RegexpMarkupReplacer(String findRegexp, String replaceRegexp) {
        FIND_REGEXP = findRegexp;
        REPLACE_REGEXP = replaceRegexp;
    }

    @Override
    public final String replace(String input) {
        return Pattern.compile(FIND_REGEXP, MULTILINE)
                .matcher(input)
                .replaceAll(REPLACE_REGEXP);
    }
}
