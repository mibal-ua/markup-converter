package ua.mibal.adapter.out.model.replacers.encoding;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public abstract class PreformattedInnerTagMarkupEncoder implements MarkupEncoder {
    private final String mdTag;

    public PreformattedInnerTagMarkupEncoder(String mdTag) {
        this.mdTag = mdTag;
    }

    @Override
    public final String encode(String rawInput) {
        int length = rawInput.length();
        for (int i = 0; i < length; i += 3) {
            char current = rawInput.charAt(i);
            char next = rawInput.charAt(i + 1);
            char doubleNext = rawInput.charAt(i + 2);
            if (current == '`' && next == '`' && doubleNext == '`') {

            }
        }


        return null;
    }
}
