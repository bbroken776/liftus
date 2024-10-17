package pt.archkode.liftus.web.layouts;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLayout;

import pt.archkode.liftus.security.AuthenticatedUser;

@CssImport("./styles/shared.css")
public class MainLayout extends VerticalLayout implements RouterLayout {
    public MainLayout(AuthenticatedUser authenticatedUser) {
        setPadding(false);
        setSpacing(false);

        add(new RootLayout(authenticatedUser));
    }
}