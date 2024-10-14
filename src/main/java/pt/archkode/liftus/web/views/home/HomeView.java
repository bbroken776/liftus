package pt.archkode.liftus.web.views.home;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import pt.archkode.liftus.web.layouts.MainLayout;

@PageTitle("Home")
@Route(value = "", layout = MainLayout.class)
@AnonymousAllowed
public class HomeView extends Div {

    public HomeView() {
        H1 title = new H1("Welcome to Liftus");
        add(title);
    }

}
