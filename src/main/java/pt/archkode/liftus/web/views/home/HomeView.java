package pt.archkode.liftus.web.views.home;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import pt.archkode.liftus.web.components.home.AboutSection;
import pt.archkode.liftus.web.components.home.IntroductionSection;
import pt.archkode.liftus.web.components.home.StatsSection;
import pt.archkode.liftus.web.components.shared.SectionComponent;
import pt.archkode.liftus.web.components.shared.WrapperComponent;
import pt.archkode.liftus.web.layouts.MainLayout;

@PageTitle("Home")
@Route(value = "", layout = MainLayout.class)
@AnonymousAllowed

@CssImport("./styles/home.css")
public class HomeView extends WrapperComponent {

    public HomeView() {
        add(new IntroductionSection(), new StatsSection(), new AboutSection());
    }
}
