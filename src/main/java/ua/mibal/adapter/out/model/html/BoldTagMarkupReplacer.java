package ua.mibal.adapter.out.model.html;


/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public class BoldTagMarkupReplacer extends SimpleTagMarkupReplacer {

    public BoldTagMarkupReplacer() {
        super("\\*\\*", "b");
    }
}
