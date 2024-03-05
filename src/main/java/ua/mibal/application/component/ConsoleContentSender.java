package ua.mibal.application.component;

import ua.mibal.application.port.ContentSender;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
public class ConsoleContentSender implements ContentSender {

    @Override
    public void send(String content) {
        System.out.println(content);
    }
}
