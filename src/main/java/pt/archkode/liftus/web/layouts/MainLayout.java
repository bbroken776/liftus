package pt.archkode.liftus.web.layouts;

import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLayout;

import pt.archkode.liftus.security.AuthenticatedUser;
import pt.archkode.liftus.web.components.shared.navigation.FooterComponent;
import pt.archkode.liftus.web.components.shared.navigation.NavbarComponent;

@CssImport("./styles/shared.css")
public class MainLayout extends VerticalLayout implements RouterLayout {
    private Div contentArea;

    public MainLayout(AuthenticatedUser authenticatedUser) {
        setWidthFull();
        setPadding(false);
        setSpacing(false);
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        add(new NavbarComponent(authenticatedUser), contentArea(), new FooterComponent());
    }

    private Div contentArea() {
        this.contentArea = new Div();
        this.contentArea.setClassName("content-area");
        this.contentArea.setWidthFull();
        return this.contentArea;
    }

    public void showRouterLayoutContent(HasElement content) {
        this.contentArea.removeAll();
        this.contentArea.getElement().appendChild(content.getElement());
    }
}
