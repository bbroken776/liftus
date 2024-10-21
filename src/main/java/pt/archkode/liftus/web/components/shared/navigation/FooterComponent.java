package pt.archkode.liftus.web.components.shared.navigation;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class FooterComponent extends VerticalLayout {

    public FooterComponent() {
        addClassName("bg-contrast-10");

        add(createFooter(createText()));
    }

    public HorizontalLayout createFooter(Component... components) {
        HorizontalLayout footer = new HorizontalLayout(components);
        footer.setWidthFull();
        footer.setPadding(true);
        footer.setAlignItems(Alignment.CENTER);
        footer.setJustifyContentMode(JustifyContentMode.CENTER);

        return footer;
    }

    public Paragraph createText() {
        Paragraph text = new Paragraph("© 2024/2025 Liftus. All rights reserved.");
        text.getStyle().setColor("text-primary");
        text.getStyle().setFontSize("0.8rem");

        return text;
    }

}
