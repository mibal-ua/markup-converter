package ua.mibal.adapter.out.model.encoding;

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
class PreformattedInnerBoldTagMarkupEncoder_UnitTest {

    private PreformattedInnerBoldTagMarkupEncoder encoder;


    @BeforeEach
    void setUp() {
        encoder = new PreformattedInnerBoldTagMarkupEncoder();
    }

    @ParameterizedTest
    @CsvSource({
            // input
            "'```\n" +
            "Цей текст є преформатований. \n" +
            "   Це означає, що він відобразиться, як є, і жодне інше форматування, як от **жирний** чи _курсив_ на нього не \n" +
            "впливає.          А ще тут усі пробіли, відступи та перенесення рядка зберігаються як є\n" +
            "```', " +
            // expected
            "'```\n" +
            "Цей текст є преформатований. \n" +
            "   Це означає, що він відобразиться, як є, і жодне інше форматування, як от <**>жирний</**> чи _курсив_ на нього не \n" +
            "впливає.          А ще тут усі пробіли, відступи та перенесення рядка зберігаються як є\n" +
            "```'",
    })
    void encode(String input, String expected) {
        String actual = encoder.encode(input);

        assertEquals(expected, actual);
    }
}
