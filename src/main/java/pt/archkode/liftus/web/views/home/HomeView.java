package pt.archkode.liftus.web.views.home;

import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import pt.archkode.liftus.web.layouts.RootLayout;

@PageTitle("Home")
@Route("")
@AnonymousAllowed
public class HomeView extends RootLayout {

    public HomeView() {
    }

}
