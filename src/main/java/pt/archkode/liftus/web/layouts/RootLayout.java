package pt.archkode.liftus.web.layouts;

import java.util.Optional;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;

import pt.archkode.liftus.data.User;
import pt.archkode.liftus.security.AuthenticatedUser;
import pt.archkode.liftus.web.views.dashboard.DashboardView;
import pt.archkode.liftus.web.views.home.HomeView;

@CssImport("./styles/navbar.css")
public class RootLayout extends VerticalLayout {

    private AuthenticatedUser authenticatedUser;
    private Div body;

    public RootLayout(AuthenticatedUser authenticatedUser) {
        this.authenticatedUser = authenticatedUser;

        setWidthFull();
        setPadding(false);
        setSpacing(false);

        HorizontalLayout header = createHeader();
        body = new Div();
        HorizontalLayout footer = createFooter();

        add(header, body, footer);
    }

    private HorizontalLayout createHeader() {
        Image logo = new Image("images/logo.png", "Liftus logo");
        logo.setHeight("60px");

        RouterLink homeLink = new RouterLink("Home", HomeView.class);
        homeLink.setHighlightCondition(HighlightConditions.sameLocation());
        homeLink.addClassNames("text-header","text-m", "p-s", "rounded-l");
        homeLink.getStyle().set("transition", "all 0.3s");
        homeLink.getElement().addEventListener("mouseover", e -> homeLink.addClassNames("bg-contrast-5", "font-semibold"));
        homeLink.getElement().addEventListener("mouseout", e -> homeLink.removeClassNames("bg-contrast-5", "font-semibold"));

        Optional<User> existsUser = authenticatedUser.get();
        RouterLink dashboardLink = new RouterLink(
                existsUser.isPresent() ? "Hey, " + existsUser.get().getName() : "Dashboard", DashboardView.class);
        dashboardLink.addClassNames("text-m");

        HorizontalLayout headerLinks = new HorizontalLayout(homeLink, dashboardLink);
        headerLinks.setSpacing(true);

        HorizontalLayout header = new HorizontalLayout(logo, headerLinks);
        header.setWidthFull();
        header.setPadding(true);
        header.setAlignItems(Alignment.CENTER);
        header.setJustifyContentMode(JustifyContentMode.BETWEEN);

        return header;
    }

    private HorizontalLayout createFooter() {
        HorizontalLayout footer = new HorizontalLayout();
        return footer;
    }

    public void addView(Component component) {
        body.removeAll();
        body.add(component);
    }
}
