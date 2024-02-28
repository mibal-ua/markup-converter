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
class ItalicTagMarkupReplacer_UnitTest {

    private ItalicTagMarkupReplacer replacer;

    @BeforeEach
    void setUp() {
        replacer = new ItalicTagMarkupReplacer();
    }

    @ParameterizedTest
    @CsvSource({
            "_text inside_,         <i>text inside</i>",
            "'\n_text inside_\n',   '\n<i>text inside</i>\n'",
            "text _inside_,         text <i>inside</i>",
    })
    void replace(String source, String expected) {
        String actual = replacer.replace(source);

        assertEquals(expected, actual);
    }
}
