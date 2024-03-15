package ua.mibal.adapter.out;

import ua.mibal.adapter.out.model.MarkupReplacer;
import ua.mibal.adapter.out.model.ascii.BoldAsciiMarkupReplacer;
import ua.mibal.adapter.out.model.ascii.MonospacedAsciiMarkupReplacer;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public class MdToAsciiMarkupReplacerProvider {

    public static MarkupReplacer[] provide() {
        return new MarkupReplacer[]{
                new BoldAsciiMarkupReplacer(),
                new MonospacedAsciiMarkupReplacer(),
        };
    }
}
