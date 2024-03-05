package ua.mibal.adapter.out;

import ua.mibal.adapter.out.component.MarkupReplacerProvider;
import ua.mibal.adapter.out.model.replacers.MarkupReplacer;
import ua.mibal.application.port.Converter;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public class MdToHtmlConverter implements Converter {
    private final MarkupReplacerProvider markupReplacerProvider;

    public MdToHtmlConverter(MarkupReplacerProvider markupReplacerProvider) {
        this.markupReplacerProvider = markupReplacerProvider;
    }

    @Override
    public String convert(String input) {
        String result = input;
        for (MarkupReplacer replacer : markupReplacerProvider.provide()) {
            result = replacer.replace(result);
        }
        return result;
    }
}
