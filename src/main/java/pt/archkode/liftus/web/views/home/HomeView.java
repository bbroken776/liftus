package pt.archkode.liftus.web.views.home;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import pt.archkode.liftus.web.layouts.MainLayout;
import pt.archkode.liftus.web.views.login.LoginView;

@PageTitle("Home")
@Route(value = "", layout = MainLayout.class)
@AnonymousAllowed
@CssImport("./styles/home.css")
public class HomeView extends Div {

    public HomeView() {
        setWidthFull();

        HorizontalLayout introductionSection = new HorizontalLayout();
        introductionSection.setWidthFull();
        introductionSection.addClassName("p-m");
        introductionSection.getStyle().set("margin-top", "100px");
        introductionSection.setAlignItems(Alignment.CENTER);
        introductionSection.setJustifyContentMode(JustifyContentMode.EVENLY);

        VerticalLayout introductionText = new VerticalLayout();
        introductionText.setWidth("600px");
        introductionText.setAlignItems(Alignment.START);
        introductionText.setJustifyContentMode(JustifyContentMode.CENTER);

        Span advertisement = new Span("Create your account today and get 50% off your first ride!");
        advertisement.addClassNames("text-xs", "text-body", "text-primary", "font-bold", "p-s", "rounded-l", "bg-primary-10");

        H1 title = new H1("Welcome to Liftus");
        title.addClassNames("font-bold", "text-3xl", "text-header", "text-primary");

        Span introduction = new Span("Liftus is a cutting-edge ride-sharing platform that connects drivers and passengers in real time, offering a quick and reliable way to get around. Whether you're commuting to work, running errands, or heading out for a night on the town, simply request a ride via our user-friendly app, and a driver will arrive to pick you up within minutes. Experience the convenience of modern transportation with Liftus!");
        introduction.addClassNames("text-m", "text-body");

        HorizontalLayout linkButtons = new HorizontalLayout();
        Anchor about = new Anchor("#about", "Learn more about us!");
        about.addClassNames("text-xs", "text-body", "font-bold", "p-s", "rounded-l", "border", "border-primary-50");
        about.getStyle().set("transition", "all 0.3s");
        about.getElement().addEventListener("mouseover", e -> about.getStyle().set("transform", "scale(1.05)"));
        about.getElement().addEventListener("mouseout", e -> about.getStyle().set("transform", "scale(1)"));

        RouterLink rideNow = new RouterLink("Ride Now", LoginView.class);
        rideNow.addClassNames("text-xs", "text-header", "text-primary", "font-bold", "p-s", "rounded-l", "bg-primary-10");
        rideNow.getStyle().set("transition", "all 0.3s");

        rideNow.getElement().addEventListener("mouseover", e -> {
            rideNow.getStyle().set("color", "white");
            rideNow.removeClassName("bg-primary-10");
            rideNow.addClassName("bg-primary");

            advertisement.addClassName("pulsing");
        });

        rideNow.getElement().addEventListener("mouseout", e -> {
            rideNow.getStyle().set("color", "var(--lumo-primary-color)");
            rideNow.removeClassName("bg-primary");
            rideNow.addClassName("bg-primary-10");

            advertisement.removeClassName("pulsing");
        });

        linkButtons.add(about, rideNow);
        introductionText.add(advertisement, title, introduction, linkButtons);

        Image introductionImage = new Image("images/pickup.png", "Picking up someone image.");
        introductionImage.setWidth("50%");
        introductionImage.setMaxWidth("400px");        introductionImage.addClassName("jumping");
        introductionImage.addClassName("jumping");
        introductionImage.getStyle().set("filter", "drop-shadow(0 0 10px rgba(0,0,0,0.5))");

        introductionSection.add(introductionText, introductionImage);
        add(introductionSection);
    }

}
