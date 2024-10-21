package pt.archkode.liftus.web.layouts;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.theme.lumo.LumoUtility;

import pt.archkode.liftus.security.AuthenticatedUser;
import pt.archkode.liftus.web.views.HomeView;

@CssImport("./styles/shared.css")
public class DashboardLayout extends AppLayout {
    private VerticalLayout contentArea;
    private H2 pageTitle;

    public DashboardLayout(AuthenticatedUser authenticatedUser) {
        setPrimarySection(Section.DRAWER);

        addNavbarContent();
        addDrawerContent();
        
        contentArea = new VerticalLayout();
        contentArea.setClassName("content-area");
        contentArea.setWidthFull();
        contentArea.setPadding(false);
        contentArea.setSpacing(false);
        contentArea.setAlignItems(Alignment.CENTER);
        contentArea.setJustifyContentMode(JustifyContentMode.CENTER);
        
        setContent(contentArea);
    }

    private void addNavbarContent() {
        var toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");
        toggle.setTooltipText("Menu toggle");

        pageTitle = new H2();
        pageTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE, LumoUtility.Flex.GROW);

        var header = new Header(toggle, pageTitle);
        header.addClassNames(LumoUtility.AlignItems.CENTER, LumoUtility.Display.FLEX, LumoUtility.Padding.End.MEDIUM, LumoUtility.Width.FULL);

        addToNavbar(false, header);
    }

    private void addDrawerContent() {
        var appName = new Span("Vaadin Chat");
        appName.addClassNames(LumoUtility.AlignItems.CENTER, LumoUtility.Display.FLEX, LumoUtility.FontSize.LARGE, LumoUtility.FontWeight.SEMIBOLD, LumoUtility.Height.XLARGE, LumoUtility.Padding.Horizontal.MEDIUM);

        addToDrawer(appName, new Scroller(createSideNav()));
    }

    private SideNav createSideNav() {
        SideNav nav = new SideNav();

        nav.addItem(new SideNavItem("Lobby", HomeView.class,VaadinIcon.BUILDING.create()));
        return nav;
    }

}
