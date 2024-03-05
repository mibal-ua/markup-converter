package ua.mibal.adapter.out.model.replacers;

import org.springframework.stereotype.Component;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@Component
public class ParagraphMarkupReplacer extends RegexpMarkupReplacer {

    public ParagraphMarkupReplacer() {
        super(
                "^((.\n?)+)($|(\n?\n))",
                "<p>$1</p>"
        );
    }

    @Override
    protected void validate(String input) {
        // do nothing, paragraph have no markdown tags
    }
}
