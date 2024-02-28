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
class BoldTagMarkupReplacer_UnitTest {

    private BoldTagMarkupReplacer replacer;

    @BeforeEach
    void setUp() {
        replacer = new BoldTagMarkupReplacer();
    }

    @ParameterizedTest
    @CsvSource({
            "**I love you**,                                <b>I love you</b>",
            "'\n**I love you**',                            '\n<b>I love you</b>'",
            "What do you prefer **Stubbing or mocking**?,   What do you prefer <b>Stubbing or mocking</b>?",
    })
    void replace(String source, String expected) {
        String actual = replacer.replace(source);

        assertEquals(expected, actual);
    }
}
