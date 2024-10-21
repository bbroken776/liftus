package pt.archkode.liftus.web.views.auth;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.flow.server.VaadinService;

import jakarta.annotation.security.PermitAll;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Route("auth/logout")
@PermitAll
public class LogoutView extends VerticalLayout {

    public LogoutView() {
        // Get HttpServletRequest and HttpServletResponse from VaadinService
        HttpServletRequest request =  (HttpServletRequest) VaadinService.getCurrentRequest();
        HttpServletResponse response = (HttpServletResponse) VaadinService.getCurrentResponse();

        // Perform logout
        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
        logoutHandler.logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        
    }
}