package ua.mibal.adapter.out.model.replacers.mdToHtml;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ua.mibal.test.annotation.UnitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
            "'```\n preformatted \n```',    '<pre>\n preformatted \n</pre>'",
            "'```\n```',                    '<pre>\n</pre>'",
    })
    void replace(String source, String expected) {
        String actual = replacer.replace(source);

        assertEquals(expected, actual);
    }
}
