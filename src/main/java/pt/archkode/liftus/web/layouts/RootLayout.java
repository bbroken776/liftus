package pt.archkode.liftus.web.layouts;

import java.util.Optional;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightActions;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;

import pt.archkode.liftus.data.User;
import pt.archkode.liftus.security.AuthenticatedUser;
import pt.archkode.liftus.web.components.shared.WrapperComponent;
import pt.archkode.liftus.web.views.dashboard.DashboardView;
import pt.archkode.liftus.web.views.home.HomeView;
import pt.archkode.liftus.web.views.login.LoginView;

@CssImport("./styles/navbar.css")
public class RootLayout extends VerticalLayout {

    private AuthenticatedUser authenticatedUser;
    private Div body;

    public RootLayout(AuthenticatedUser authenticatedUser) {
        this.authenticatedUser = authenticatedUser;

        setWidthFull();
        setPadding(false);
        setSpacing(false);

        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        add(new WrapperComponent(createHeader(), createBody(), createFooter()));
    }

    private HorizontalLayout createHeader() {
        HorizontalLayout header = new HorizontalLayout();
        header.setWidthFull();
        header.setPadding(true);
        header.setAlignItems(Alignment.CENTER);
        header.setJustifyContentMode(JustifyContentMode.BETWEEN);

        header.add(createLogoImage(), createHeaderLinks());

        return header;
    }

    private Image createLogoImage() {
        Image logo = new Image("images/logo.png", "Liftus logo");
        logo.setHeight("60px");

        return logo;
    }

    private HorizontalLayout createHeaderLinks() {
        RouterLink homeLink = new RouterLink("Home", HomeView.class);
        homeLink.setHighlightCondition(HighlightConditions.sameLocation());
        homeLink.setHighlightAction(HighlightActions.toggleClassName("font-medium"));
        homeLink.addClassNames("text-header", "text-m", "p-s", "rounded-l");
        homeLink.getElement().addEventListener("mouseover", e -> homeLink.addClassName("bg-contrast-5"));
        homeLink.getElement().addEventListener("mouseout", e -> homeLink.removeClassName("bg-contrast-5"));

        Optional<User> existsUser = authenticatedUser.get();
        RouterLink dashboardLink = new RouterLink(existsUser.isPresent() ? "Hey, " + existsUser.get().getName() : "Dashboard", existsUser.isPresent() ? DashboardView.class : LoginView.class);
        dashboardLink.addClassNames("text-primary", "text-m", "p-s", "rounded-l", "bg-primary-10");
        dashboardLink.getStyle().set("transition", "all 0.3s");
        dashboardLink.getElement().addEventListener("mouseover", e -> dashboardLink.getStyle().set("transform", "scale(1.05)"));
        dashboardLink.getElement().addEventListener("mouseout", e -> dashboardLink.getStyle().set("transform", "scale(1)"));

        HorizontalLayout headerLinks = new HorizontalLayout(homeLink, dashboardLink);
        headerLinks.setSpacing(true);

        return headerLinks;
    }

    private Div createBody() {
        body = new Div();
        return body;
    }

    private HorizontalLayout createFooter() {
        HorizontalLayout footer = new HorizontalLayout();
        footer.setWidthFull();

        return footer;
    }

    public void addView(Component component) {
        body.removeAll();
        body.add(component);
    }
}
