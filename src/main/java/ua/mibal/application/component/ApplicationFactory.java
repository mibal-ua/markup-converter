package ua.mibal.application.component;

import ua.mibal.adapter.out.FileInputProvider;
import ua.mibal.adapter.out.FileWriterContentSender;
import ua.mibal.adapter.out.MdToHtmlConverter;
import ua.mibal.adapter.out.component.ArgumentParser;
import ua.mibal.adapter.out.component.FileWriterFactory;
import ua.mibal.adapter.out.component.MarkupReplacerProvider;
import ua.mibal.adapter.out.model.Arguments;
import ua.mibal.application.Application;
import ua.mibal.application.port.ContentSender;
import ua.mibal.application.port.Converter;
import ua.mibal.application.port.InputProvider;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public class ApplicationFactory {
    private static final String OUTPUT_PATH_KEY = "out";
    private static final String INPUT_PATH_KEY = "in";

    private final Arguments arguments;

    public ApplicationFactory(String[] args) {
        ArgumentParser argumentParser = new ArgumentParser();
        arguments = argumentParser.parse(args);
    }

    public Application create() {
        InputProvider inputProvider = configureInputProvider();
        Converter converter = condfigureConverter();
        ContentSender contentSender = configureContentSender();
        return new Application(
                inputProvider,
                converter,
                contentSender
        );
    }

    private InputProvider configureInputProvider() {
        String inputPath = arguments.getRequired(INPUT_PATH_KEY);
        return new FileInputProvider(inputPath);
    }

    private Converter condfigureConverter() {
        return new MdToHtmlConverter(new MarkupReplacerProvider());
    }

    private ContentSender configureContentSender() {
        if (arguments.containsKey(OUTPUT_PATH_KEY)) {
            String outputPath = arguments.get(OUTPUT_PATH_KEY);
            return new FileWriterContentSender(new FileWriterFactory(), outputPath);
        }
        return new ConsoleContentSender();
    }
}
