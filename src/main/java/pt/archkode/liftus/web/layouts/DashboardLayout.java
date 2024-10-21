package pt.archkode.liftus.web.layouts;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.HasDynamicTitle;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.server.auth.AccessAnnotationChecker;
import com.vaadin.flow.theme.lumo.LumoUtility;

import pt.archkode.liftus.security.AuthenticatedUser;
import pt.archkode.liftus.web.views.HomeView;

@CssImport("./styles/shared.css")
public class DashboardLayout extends AppLayout {
    private final AccessAnnotationChecker accessChecker;

    private VerticalLayout contentArea;
    private H2 pageTitle;

    public DashboardLayout(AuthenticatedUser authenticatedUser, AccessAnnotationChecker accessChecker) {
        this.accessChecker = accessChecker;

        setPrimarySection(Section.DRAWER);

        addNavbarContent();
        addDrawerContent();

        contentArea = new VerticalLayout();
        contentArea.setClassName("content-area");
        contentArea.setWidthFull();
        contentArea.setPadding(false);
        contentArea.setSpacing(false);

        setContent(contentArea);
    }

    private void addNavbarContent() {
        HorizontalLayout header = new HorizontalLayout(createHeaderMenu(createDrawerToggle(), createPageTitle()), new Span("teste"));
        header.setWidthFull();
        header.addClassName("p-m");
        header.setAlignItems(Alignment.CENTER);
        header.setJustifyContentMode(JustifyContentMode.BETWEEN);


        // header.addClassNames(LumoUtility.AlignItems.CENTER, LumoUtility.Display.FLEX,
        // LumoUtility.Padding.End.MEDIUM, LumoUtility.Width.FULL);

        addToNavbar(true, header);
    }

    public DrawerToggle createDrawerToggle() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");
        toggle.setTooltipText("Menu toggle");
        toggle.getStyle().set("cursor", "pointer");
        toggle.getStyle().set("margin", "0");
        

        return toggle;
    }

    public H2 createPageTitle() {
        pageTitle = new H2();
        pageTitle.addClassNames("text-l", "font-semibold", "text-tertiary");

        return pageTitle;
    }

    public HorizontalLayout createHeaderMenu(Component... components) {
        HorizontalLayout headerMenu = new HorizontalLayout(components);
        headerMenu.setWidthFull();
        headerMenu.setAlignItems(Alignment.CENTER);
        headerMenu.setJustifyContentMode(JustifyContentMode.CENTER);
        headerMenu.getStyle().set("max-width", "fit-content");

        return headerMenu;
    }

    private void addDrawerContent() {
        Span appName = new Span("Vaadin Chat");
        appName.addClassNames(LumoUtility.AlignItems.CENTER, LumoUtility.Display.FLEX, LumoUtility.FontSize.LARGE, LumoUtility.FontWeight.SEMIBOLD, LumoUtility.Height.XLARGE, LumoUtility.Padding.Horizontal.MEDIUM);

        addToDrawer(appName, new Scroller(createSideNav()));
    }

    private SideNav createSideNav() {
        SideNav nav = new SideNav();

        nav.addItem(new SideNavItem("Lobby", HomeView.class, VaadinIcon.BUILDING.create()));
        return nav;
    }

    @Override
    public void afterNavigation() {
        super.afterNavigation();
        pageTitle.setText(getCurrentPageTitle());
    }

    public String getCurrentPageTitle() {
        if (getContent() == null) return "";
        if (getContent() instanceof HasDynamicTitle titleHolder) return titleHolder.getPageTitle();

        PageTitle titleAnnotation = getContent().getClass().getAnnotation(PageTitle.class);
        return (titleAnnotation != null) ? titleAnnotation.value() : "";
    }

}
