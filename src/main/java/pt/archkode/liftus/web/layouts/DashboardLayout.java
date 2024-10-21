package pt.archkode.liftus.web.layouts;

import com.vaadin.copilot.javarewriter.JavaRewriter.AlignmentMode;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.model.Side;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.dom.Style.AlignItems;
import com.vaadin.flow.dom.Style.JustifyContent;
import com.vaadin.flow.router.HasDynamicTitle;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.server.auth.AccessAnnotationChecker;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin.Minus.Vertical;

import pt.archkode.liftus.data.entity.UserEntity;
import pt.archkode.liftus.data.type.RoleType;
import pt.archkode.liftus.security.AuthenticatedUser;
import pt.archkode.liftus.web.components.shared.WrapperComponent;
import pt.archkode.liftus.web.views.HomeView;
import pt.archkode.liftus.web.views.auth.LogoutView;

@CssImport("./styles/shared.css")
public class DashboardLayout extends AppLayout {
    private final AuthenticatedUser authenticatedUser;
    private final AccessAnnotationChecker accessChecker;

    private VerticalLayout contentArea;
    private H2 pageTitle;

    public DashboardLayout(AuthenticatedUser authenticatedUser, AccessAnnotationChecker accessChecker) {
        this.authenticatedUser = authenticatedUser;
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
        HorizontalLayout header = new HorizontalLayout(createHeaderMenu(createDrawerToggle(), createPageTitle()),
                getUserDetails());
        header.setWidthFull();
        header.setPadding(false);
        header.setSpacing(false);
        header.setAlignItems(Alignment.CENTER);
        header.setJustifyContentMode(JustifyContentMode.BETWEEN);

        addToNavbar(true, new WrapperComponent(header));
    }

    public HorizontalLayout createHeaderMenu(Component... components) {
        HorizontalLayout headerMenu = new HorizontalLayout(components);
        headerMenu.setWidthFull();
        headerMenu.setPadding(false);
        headerMenu.setSpacing(false);
        headerMenu.setAlignItems(Alignment.CENTER);
        headerMenu.setJustifyContentMode(JustifyContentMode.CENTER);
        headerMenu.getStyle().setMaxWidth("fit-content");

        return headerMenu;
    }

    public DrawerToggle createDrawerToggle() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");
        toggle.setTooltipText("Menu toggle");
        toggle.getStyle().setCursor("pointer");
        toggle.getStyle().setMargin("0");
        toggle.getStyle().setMarginRight("20px");

        return toggle;
    }

    public H2 createPageTitle() {
        pageTitle = new H2();
        pageTitle.addClassNames("text-m", "font-semibold", "text-tertiary");

        return pageTitle;
    }

    public HorizontalLayout getUserDetails() {
        final UserEntity user = authenticatedUser.get().get();

        Span userFullName = new Span(user.getFullName());
        userFullName.addClassNames("text-m", "font-semibold", "text-header");
        userFullName.getStyle().setMarginRight("10px");

        RoleType userRoleType = user.getRoles().stream().findFirst().orElse(RoleType.USER);
        Span userRole = new Span(userRoleType.getLabel());
        userRole.addClassNames("text-xs", "font-bold", userRoleType.getColor(),
                (userRoleType.getColor().replace("text", "bg") + "-10"), "rounded-l");
        userRole.getStyle().setPadding("2px 10px");

        HorizontalLayout userDetails = new HorizontalLayout(userFullName, userRole);
        userDetails.setSpacing(false);
        userDetails.setPadding(false);
        userDetails.getStyle().setAlignItems(AlignItems.CENTER);
        userDetails.getStyle().setJustifyContent(JustifyContent.CENTER);
        userDetails.getStyle().setMaxWidth("fit-content");

        return userDetails;
    }

    private void addDrawerContent() {
        Image logo = new Image("images/logo.png", "Liftus logo");
        logo.setHeight("60px");

        VerticalLayout logoWrapper = new VerticalLayout(logo);
        logoWrapper.setPadding(false);
        logoWrapper.setSpacing(false);
        logoWrapper.setAlignItems(Alignment.CENTER);
        logoWrapper.setJustifyContentMode(JustifyContentMode.CENTER);
        logoWrapper.getStyle().setMarginBottom("50px");
        logoWrapper.addClassName("p-s");

        addToDrawer(logoWrapper, new Scroller(createSideNav()));
    }

    private SideNav createSideNav() {
        SideNav nav = new SideNav();

        nav.addItem(new SideNavItem("Home", HomeView.class, VaadinIcon.BUILDING.create()));
        nav.addItem(new SideNavItem("Logout", LogoutView.class, VaadinIcon.SIGN_OUT.create()));

        return nav;
    }

    @Override
    public void afterNavigation() {
        super.afterNavigation();
        pageTitle.setText(getCurrentPageTitle());
    }

    public String getCurrentPageTitle() {
        if (getContent() == null)
            return "";
        if (getContent() instanceof HasDynamicTitle titleHolder)
            return titleHolder.getPageTitle();

        PageTitle titleAnnotation = getContent().getClass().getAnnotation(PageTitle.class);
        return (titleAnnotation != null) ? titleAnnotation.value() : "";
    }

}
