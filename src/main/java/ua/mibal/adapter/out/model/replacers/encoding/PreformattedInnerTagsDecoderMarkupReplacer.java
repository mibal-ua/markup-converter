package ua.mibal.adapter.out.model.replacers.encoding;

import ua.mibal.adapter.out.model.replacers.MarkupReplacer;

import java.util.List;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public class PreformattedInnerTagsDecoderMarkupReplacer implements MarkupReplacer {
    private final List<MarkupDecoder> innerTagEncoderMarkupDecoders = List.of(
            new PreformattedInnerBoldTagMarkupDecoder(),
            new PreformattedInnerItalicTagMarkupDecoder(),
            new PreformattedInnerMonospacedTagMarkupDecoder()
    );

    @Override
    public String replace(String input) {
        String result = input;
        for (MarkupDecoder decoder : innerTagEncoderMarkupDecoders) {
            result = decoder.decode(result);
        }
        return result;
    }
}
