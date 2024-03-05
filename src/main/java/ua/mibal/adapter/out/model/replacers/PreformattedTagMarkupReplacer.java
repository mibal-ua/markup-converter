package ua.mibal.adapter.out.model.replacers;

import org.springframework.stereotype.Component;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@Component
public class PreformattedTagMarkupReplacer extends RegexpMarkupReplacer {

    public PreformattedTagMarkupReplacer() {
        super(
                "^```\\n" +
                "(((.|\\n)*\\n)?)" +
                "```(?=($|\\n))",
                "<pre>\n$1</pre>"
        );
    }

    @Override
    protected void validate(String input) {
        // TODO
    }
}
