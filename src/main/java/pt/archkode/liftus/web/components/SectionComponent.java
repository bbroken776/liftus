package pt.archkode.liftus.web.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class SectionComponent extends VerticalLayout {

    // Constructor with sectionID
    public SectionComponent(String sectionID) {
        this(sectionID, null, null); // Calls the main constructor
    }

    // Constructor with sectionID and sectionClassName
    public SectionComponent(String sectionID, String sectionClassName) {
        this(sectionID, sectionClassName, null); // Calls the main constructor
    }

    // Constructor with sectionID, sectionClassName, and styles
    public SectionComponent(String sectionID, String sectionClassName, String[] styles) {
        if (sectionID != null && !sectionID.isEmpty()) this.setId(sectionID);
        if (sectionClassName != null && !sectionClassName.isEmpty()) this.setClassName(sectionClassName);
    

        if (styles != null && styles.length > 0) {
            for (String style : styles) {
                String[] styleParts = style.split(":");
                if (styleParts.length == 2) {
                    this.getStyle().set(styleParts[0], styleParts[1]);
                }
            }
        }

        this.setWidthFull();
        this.addClassName("p-m");
        this.getStyle().set("margin-top", "100px");
        this.setAlignItems(Alignment.CENTER);
        this.setJustifyContentMode(JustifyContentMode.BETWEEN);
    }

    public void addComponents(Component... components) {
        this.add(components);
    }
}