package pt.archkode.liftus.web.components.home;

import com.vaadin.flow.component.html.Span;

import pt.archkode.liftus.web.components.shared.SectionComponent;

public class AboutSection extends SectionComponent {

    public AboutSection() {
        super("about", "about-section");
        addComponents(new Span("About"));
    }

}
