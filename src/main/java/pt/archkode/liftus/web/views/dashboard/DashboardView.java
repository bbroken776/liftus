package pt.archkode.liftus.web.views.dashboard;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Style.TextAlign;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import jakarta.annotation.security.RolesAllowed;
import pt.archkode.liftus.web.layouts.DashboardLayout;

@PageTitle("User Dashboard")
@Route(value = "dashboard", layout = DashboardLayout.class)
@RolesAllowed({"USER", "DRIVER", "ADMIN"})
public class DashboardView extends VerticalLayout {

    public DashboardView() {
        setSpacing(false);

        H2 header = new H2("This place intentionally left empty");
        header.addClassNames(Margin.Top.XLARGE, Margin.Bottom.MEDIUM);
        add(header);
        add(new Paragraph("Its a place where you can grow your own UI 🤗"));

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().setTextAlign(TextAlign.CENTER);
    }

}
