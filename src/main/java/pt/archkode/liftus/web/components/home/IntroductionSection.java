package pt.archkode.liftus.web.components.home;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Style.TextAlign;
import com.vaadin.flow.router.RouterLink;

import pt.archkode.liftus.web.components.shared.SectionComponent;
import pt.archkode.liftus.web.views.auth.LoginView;

public class IntroductionSection extends SectionComponent {
    public IntroductionSection() {
        super("introduction", "introduction-section");

        VerticalLayout introductionText = createIntroductionText();
        Image introductionImage = createIntroductionImage();

        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.BETWEEN);
        getStyle().setMarginTop("70px");

        addComponents(introductionText, introductionImage);
    }

    private VerticalLayout createIntroductionText(){
        VerticalLayout introductionText = new VerticalLayout();
        introductionText.setClassName("introduction-text");
        introductionText.setMaxWidth("600px");
        introductionText.setAlignItems(Alignment.START);
        introductionText.setJustifyContentMode(JustifyContentMode.CENTER);

        Span advertisement = new Span("Create your account today and get 50% off your first ride!");
        advertisement.addClassNames("introduction-advertisement", "text-xs", "text-body", "text-primary", "font-bold", "p-s", "rounded-l", "bg-primary-10");

        H1 title = new H1("Welcome to Liftus");
        title.addClassNames("font-black", "text-3xl", "text-primary");
        title.getStyle().setMarginTop("20px");

        Paragraph introduction = new Paragraph("Liftus is a cutting-edge ride-sharing platform that connects drivers and passengers in real time, offering a quick and reliable way to get around. Whether you're commuting to work, running errands, or heading out for a night on the town, simply request a ride via our user-friendly app, and a driver will arrive to pick you up within minutes. Experience the convenience of modern transportation with Liftus!");
        introduction.addClassNames("text-m", "text-body");

        HorizontalLayout textButtons = createIntroductionButtons(advertisement);

        introductionText.add(advertisement, title, introduction, textButtons);
        return introductionText;
    } 

    private HorizontalLayout createIntroductionButtons(Component advertisementComponent) {
        HorizontalLayout linkButtons = new HorizontalLayout();
        linkButtons.setClassName("introduction-buttons");
        linkButtons.getStyle().setMarginTop("20px");

        Anchor about = new Anchor("#about", "Learn more about us!");
        about.addClassNames("text-xs", "text-body", "font-bold", "p-s", "rounded-l", "border", "border-primary-50");
        about.getStyle().setTransition("all 0.3s");

        about.getElement().addEventListener("mouseover", e -> about.getStyle().setTransform("scale(1.05)"));
        about.getElement().addEventListener("mouseout", e -> about.getStyle().setTransform("scale(1)"));

        RouterLink rideNow = new RouterLink("Ride Now", LoginView.class);
        rideNow.addClassNames("text-xs", "text-primary", "font-bold", "p-s", "rounded-l", "bg-primary-10");
        rideNow.getStyle().setTransition("all 0.3s");
        rideNow.getStyle().setWidth("100px");
        rideNow.getStyle().setTextAlign(TextAlign.CENTER);

        rideNow.getElement().addEventListener("mouseover", e -> {
            rideNow.getStyle().setColor("white");
            rideNow.removeClassName("bg-primary-10");
            rideNow.addClassName("bg-primary");

            advertisementComponent.addClassName("pulsing");
        });

        rideNow.getElement().addEventListener("mouseout", e -> {
            rideNow.getStyle().setColor("text-primary");
            rideNow.removeClassName("bg-primary");
            rideNow.addClassName("bg-primary-10");

            advertisementComponent.removeClassName("pulsing");
        });

        linkButtons.add(about, rideNow);
        return linkButtons;
    }

        private Image createIntroductionImage() {
        Image introductionImage = new Image("images/pickup.png", "Picking up someone image.");
        introductionImage.setWidth("50%");
        introductionImage.setMaxWidth("400px");
        introductionImage.addClassNames("introduction-image", "jumping");
        introductionImage.getStyle().set("filter", "drop-shadow(0 0 10px rgba(0,0,0,0.5))");
            
        return introductionImage;
    }

}
