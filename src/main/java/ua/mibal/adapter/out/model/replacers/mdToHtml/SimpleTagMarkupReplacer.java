package ua.mibal.adapter.out.model.replacers.mdToHtml;

import ua.mibal.adapter.out.model.replacers.RegexpMarkupReplacer;

import static java.text.MessageFormat.format;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public abstract class SimpleTagMarkupReplacer extends RegexpMarkupReplacer {

    protected SimpleTagMarkupReplacer(String mdTag, String htmlTag) {
        super(
                format("{0}\\b(.+)\\b{0}", mdTag),
                format("<{0}>$1</{0}>", htmlTag)
        );
    }
}
