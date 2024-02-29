package ua.mibal.application.component;

import ua.mibal.adapter.out.component.ArgumentParser;
import ua.mibal.adapter.out.model.Arguments;
import ua.mibal.application.Application;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public class ApplicationFactory {
    private final Arguments arguments;

    public ApplicationFactory(String[] args) {
        ArgumentParser argumentParser = new ArgumentParser();
        arguments = argumentParser.parse(args);
    }

    public Application create() {
        // TODO
        return null;
    }
}
