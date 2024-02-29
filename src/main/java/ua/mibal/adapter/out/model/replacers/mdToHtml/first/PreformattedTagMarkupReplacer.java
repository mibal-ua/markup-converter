package ua.mibal.adapter.out.model.replacers.mdToHtml.first;

import org.springframework.stereotype.Component;
import ua.mibal.adapter.out.model.replacers.mdToHtml.FirstOrderMarkupReplacer;
import ua.mibal.adapter.out.model.replacers.mdToHtml.RegexpMarkupReplacer;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@Component
public class PreformattedTagMarkupReplacer extends RegexpMarkupReplacer implements FirstOrderMarkupReplacer {

    public PreformattedTagMarkupReplacer() {
        super(
                "^```\\n" +
                "(((.|\\n)*\\n)?)" +
                "```(?=($|\\n))",
                "<pre>\n$1</pre>"
        );
    }
}