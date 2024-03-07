package ua.mibal.adapter.out;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ua.mibal.adapter.out.component.MarkupReplacerProvider;
import ua.mibal.test.annotation.UnitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@UnitTest
class MdToHtmlConverter_UnitTest {

    private MdToHtmlConverter converter = new MdToHtmlConverter(new MarkupReplacerProvider());

    @ParameterizedTest
    @CsvSource("""
            'Це текст у форматі Markdown. В межах нашої роботи ми розглядаємо дуже урізану підмножину цієї мови розмітки. Текст можна розділяти на абзаци лишаючи між абзацами 1 (один) порожній рядок.
                        
            Ми можемо виділяти текст **жирним** **жирним 2слова**, робити його _курс-ив ним_ _snake_case_ та або `фіксованої 123 ширини`. Також є можливість зберігати фрагменти преформатованого тексту:
                        
            параграф3
            ```
            Цей текст є преформатований.
               Це означає, що він відобразиться, як є, і жодне інше форматування, як от **жирний** **жирний** чи _курсив_ _на_ _кур_сив2_ `нього` `не`
            впливає.          А ще тут усі пробіли, відступи та перенесення рядка зберігаються як є
            ```'
            """)
    void convert(String input) {
        String actual = converter.convert(input);

        assertEquals("""
                <p>Це текст у форматі Markdown. В межах нашої роботи ми розглядаємо дуже урізану підмножину цієї мови розмітки. Текст можна розділяти на абзаци лишаючи між абзацами 1 (один) порожній рядок.
                </p>
                <p>Ми можемо виділяти текст <b>жирним</b> <b>жирним 2слова</b>, робити його <i>курс-ив ним</i> <i>snake_case</i> та або <tt>фіксованої 123 ширини</tt>. Також є можливість зберігати фрагменти преформатованого тексту:
                </p>
                <p>параграф3
                <pre>
                Цей текст є преформатований.
                   Це означає, що він відобразиться, як є, і жодне інше форматування, як от **жирний** **жирний** чи _курсив_ _на_ _кур_сив2_ `нього` `не`
                впливає.          А ще тут усі пробіли, відступи та перенесення рядка зберігаються як є
                </pre></p>""", actual);
    }
}
