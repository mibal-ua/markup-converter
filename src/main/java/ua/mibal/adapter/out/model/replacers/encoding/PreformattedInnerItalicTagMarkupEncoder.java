package ua.mibal.adapter.out.model.replacers.encoding;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public class PreformattedInnerItalicTagMarkupEncoder extends RegexMarkupEncoder {

    protected PreformattedInnerItalicTagMarkupEncoder() {
        super(
                "\\b_\\B([^_<>]+)\\B_\\b",
                "<_>$1</_>"
        );
    }
}
