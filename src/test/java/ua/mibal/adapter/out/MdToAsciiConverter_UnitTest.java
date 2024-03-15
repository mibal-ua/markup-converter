package ua.mibal.adapter.out;

import org.junit.jupiter.api.Test;
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
class MdToAsciiConverter_UnitTest {

    private final MdToAsciiConverter converter = new MdToAsciiConverter();

    @Test
    void convert() {
        String input = """
                Це текст у форматі Markdown. В межах нашої роботи ми розглядаємо дуже урізану підмножину цієї мови розмітки. Текст можна розділяти на абзаци, лишаючи між абзацами 1 (один) порожній рядок.
                            
                Ми можемо виділяти текст **жирним** **жирним 2слова**, робити його _курс-ив ним_ _snake_case_ та або `фіксованої 123 ширини`. Також є можливість зберігати фрагменти преформатованого тексту:
                            
                _ - а це нижнє підкреслення
                ‘_’ - теж ок
                `_` - теж ок
                snake_case
                _italic case_
                _кінця-краю немає_
                            
                            
                параграф3
                ```
                Цей текст є преформатований.
                   Це означає, що він відобразиться, як є, і жодне інше форматування, як от **жирний** **жирний** чи _курсив_ _на_ _кур_сив2_ `нього` `не`
                впливає.          А ще тут усі пробіли, відступи та перенесення рядка зберігаються як є
                ```
                """;

        String actual = converter.convert(input);

        assertEquals("""
                Це текст у форматі Markdown. В межах нашої роботи ми розглядаємо дуже урізану підмножину цієї мови розмітки. Текст можна розділяти на абзаци, лишаючи між абзацами 1 (один) порожній рядок.
                            
                Ми можемо виділяти текст ESC[1mжирнимESC[21m ESC[1mжирним 2словаESC[21m, робити його ESC[3mкурс-ив нимESC[23m ESC[3msnake_caseESC[23m та або ESC[7mфіксованої 123 шириниESC[27m. Також є можливість зберігати фрагменти преформатованого тексту:
                            
                _ - а це нижнє підкреслення
                ‘_’ - теж ок
                ESC[7m_ESC[27m - теж ок
                snake_case
                ESC[3mitalic caseESC[23m
                ESC[3mкінця-краю немаєESC[2m
                            
                            
                параграф3
                ESC[7m
                Цей текст є преформатований.
                   Це означає, що він відобразиться, як є, і жодне інше форматування, як от **жирний** **жирний** чи _курсив_ _на_ _кур_сив2_ `нього` `не`
                впливає.          А ще тут усі пробіли, відступи та перенесення рядка зберігаються як є
                ESC[27m
                """, actual);
    }

    @ParameterizedTest
    @CsvSource({
            // not closed tags
            "**aaaaaa bbbbbb",
            "_aaaaaaa bbbbbb",
            "`aaaaaaa bbbbbb",

            // nesting
            "`**abcd**`",
            "_**abcd**_",
            "**_abcd_**",
            "`_abcd_`",
            "**`abcd`**",
            "_`abcd`_",
    })
    void convert_should_throw(String input) {
        assertThrows(MarkupValidationException.class,
                () -> converter.convert(input));
    }
}
