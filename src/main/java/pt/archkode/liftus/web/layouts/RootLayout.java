package pt.archkode.liftus.web.layouts;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLink;

import pt.archkode.liftus.web.views.dashboard.DashboardView;
import pt.archkode.liftus.web.views.home.HomeView;


@CssImport("./styles/navbar.css")
public class RootLayout extends AppLayout {

    public RootLayout() {
        super();

        final HorizontalLayout header = createHeader();
        final HorizontalLayout footer = createFooter();

        addToNavbar(header);
        addToDrawer(footer);
    }

    private HorizontalLayout createHeader() {
        Image logo = new Image("images/logo.png", "Liftus logo");
        logo.setHeight("60px");

        RouterLink homeLink = new RouterLink("Home", HomeView.class);
        homeLink.addClassName("navbar-link");

        RouterLink dashboardLink = new RouterLink("Dashboard", DashboardView.class);
        dashboardLink.addClassName("navbar-link-dashboard");

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
}
