package ua.mibal.adapter.out.model.replacers;

import static java.text.MessageFormat.format;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public abstract class MdToHtmlTagMarkupReplacer extends RegexpMarkupReplacer {

    protected MdToHtmlTagMarkupReplacer(String mdTag, String htmlTag) {
        super(
                format("{0}(.*?){0}", mdTag),
                format("<{0}>$1</{0}>", htmlTag)
        );
    }
}
