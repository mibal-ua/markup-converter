package ua.mibal.adapter.out;

import org.springframework.stereotype.Component;
import ua.mibal.adapter.out.model.replacers.MarkupReplacer;
import ua.mibal.adapter.out.model.replacers.mdToHtml.FirstOrderMarkupReplacer;
import ua.mibal.adapter.out.model.replacers.mdToHtml.SecondOrderMarkupReplacer;
import ua.mibal.application.port.Converter;

import java.util.List;

import static ua.mibal.adapter.out.util.CollectionUtils.union;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@Component
public class MdToHtmlConverter implements Converter {
    private final List<MarkupReplacer> markupReplacers;

    public MdToHtmlConverter(List<FirstOrderMarkupReplacer> firstOrderMarkupReplacers,
                             List<SecondOrderMarkupReplacer> secondOrderMarkupReplacers) {
        this.markupReplacers = union(firstOrderMarkupReplacers, secondOrderMarkupReplacers);
    }

    @Override
    public String convert(String input) {
        String result = input;
        for (MarkupReplacer replacer : markupReplacers) {
            result = replacer.replace(result);
        }
        return result;
    }
}
