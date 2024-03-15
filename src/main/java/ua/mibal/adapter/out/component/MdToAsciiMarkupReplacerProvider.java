package ua.mibal.adapter.out.component;

import ua.mibal.adapter.out.model.MarkupReplacer;
import ua.mibal.adapter.out.model.ascii.BoldAsciiMarkupReplacer;
import ua.mibal.adapter.out.model.ascii.ItalicAsciiMarkupReplacer;
import ua.mibal.adapter.out.model.ascii.MonospacedAsciiMarkupReplacer;
import ua.mibal.adapter.out.model.ascii.PreformattedAsciiMarkupReplacer;
import ua.mibal.adapter.out.model.coding.decoding.PreformattedInnerTagsDecoderMarkupReplacer;
import ua.mibal.adapter.out.model.coding.encoding.PreformattedInnerTagsEncoderMarkupReplacer;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public class MdToAsciiMarkupReplacerProvider {

    public static MarkupReplacer[] provide() {
        return new MarkupReplacer[]{
                new PreformattedInnerTagsEncoderMarkupReplacer(),

                new MonospacedAsciiMarkupReplacer(),
                new BoldAsciiMarkupReplacer(),
                new ItalicAsciiMarkupReplacer(),

                new PreformattedInnerTagsDecoderMarkupReplacer(),
                new PreformattedAsciiMarkupReplacer(),
        };
    }
}
