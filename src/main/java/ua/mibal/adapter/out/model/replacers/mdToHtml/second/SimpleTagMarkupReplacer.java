package ua.mibal.adapter.out.model.replacers.mdToHtml.second;

import ua.mibal.adapter.out.model.replacers.RegexpMarkupReplacer;
import ua.mibal.adapter.out.model.replacers.mdToHtml.SecondOrderMarkupReplacer;

import static java.text.MessageFormat.format;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public abstract class SimpleTagMarkupReplacer extends RegexpMarkupReplacer implements SecondOrderMarkupReplacer {

    public SimpleTagMarkupReplacer(String mdTag, String htmlTag) {
        super(
                format("{0}\\b(.+)\\b{0}", mdTag),
                format("<{0}>$1</{0}>", htmlTag)
        );
    }
}
