package pt.archkode.liftus.web.layouts;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLink;

import pt.archkode.liftus.web.views.home.HomeView;

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
        RouterLink dashboardLink = new RouterLink("Dashboard", );

        HorizontalLayout header = new HorizontalLayout();
        header.setPadding(true);
        header.add(logo);
        return header;
    }

    private HorizontalLayout createFooter() {
        HorizontalLayout footer = new HorizontalLayout();
        return footer;
    }
}
