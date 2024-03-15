package ua.mibal.adapter.out.component;

import ua.mibal.adapter.out.model.MarkupReplacer;
import ua.mibal.adapter.out.model.coding.decoding.PreformattedInnerTagsDecoderMarkupReplacer;
import ua.mibal.adapter.out.model.coding.encoding.PreformattedInnerTagsEncoderMarkupReplacer;
import ua.mibal.adapter.out.model.html.BoldTagMarkupReplacer;
import ua.mibal.adapter.out.model.html.ItalicTagMarkupReplacer;
import ua.mibal.adapter.out.model.html.MonospacedTagMarkupReplacer;
import ua.mibal.adapter.out.model.html.ParagraphMarkupReplacer;
import ua.mibal.adapter.out.model.html.PreformattedTagMarkupReplacer;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public class MdToHtmlMarkupReplacerProvider {

    public static MarkupReplacer[] provide() {
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
