package ua.mibal.adapter.out.model.replacers.mdToHtml;

import org.springframework.stereotype.Component;
import ua.mibal.adapter.out.model.replacers.MdToHtmlTagMarkupReplacer;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@Component
public class BoldTagMarkupReplacer extends MdToHtmlTagMarkupReplacer {

    public BoldTagMarkupReplacer() {
        super("\\*\\*", "b");
    }
}
