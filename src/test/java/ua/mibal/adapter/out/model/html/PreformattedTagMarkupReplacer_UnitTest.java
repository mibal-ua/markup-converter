package ua.mibal.adapter.out.model.html;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ua.mibal.adapter.out.model.MarkupValidationException;
import ua.mibal.test.annotation.UnitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@UnitTest
class PreformattedTagMarkupReplacer_UnitTest {

    private PreformattedTagMarkupReplacer replacer;

    @BeforeEach
    void setUp() {
        replacer = new PreformattedTagMarkupReplacer();
    }

    @ParameterizedTest
    @CsvSource({
            "'```\n preformatted \n```',            '<pre>\n preformatted \n</pre>'",
            "'```\n```',                            '<pre>\n</pre>'",
            "'```\npreformatted\nsecond line\n```', '<pre>\npreformatted\nsecond line\n</pre>'",
            "'\n```\n preformatted \n```',          '\n<pre>\n preformatted \n</pre>'",
            "'```\n preformatted \n```\n',          '<pre>\n preformatted \n</pre>\n'",
    })
    void replace(String source, String expected) {
        String actual = replacer.replace(source);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "'```\n" +
            "I love you'",

            "'```\n" +
            "I love you\n" +
            "```\n" +
            "```\n" +
            "I love you'"
    })
    void validate(String input) {
        assertThrows(MarkupValidationException.class,
                () -> replacer.replace(input));
    }
}
