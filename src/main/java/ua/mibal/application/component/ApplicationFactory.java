package ua.mibal.application.component;

import ua.mibal.adapter.out.component.ArgumentParser;
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
    private static final String OUTPUT_PATH_KEY = "-out";
    private static final String INPUT_PATH_KEY = "-in";

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

    // TODO
    private InputProvider configureInputProvider() {
        return null;
    }

    private Converter condfigureConverter() {
        return null;
    }

    private ContentSender configureContentSender() {
        return null;
    }
}
