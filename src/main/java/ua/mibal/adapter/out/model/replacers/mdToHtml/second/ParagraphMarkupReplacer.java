package ua.mibal.adapter.out.model.replacers.mdToHtml.second;

import org.springframework.stereotype.Component;
import ua.mibal.adapter.out.model.replacers.mdToHtml.RegexpMarkupReplacer;
import ua.mibal.adapter.out.model.replacers.mdToHtml.SecondOrderMarkupReplacer;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@Component
public class ParagraphMarkupReplacer extends RegexpMarkupReplacer implements SecondOrderMarkupReplacer {

    public ParagraphMarkupReplacer() {
        super(
                "^((.\n?)+)($|(\n?\n))",
                "<p>$1</p>"
        );
    }
}
