package ua.mibal.application.component;

import org.junit.jupiter.api.Test;
import ua.mibal.adapter.out.FileInputProvider;
import ua.mibal.adapter.out.FileWriterContentSender;
import ua.mibal.adapter.out.MdToAsciiConverter;
import ua.mibal.adapter.out.MdToHtmlConverter;
import ua.mibal.adapter.out.model.ArgumentRequiredException;
import ua.mibal.application.Application;
import ua.mibal.test.annotation.UnitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mockConstruction;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@UnitTest
class ApplicationFactory_UnitTest {

    private ApplicationFactory factory;

    @Test
    void create_shouldThrowExceptionIfInArgNotSpecified() {
        givenFactoryWithArgs();

        thenCreateShouldThrow(ArgumentRequiredException.class);
    }

    @Test
    void create_shouldCreateApplicationWithCorrectInputPath() {
        givenFactoryWithArgs("-in", "input.md");

        thenCreateShouldReturnApplication(FileInputProvider.class, "input.md");
    }

    @Test
    void create_shouldCreateApplicationWithHtmlConverter() {
        givenFactoryWithArgs("-in", "input.md", "-format", "html");

        thenCreateShouldReturnApplication(MdToHtmlConverter.class);
    }

    @Test
    void create_shouldCreateApplicationWithAsciiConverter() {
        givenFactoryWithArgs("-in", "input.md", "-format", "ascii");

        thenCreateShouldReturnApplication(MdToAsciiConverter.class);
    }

    @Test
    void create_shouldCreateApplicationWithConsoleOutput() {
        givenFactoryWithArgs("-in", "input.md");

        thenCreateShouldReturnApplication(ConsoleContentSender.class);
    }

    @Test
    void create_shouldCreateApplicationWithFileOutput() {
        givenFactoryWithArgs("-in", "input.md", "-out", "output.html");

        thenCreateShouldReturnApplication(FileWriterContentSender.class, "output.html");
    }

    private void givenFactoryWithArgs(String... args) {
        factory = new ApplicationFactory(args);
    }

    private void thenCreateShouldThrow(Class<? extends Throwable> exceptionClass) {
        assertThrows(exceptionClass,
                () -> factory.create());
    }

    private void thenCreateShouldReturnApplication(Class<?> componentObject, Object... expectedArgs) {
        try (var mockConstructor = mockConstruction(componentObject, (mock, context) -> {
            for (int i = 0; i < expectedArgs.length; i++) {
                Object expected = expectedArgs[i];
                Object actual = context.arguments().get(i);
                assertEquals(expected, actual);
            }
        })) {
            Application application = factory.create();

            assertNotNull(application);
            assertFalse(
                    mockConstructor.constructed().isEmpty(),
                    "Constructor for " + componentObject + " was not called");
        }
    }
}
