package ua.mibal.adapter.out.model.replacers.encoding;

import java.text.MessageFormat;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public abstract class SimpleInnerTagMarkupDecoder extends RegexMarkupDecoder {

    protected SimpleInnerTagMarkupDecoder(String encodedTag, String htmlTag) {
        super(
                MessageFormat.format("<{0}>([^<>]+)</{0}>", encodedTag),
                MessageFormat.format("{0}$1{0}", htmlTag)
        );
    }
}
