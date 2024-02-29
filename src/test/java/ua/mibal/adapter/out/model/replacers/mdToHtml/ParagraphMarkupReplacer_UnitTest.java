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
class ParagraphMarkupReplacer_UnitTest {

    private ParagraphMarkupReplacer replacer;


    @BeforeEach
    void setUp() {
        replacer = new ParagraphMarkupReplacer();
    }

    @ParameterizedTest
    @CsvSource({
            "line,                              <p>line</p>",
            "**line**,                          <p>**line**</p>",
            "'',                                ''",
            "'Two lines\nparagraph',            '<p>Two lines\nparagraph</p>'",
            "'Paragraph\n1\n\nParagraph\n2',    '<p>Paragraph\n1\n</p>\n<p>Paragraph\n2</p>'",
    })
    void replace(String source, String expected) {
        String actual = replacer.replace(source);

        assertEquals(expected, actual);
    }
}
