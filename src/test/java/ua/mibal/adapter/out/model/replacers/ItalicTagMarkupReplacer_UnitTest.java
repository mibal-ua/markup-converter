package ua.mibal.adapter.out.model.replacers;

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
class ItalicTagMarkupReplacer_UnitTest {

    private ItalicTagMarkupReplacer replacer;

    @BeforeEach
    void setUp() {
        replacer = new ItalicTagMarkupReplacer();
    }

    @ParameterizedTest
    @CsvSource({
            "_text inside_,         <i>text inside</i>",
            "_text_inside_,         <i>text_inside</i>",
            "_text-inside tags_,    <i>text-inside tags</i>",
            "text _inside_,         text <i>inside</i>",
            "'\n_text inside_\n',   '\n<i>text inside</i>\n'",
    })
    void replace(String source, String expected) {
        String actual = replacer.replace(source);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "_I love you",

            "_I love you_ _and her",

            "'_I love you\n'",

            "'_I love you\n" +
            "_and her_'",

            "'_I love you_\n" +
            "_aff'",
    })
    void validate(String input) {
        assertThrows(MarkupValidationException.class,
                () -> replacer.replace(input));
    }
}
