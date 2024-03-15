package ua.mibal.adapter.out.model.encoding;

import ua.mibal.adapter.out.model.MarkupEncoder;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public class PreformattedInnerItalicTagMarkupEncoder extends RegexMarkupEncoder {
    private final MarkupEncoder italicSnakeCaseMarkupEncoder = new RegexMarkupEncoder(
            "\\b_\\B([^ <>]+)\\B_\\b",
            "<_>$1</_>"
    ) {
    };

    protected PreformattedInnerItalicTagMarkupEncoder() {
        super(
                "\\b_\\B([^_<>]+)\\B_\\b",
                "<_>$1</_>"
        );
    }

    @Override
    public String encode(String input) {
        String result = super.encode(input);
        return italicSnakeCaseMarkupEncoder.encode(result);
    }
}
