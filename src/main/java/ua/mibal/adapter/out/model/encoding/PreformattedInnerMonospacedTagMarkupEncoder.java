package ua.mibal.adapter.out.model.encoding;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public class PreformattedInnerMonospacedTagMarkupEncoder extends RegexMarkupEncoder {

    protected PreformattedInnerMonospacedTagMarkupEncoder() {
        super(
                "`\\b([^`]+)\\b`",
                "<`>$1</`>"
        );
    }
}
