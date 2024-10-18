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
        getStyle().set("max-width", "1280px");
        getStyle().set("margin", "0 auto");
        getStyle().set("padding-left", "1rem");
        getStyle().set("padding-right", "1rem");

        add(components);
    }
}
