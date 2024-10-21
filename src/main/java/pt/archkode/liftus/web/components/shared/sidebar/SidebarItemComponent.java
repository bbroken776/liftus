package pt.archkode.liftus.web.components.shared.sidebar;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class SidebarItemComponent extends HorizontalLayout {

    public SidebarItemComponent() {
        setWidthFull();

        setClassName("sidebar-item");
        setSpacing(false);
        setPadding(false);

        setAlignItems(Alignment.CENTER);

    }

}
