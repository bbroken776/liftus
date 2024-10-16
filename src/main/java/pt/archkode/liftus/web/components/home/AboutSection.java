package pt.archkode.liftus.web.components.home;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import pt.archkode.liftus.web.components.shared.SectionComponent;

public class AboutSection extends SectionComponent {

    public AboutSection() {
        super("about", "about-section");

        VerticalLayout aboutWrapper = new VerticalLayout();
        aboutWrapper.setSpacing(false);
        aboutWrapper.setPadding(false);

        VerticalLayout aboutTitle = createAboutTitle();
        aboutWrapper.add(aboutTitle);

        HorizontalLayout aboutHWrapper = new HorizontalLayout();
        aboutHWrapper.getStyle().set("margin-top", "20px");
        aboutHWrapper.setPadding(false);
        aboutHWrapper.setSpacing(false);
        aboutHWrapper.setAlignItems(Alignment.CENTER);
        aboutHWrapper.setJustifyContentMode(JustifyContentMode.BETWEEN);

        Image aboutImage = createAboutImage();
        VerticalLayout aboutText = createAboutText();

        aboutHWrapper.add(aboutImage, aboutText);
        aboutWrapper.add(aboutHWrapper);
        add(aboutWrapper);
    }

    private VerticalLayout createAboutTitle() {
        VerticalLayout aboutTitle = new VerticalLayout();
        aboutTitle.setPadding(false);
        aboutTitle.setSpacing(false);
        aboutTitle.setAlignItems(Alignment.CENTER);

        H2 title = new H2("Our Mission");
        title.addClassNames("text-2xl", "font-bold", "text-primary");
        title.getStyle().set("margin", "0 0 10px 0");

        Div divider = new Div();
        divider.setWidth("200px");
        divider.setHeight("2px");
        divider.addClassNames("bg-contrast-10", "rounded-full");

        aboutTitle.add(title, divider);
        return aboutTitle;
    }

    private Image createAboutImage() {
        Image aboutImage = new Image("images/mobile.png", "About Liftus Mobile");
        aboutImage.setClassName("about-image");
        return aboutImage;
    }

    private VerticalLayout createAboutText() {
        VerticalLayout aboutText = new VerticalLayout();
        aboutText.setPadding(false);
        aboutText.setSpacing(false);
        aboutText.setAlignItems(Alignment.CENTER);

        H1 title = new H1("Make your life easier with us! Help us help you!");
        title.addClassNames("font-bold", "text-3xl", "text-error");
        
        Span introduction = new Span("Liftus is a platform that connects drivers with passengers. We aim to provide a safe and reliable service to our users. Our platform is easy to use and we have a dedicated team to help you with any issues you may have.");
        introduction.addClassNames("text-m", "text-body");

        aboutText.add(title, introduction);
        return aboutText;
    }

}
