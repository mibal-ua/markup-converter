package ua.mibal.adapter.out.component;

import ua.mibal.adapter.out.model.replacers.BoldTagMarkupReplacer;
import ua.mibal.adapter.out.model.replacers.ItalicTagMarkupReplacer;
import ua.mibal.adapter.out.model.replacers.MarkupReplacer;
import ua.mibal.adapter.out.model.replacers.MonospacedTagMarkupReplacer;
import ua.mibal.adapter.out.model.replacers.ParagraphMarkupReplacer;
import ua.mibal.adapter.out.model.replacers.PreformattedTagMarkupReplacer;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public class MarkupReplacerProvider {

    public MarkupReplacer[] provide() {
        return new MarkupReplacer[]{
                new PreformattedTagMarkupReplacer(),
                new ParagraphMarkupReplacer(),

                new BoldTagMarkupReplacer(),
                new ItalicTagMarkupReplacer(),
                new MonospacedTagMarkupReplacer()
        };
    }
}
