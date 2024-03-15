package ua.mibal.adapter.out.model.coding.decoding;

import ua.mibal.adapter.out.model.MarkupDecoder;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.MULTILINE;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public abstract class RegexMarkupDecoder implements MarkupDecoder {
    private final String FIND_REGEXP;
    private final String REPLACE_REGEXP;

    protected RegexMarkupDecoder(String findRegexp, String replaceRegexp) {
        FIND_REGEXP = findRegexp;
        REPLACE_REGEXP = replaceRegexp;
    }

    @Override
    public final String decode(String encoded) {
        return Pattern.compile(FIND_REGEXP, MULTILINE)
                .matcher(encoded)
                .replaceAll(REPLACE_REGEXP);
    }
}
