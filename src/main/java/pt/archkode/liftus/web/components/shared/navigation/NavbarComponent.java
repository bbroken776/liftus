package pt.archkode.liftus.web.components.shared.navigation;

import java.util.Optional;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.CssImport;
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
public class NavbarComponent extends VerticalLayout {
    public NavbarComponent(AuthenticatedUser user) {
        add(new WrapperComponent(createNavbar(createLogoImage(), createLinks(user))));
    }

    private HorizontalLayout createNavbar(Component... components) {
        HorizontalLayout navbar = new HorizontalLayout(components);
        navbar.setWidthFull();
        navbar.setClassName("navbar");
        navbar.setPadding(true);
        navbar.setAlignItems(Alignment.CENTER);
        navbar.setJustifyContentMode(JustifyContentMode.BETWEEN);

        return navbar;
    }

    private Image createLogoImage() {
        Image logo = new Image("images/logo.png", "Liftus logo");
        logo.setHeight("60px");

        return logo;
    }

    private HorizontalLayout createLinks(AuthenticatedUser user) {
        RouterLink homeLink = new RouterLink("Home", HomeView.class);
        homeLink.setHighlightCondition(HighlightConditions.sameLocation());
        homeLink.setHighlightAction(HighlightActions.toggleClassName("font-medium"));
        homeLink.addClassNames("text-m", "p-s", "rounded-l");
        homeLink.getStyle().set("transition", "all 0.3s");
        homeLink.getElement().addEventListener("mouseover", e -> homeLink.addClassName("bg-contrast-5"));
        homeLink.getElement().addEventListener("mouseout", e -> homeLink.removeClassName("bg-contrast-5"));

        Optional<User> existsUser = user.get();
        RouterLink dashboardLink = new RouterLink(existsUser.isPresent() ? "Hey, " + existsUser.get().getName() : "Dashboard", existsUser.isPresent() ? DashboardView.class : LoginView.class);
        dashboardLink.addClassNames("text-primary", "text-m", "p-s", "rounded-l", "bg-primary-10");
        dashboardLink.getStyle().set("transition", "all 0.3s");

        dashboardLink.getElement().addEventListener("mouseover", e -> dashboardLink.getStyle().set("transform", "scale(1.05)"));
        dashboardLink.getElement().addEventListener("mouseout", e -> dashboardLink.getStyle().set("transform", "scale(1)"));

        HorizontalLayout headerLinks = new HorizontalLayout(homeLink, dashboardLink);
        headerLinks.setSpacing(true);

        return headerLinks;
    }

}
