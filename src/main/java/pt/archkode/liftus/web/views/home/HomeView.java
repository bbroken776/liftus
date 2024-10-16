package pt.archkode.liftus.web.views.home;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import pt.archkode.liftus.web.components.SectionComponent;
import pt.archkode.liftus.web.components.WrapperComponent;
import pt.archkode.liftus.web.layouts.MainLayout;
import pt.archkode.liftus.web.views.login.LoginView;

@PageTitle("Home")
@Route(value = "", layout = MainLayout.class)
@AnonymousAllowed
@CssImport("./styles/home.css")
public class HomeView extends WrapperComponent {

    public HomeView() {
        setWidthFull();

        SectionComponent introductionSection = new SectionComponent("introduction", "introduction-section");
        introductionSection.addComponents(createIntroText(), createIntroImage());

        SectionComponent statsSection = new SectionComponent("stats", "stats-section");
        statsSection.addComponents(new Span("Stats section"));

        add(introductionSection, statsSection);
    }

    private VerticalLayout createIntroText() {
        VerticalLayout introductionText = new VerticalLayout();
        introductionText.setClassName("introduction-text");
        introductionText.setMaxWidth("600px");
        introductionText.setAlignItems(Alignment.START);
        introductionText.setJustifyContentMode(JustifyContentMode.CENTER);

        Span advertisement = new Span("Create your account today and get 50% off your first ride!");
        advertisement.addClassNames("introduction-advertisement", "text-xs", "text-body", "text-primary", "font-bold", "p-s", "rounded-l", "bg-primary-10");

        H1 title = new H1("Welcome to Liftus");
        title.addClassNames("font-bold", "text-3xl", "text-header", "text-primary");
        title.getStyle().set("margin-top", "20px");

        Span introduction = new Span("Liftus is a cutting-edge ride-sharing platform that connects drivers and passengers in real time, offering a quick and reliable way to get around. Whether you're commuting to work, running errands, or heading out for a night on the town, simply request a ride via our user-friendly app, and a driver will arrive to pick you up within minutes. Experience the convenience of modern transportation with Liftus!");
        introduction.addClassNames("text-m", "text-body");

        introductionText.add(advertisement, title, introduction, createIntroTextButtons(advertisement));
        return introductionText;
    }

    private HorizontalLayout createIntroTextButtons(Component advertisementComponent) {
        HorizontalLayout linkButtons = new HorizontalLayout();
        linkButtons.setClassName("introduction-buttons");
        linkButtons.getStyle().set("margin-top", "20px");

        Anchor about = new Anchor("#about", "Learn more about us!");
        about.addClassNames("text-xs", "text-body", "font-bold", "p-s", "rounded-l", "border", "border-primary-50");
        about.getStyle().set("transition", "all 0.3s");

        about.getElement().addEventListener("mouseover", e -> about.getStyle().set("transform", "scale(1.05)"));
        about.getElement().addEventListener("mouseout", e -> about.getStyle().set("transform", "scale(1)"));

        RouterLink rideNow = new RouterLink("Ride Now", LoginView.class);
        rideNow.addClassNames("text-xs", "text-header", "text-primary", "font-bold", "p-s", "rounded-l", "bg-primary-10");
        rideNow.getStyle().set("transition", "all 0.3s");
        rideNow.getStyle().set("width", "100px");
        rideNow.getStyle().set("text-align", "center");

        rideNow.getElement().addEventListener("mouseover", e -> {
            rideNow.getStyle().set("color", "white");
            rideNow.removeClassName("bg-primary-10");
            rideNow.addClassName("bg-primary");

            advertisementComponent.addClassName("pulsing");
        });

        rideNow.getElement().addEventListener("mouseout", e -> {
            rideNow.getStyle().set("color", "var(--lumo-primary-color)");
            rideNow.removeClassName("bg-primary");
            rideNow.addClassName("bg-primary-10");

            advertisementComponent.removeClassName("pulsing");
        });

        linkButtons.add(about, rideNow);
        return linkButtons;
    }

    private Image createIntroImage() {
        Image introductionImage = new Image("images/pickup.png", "Picking up someone image.");
        introductionImage.setWidth("50%");
        introductionImage.setMaxWidth("400px");
        introductionImage.addClassNames("introduction-image", "jumping");
        introductionImage.getStyle().set("filter", "drop-shadow(0 0 10px rgba(0,0,0,0.5))");

        return introductionImage;
    }

}
