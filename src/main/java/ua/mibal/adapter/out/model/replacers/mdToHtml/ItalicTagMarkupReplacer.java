package ua.mibal.adapter.out.model.replacers.mdToHtml;

import org.springframework.stereotype.Component;
import ua.mibal.adapter.out.model.replacers.RegexpMarkupReplacer;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@Component
public class ItalicTagMarkupReplacer extends RegexpMarkupReplacer {

    protected ItalicTagMarkupReplacer() {
        super(
                "\\b_(.+)_\\b",
                "<i>$1</i>"
        );
    }
}
