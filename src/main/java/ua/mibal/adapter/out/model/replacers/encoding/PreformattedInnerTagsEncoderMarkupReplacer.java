package ua.mibal.adapter.out.model.replacers.encoding;

import ua.mibal.adapter.out.model.replacers.MarkupReplacer;

import java.util.List;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public class PreformattedInnerTagsEncoderMarkupReplacer implements MarkupReplacer {
    private final List<MarkupEncoder> innerTagEncoderMarkupEncoders = List.of(
            new PreformattedInnerBoldTagMarkupEncoder(),
            new PreformattedInnerItalicTagMarkupEncoder(),
            new PreformattedInnerMonospacedTagMarkupEncoder()
    );

    @Override
    public String replace(String input) {
        String result = input;
        for (MarkupEncoder encoder : innerTagEncoderMarkupEncoders) {
            result = encoder.encode(result);
        }
        return result;
    }
}
