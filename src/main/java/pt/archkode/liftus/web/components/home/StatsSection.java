package pt.archkode.liftus.web.components.home;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.UI;
import pt.archkode.liftus.web.components.shared.SectionComponent;

@CssImport("./styles/home.css")
@JavaScript("./js/counter.js") 
public class StatsSection extends SectionComponent {
    public StatsSection() {
        super("stats", "stats-section");

        VerticalLayout statsWrapper = new VerticalLayout();
        statsWrapper.setSpacing(false);
        statsWrapper.setPadding(false);
        statsWrapper.setAlignItems(Alignment.CENTER);

        VerticalLayout statsTitle = createStatsTitle();
        Div statsCards = createStatsCards();
        
        statsWrapper.add(statsTitle, statsCards);
        
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        addComponents(statsWrapper);

        UI.getCurrent().getPage().executeJs("startCountingAnimation()");
    }

    private VerticalLayout createStatsTitle() {
        VerticalLayout statsTitle = new VerticalLayout();
        statsTitle.setPadding(false);
        statsTitle.setSpacing(false);
        statsTitle.setAlignItems(Alignment.CENTER);
        
        H2 title = new H2("Our Stats");
        title.addClassNames("text-2xl", "font-bold", "text-primary");
        title.getStyle().set("margin", "0 0 10px 0");
        
        Div divider = new Div();
        divider.setWidth("200px");
        divider.setHeight("2px");
        divider.addClassNames("bg-contrast-10", "rounded-full");
        
        statsTitle.add(title, divider);
        return statsTitle;
    }

    private Div createStatsCards() {
        Div statsCards = new Div();
        statsCards.addClassNames("stats-cards", "p-m");
        statsCards.getStyle().set("margin-top", "20px");

        statsCards.add(
                createStatCard("1000", "Drivers"),
                createStatCard("5000", "Passengers"),
                createStatCard("10000", "Rides"),
                createStatCard("4.9", "Average Rating")
        );
        
        return statsCards;
    }

    private Div createStatCard(String data, String text) {
        Div statCard = new Div();
        statCard.addClassNames("stat-card", "p-m", "rounded-l", "bg-primary-10");
        statCard.setWidthFull();
        
        H2 dataText = new H2(data);
        dataText.addClassNames("text-3xl", "font-bold", "text-primary", "counter");
        
        Span textText = new Span(text);
        textText.addClassNames("card-text", "text-xs", "text-body", "text-contrast");
        
        statCard.add(dataText, textText);
        return statCard;
    }
}