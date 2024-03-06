package ua.mibal.adapter.out.component;

import ua.mibal.adapter.out.model.replacers.BoldTagMarkupReplacer;
import ua.mibal.adapter.out.model.replacers.ItalicTagMarkupReplacer;
import ua.mibal.adapter.out.model.replacers.MarkupReplacer;
import ua.mibal.adapter.out.model.replacers.MonospacedTagMarkupReplacer;
import ua.mibal.adapter.out.model.replacers.ParagraphMarkupReplacer;
import ua.mibal.adapter.out.model.replacers.PreformattedTagMarkupReplacer;
import ua.mibal.adapter.out.model.replacers.encoding.PreformattedInnerTagsDecoderMarkupReplacer;
import ua.mibal.adapter.out.model.replacers.encoding.PreformattedInnerTagsEncoderMarkupReplacer;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public class MarkupReplacerProvider {

    public MarkupReplacer[] provide() {
        return new MarkupReplacer[]{
                new PreformattedInnerTagsEncoderMarkupReplacer(),

                new BoldTagMarkupReplacer(),
                new ItalicTagMarkupReplacer(),
                new MonospacedTagMarkupReplacer(),

                new PreformattedInnerTagsDecoderMarkupReplacer(),
                new PreformattedTagMarkupReplacer(),

                new ParagraphMarkupReplacer(),
        };
    }
}
