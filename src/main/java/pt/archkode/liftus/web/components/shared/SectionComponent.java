package pt.archkode.liftus.web.components.shared;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class SectionComponent extends HorizontalLayout {

    public SectionComponent(String sectionID) {
        this(sectionID, null, null);
    }

    public SectionComponent(String sectionID, String sectionClassName) {
        this(sectionID, sectionClassName, null);
    }

    public SectionComponent(String sectionID, String sectionClassName, String[] styles) {
        if (sectionID != null && !sectionID.isEmpty()) setId(sectionID);
        if (sectionClassName != null && !sectionClassName.isEmpty()) setClassName(sectionClassName);
    

        if (styles != null && styles.length > 0) {
            for (String style : styles) {
                String[] styleParts = style.split(":");
                if (styleParts.length == 2) {
                    getStyle().set(styleParts[0], styleParts[1]);
                }
            }
        }

        setWidthFull();
        addClassName("p-m");
        getStyle().set("margin-top", "100px");
    }

    public void addComponents(Component... components) {
        add(components);
    }
}