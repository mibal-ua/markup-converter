package ua.mibal.adapter.out.component;

import ua.mibal.adapter.out.model.replacers.MarkupReplacer;
import ua.mibal.adapter.out.model.replacers.mdToHtml.first.PreformattedTagMarkupReplacer;
import ua.mibal.adapter.out.model.replacers.mdToHtml.second.BoldTagMarkupReplacer;
import ua.mibal.adapter.out.model.replacers.mdToHtml.second.ItalicTagMarkupReplacer;
import ua.mibal.adapter.out.model.replacers.mdToHtml.second.MonospacedTagMarkupReplacer;
import ua.mibal.adapter.out.model.replacers.mdToHtml.second.ParagraphMarkupReplacer;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public class MarkupReplacerProvider {

    public MarkupReplacer[] provide() {
        return new MarkupReplacer[] {
                new PreformattedTagMarkupReplacer(),
                new ParagraphMarkupReplacer(),

                new BoldTagMarkupReplacer(),
                new ItalicTagMarkupReplacer(),
                new MonospacedTagMarkupReplacer()
        };
    }
}
