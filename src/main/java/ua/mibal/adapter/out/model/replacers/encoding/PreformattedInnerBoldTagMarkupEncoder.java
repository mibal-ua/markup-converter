package ua.mibal.adapter.out.model.replacers.encoding;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public class PreformattedInnerBoldTagMarkupEncoder extends RegexMarkupEncoder {

    protected PreformattedInnerBoldTagMarkupEncoder() {
        super(

                "(^```\\n(.|\\n)+)\\*\\*(.+)\\*\\*(?=(.|\\n)+```($|\\n))",
                "$1<**>$3</**>"
        );
    }
}
