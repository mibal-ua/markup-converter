package ua.mibal.adapter.out;

import ua.mibal.adapter.out.model.replacers.MarkupReplacer;
import ua.mibal.application.port.Converter;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public class MdToAsciiConverter implements Converter {
    private final MarkupReplacer[] markupReplacers = MdToAsciiMarkupReplacerProvider.provide();

    @Override
    public String convert(String input) {
        // TODO
        return null;
    }
}
