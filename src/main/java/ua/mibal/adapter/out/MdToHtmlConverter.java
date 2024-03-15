package ua.mibal.adapter.out;

import ua.mibal.adapter.out.component.MdToHtmlMarkupReplacerProvider;
import ua.mibal.adapter.out.model.MarkupReplacer;
import ua.mibal.application.port.Converter;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public class MdToHtmlConverter implements Converter {
    private final MarkupReplacer[] markupReplacers = MdToHtmlMarkupReplacerProvider.provide();

    @Override
    public String convert(String input) {
        String result = input;
        for (MarkupReplacer replacer : markupReplacers) {
            result = replacer.replace(result);
        }
        return result;
    }
}
