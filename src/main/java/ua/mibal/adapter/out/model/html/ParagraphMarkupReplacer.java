package ua.mibal.adapter.out.model.html;


/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
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
