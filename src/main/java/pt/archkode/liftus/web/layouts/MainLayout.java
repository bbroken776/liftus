package pt.archkode.liftus.web.layouts;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLayout;

import pt.archkode.liftus.security.AuthenticatedUser;

@CssImport("./styles/shared.css")
public class MainLayout extends VerticalLayout implements RouterLayout {
    private RootLayout rootLayout;

    public MainLayout(AuthenticatedUser authenticatedUser) {
        setPadding(false);
        setSpacing(false);

        rootLayout = new RootLayout(authenticatedUser);
        add(rootLayout);
    }

    public void addView(Component view) {
        rootLayout.addView(view);
    }
}