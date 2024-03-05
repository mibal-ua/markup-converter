package ua.mibal.adapter.out.model.replacers;

import org.springframework.stereotype.Component;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@Component
public class ItalicTagMarkupReplacer extends RegexpMarkupReplacer {

    public ItalicTagMarkupReplacer() {
        super(
                "\\b_(.+)_\\b",
                "<i>$1</i>"
        );
    }

    @Override
    protected void validate(String input) {
        // TODO
    }
}
