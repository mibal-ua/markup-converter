package ua.mibal.adapter.out.model.replacers;

import org.springframework.stereotype.Component;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@Component
public class MonospacedTagMarkupReplacer extends SimpleTagMarkupReplacer {

    public MonospacedTagMarkupReplacer() {
        super("`", "tt");
    }
}
