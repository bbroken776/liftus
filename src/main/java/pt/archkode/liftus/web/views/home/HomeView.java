package pt.archkode.liftus.web.views.home;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Span;
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
        setWidthFull();

        SectionComponent introductionSection = new IntroductionSection();
        SectionComponent statsSection = new StatsSection();
        SectionComponent aboutSection = new AboutSection();
        
        SectionComponent section1 = new SectionComponent("section1", "section1-section");
        section1.addComponents(new Span("Section 1"));

        SectionComponent section2 = new SectionComponent("section2", "section2-section");
        section2.addComponents(new Span("Section 2"));

        SectionComponent section3 = new SectionComponent("section3", "section3-section");
        section3.addComponents(new Span("Section 3"));

        SectionComponent section4 = new SectionComponent("section4", "section4-section");
        section4.addComponents(new Span("Section 4"));

        SectionComponent section5 = new SectionComponent("section5", "section5-section");
        section5.addComponents(new Span("Section 5"));

        add(introductionSection, statsSection, aboutSection, section1, section2, section3, section4, section5);
    }
}
