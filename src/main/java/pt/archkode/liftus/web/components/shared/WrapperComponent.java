package pt.archkode.liftus.web.components.shared;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

@CssImport("./styles/wrapper.css")
@CssImport("./styles/shared.css")
public class WrapperComponent extends VerticalLayout {

    public WrapperComponent(Component... components) {
        setWidthFull();

        setClassName("content-wrapper");
        getStyle().setMaxWidth("1280px");
        getStyle().setMargin("0 auto");
        getStyle().setPaddingLeft("0 1rem");

        add(components);
    }
}
