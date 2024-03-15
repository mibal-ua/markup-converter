package ua.mibal.adapter.out;

import ua.mibal.adapter.out.component.MdToAsciiMarkupReplacerProvider;
import ua.mibal.adapter.out.model.MarkupReplacer;
import ua.mibal.application.port.Converter;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public class MdToAsciiConverter implements Converter {
    private final MarkupReplacer[] markupReplacers = MdToAsciiMarkupReplacerProvider.provide();

    @Override
    public String convert(String input) {
        String result = input;
        for (MarkupReplacer replacer : markupReplacers) {
            result = replacer.replace(result);
        }
        return result;
    }
}
