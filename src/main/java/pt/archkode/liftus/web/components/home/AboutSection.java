package pt.archkode.liftus.web.components.home;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Style.TextAlign;

import pt.archkode.liftus.web.components.shared.SectionComponent;

public class AboutSection extends SectionComponent {

    public AboutSection() {
        super("about", "about-section");

        VerticalLayout aboutWrapper = new VerticalLayout();
        aboutWrapper.setWidthFull();
        aboutWrapper.setSpacing(false);
        aboutWrapper.setPadding(false);

        VerticalLayout aboutTitle = createAboutTitle();
        aboutWrapper.add(aboutTitle);

        HorizontalLayout aboutHWrapper = new HorizontalLayout();
        aboutHWrapper.setWidthFull();

        aboutHWrapper.setClassName("about-content");
        aboutHWrapper.getStyle().setMarginTop("20px");
        aboutHWrapper.setPadding(false);
        aboutHWrapper.setSpacing(false);
        aboutHWrapper.setAlignItems(Alignment.CENTER);
        aboutHWrapper.setJustifyContentMode(JustifyContentMode.BETWEEN);

        Image aboutImage = createAboutImage();
        VerticalLayout aboutText = createAboutText(aboutImage);

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
        title.getStyle().setMargin("0 0 10px 0");

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

        aboutImage.setMaxWidth("400px");
        aboutImage.getStyle().set("filter", "drop-shadow(0px 4px 4px rgba(0, 0, 0, 0.25))");

        return aboutImage;
    }

    private VerticalLayout createAboutText(Image aboutImage) {
        VerticalLayout aboutText = new VerticalLayout();
        aboutText.setClassName("about-text");
        aboutText.setMaxWidth("600px");

        H1 title = new H1("Make your life easier with us! Help us help you!");
        title.addClassNames("font-bold", "text-3xl", "text-yellow");

        Paragraph about = new Paragraph( "Liftus is a platform that connects people with drivers. We aim to make your life easier and less stressful by providing a reliable and affordable transportation service. Our mission is to help you get to your destination safely and on time, so you can focus on what matters most to you.");
        about.addClassNames("text-m", "text-body");

        Anchor aboutButton = createAboutButton(aboutImage);

        aboutText.add(title, about, aboutButton);
        return aboutText;
    }

    private Anchor createAboutButton(Image aboutImage) {
        Anchor aboutButton = new Anchor("/contact", "Talk with us!");
        aboutButton.setWidthFull();
        aboutButton.addClassNames("about-button", "text-sm", "text-primary-contrast", "font-extrabold", "p-s", "rounded-l", "bg-primary");
        aboutButton.getStyle().setTransition("all 0.3s");
        aboutButton.getStyle().setTextAlign(TextAlign.CENTER);

        aboutButton.getElement().addEventListener("mouseover", e -> {
            aboutButton.removeClassName("text-primary-contrast");
            aboutButton.addClassNames("bg-primary-10", "text-primary", "border", "border-primary-50");
            aboutImage.addClassName("pulsing");
        });
        aboutButton.getElement().addEventListener("mouseout", e -> {
            aboutImage.removeClassName("pulsing");
            aboutButton.removeClassNames("bg-primary-10", "text-primary", "border", "border-primary-50");
            aboutButton.addClassNames("text-primary-contrast");
        });

        return aboutButton;
    }

}
