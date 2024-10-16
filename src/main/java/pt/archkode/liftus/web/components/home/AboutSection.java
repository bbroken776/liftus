package pt.archkode.liftus.web.components.home;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import pt.archkode.liftus.web.components.shared.SectionComponent;

public class AboutSection extends SectionComponent {

    public AboutSection() {
        super("about", "about-section");

        VerticalLayout aboutWrapper = new VerticalLayout();
        aboutWrapper.setSpacing(false);
        aboutWrapper.setPadding(false);
        aboutWrapper.setAlignItems(Alignment.CENTER);

        VerticalLayout aboutText = createAboutText();


        aboutWrapper.add(aboutText);
    }

    private Image createAboutImage() {
        Image aboutImage = new Image("images/about.svg", "About Liftus");
        aboutImage.addClassNames("about-image");
        return aboutImage;
    }

    private VerticalLayout createAboutText() {
        VerticalLayout aboutText = new VerticalLayout();
        aboutText.setPadding(false);
        aboutText.setSpacing(false);
        aboutText.setAlignItems(Alignment.CENTER);

        Span text = new Span("Liftus is a platform that connects drivers with passengers. " +
                "We aim to provide a safe and reliable service to our users. " +
                "Our platform is easy to use and we have a dedicated team to help you with any issues you may have.");

        text.addClassNames("text-lg", "text-header", "text-primary");
        text.getStyle().set("margin", "0 0 10px 0");

        aboutText.add(text);
        return aboutText;
    }

}
