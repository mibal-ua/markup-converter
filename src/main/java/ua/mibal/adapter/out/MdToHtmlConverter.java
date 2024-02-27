package ua.mibal.adapter.out;

import org.springframework.stereotype.Component;
import ua.mibal.adapter.out.component.ElementRenderer;
import ua.mibal.adapter.out.component.MarkupTreeAssembler;
import ua.mibal.adapter.out.model.MarkupTree;
import ua.mibal.application.port.Converter;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:9mohapx9@gmail.com">9mohapx9@gmail.com</a>
 */
@Component
public class MdToHtmlConverter implements Converter {
    private final MarkupTreeAssembler markupTreeAssembler;
    private final ElementRenderer elementRenderer;

    public MdToHtmlConverter(MarkupTreeAssembler markupTreeAssembler,
                             ElementRenderer elementRenderer) {
        this.markupTreeAssembler = markupTreeAssembler;
        this.elementRenderer = elementRenderer;
    }

    @Override
    public String convert(String input) {
        MarkupTree tree = markupTreeAssembler.assembleTree(input);
        return elementRenderer.render(tree);
    }
}
