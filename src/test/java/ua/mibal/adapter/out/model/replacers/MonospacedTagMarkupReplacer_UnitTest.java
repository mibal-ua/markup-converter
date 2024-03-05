package ua.mibal.adapter.out.model.replacers;

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
class MonospacedTagMarkupReplacer_UnitTest {

    private MonospacedTagMarkupReplacer replacer;

    @BeforeEach
    void setUp() {
        replacer = new MonospacedTagMarkupReplacer();
    }

    @ParameterizedTest
    @CsvSource({
            "`monospaced`,                  <tt>monospaced</tt>",
            "simple `monospaced text`,      simple <tt>monospaced text</tt>",
            "simple `monospaced ` text`,    simple <tt>monospaced ` text</tt>",
    })
    void replace(String source, String expected) {
        String actual = replacer.replace(source);

        assertEquals(expected, actual);
    }
}
