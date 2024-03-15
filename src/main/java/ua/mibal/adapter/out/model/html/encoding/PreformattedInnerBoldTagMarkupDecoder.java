package ua.mibal.adapter.out.model.html.encoding;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public class PreformattedInnerBoldTagMarkupDecoder extends SimpleInnerTagMarkupDecoder {

    public PreformattedInnerBoldTagMarkupDecoder() {
        super(
                "\\*\\*",
                "**"
        );
    }
}
