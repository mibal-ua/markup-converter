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
                _кінця-краю немає
                            
                            
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
                            
                Ми можемо виділяти текст \u001B[1mжирним\u001B[22m \u001B[1mжирним 2слова\u001B[22m, робити його \u001B[3mкурс-ив ним\u001B[23m \u001B[3msnake_case\u001B[23m та або \u001B[7mфіксованої 123 ширини\u001B[27m. Також є можливість зберігати фрагменти преформатованого тексту:
                            
                _ - а це нижнє підкреслення
                ‘_’ - теж ок
                \u001B[7m_\u001B[27m - теж ок
                snake_case
                \u001B[3mitalic case\u001B[23m
                \u001B[3mкінця-краю немає\u001B[23m
                            
                            
                параграф3
                \u001B[7m
                Цей текст є преформатований.
                   Це означає, що він відобразиться, як є, і жодне інше форматування, як от **жирний** **жирний** чи _курсив_ _на_ _кур_сив2_ `нього` `не`
                впливає.          А ще тут усі пробіли, відступи та перенесення рядка зберігаються як є
                \u001B[27m
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
            "_`abcd`_",
    })
    void convert_should_throw(String input) {
        assertThrows(MarkupValidationException.class,
                () -> converter.convert(input));
    }
}
