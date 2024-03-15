package ua.mibal.adapter.out.model.ascii;


/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public class BoldAsciiMarkupReplacer extends SimpleAsciiMarkupReplacer {

    public BoldAsciiMarkupReplacer() {
        super("\\*\\*", 1);
    }
}
