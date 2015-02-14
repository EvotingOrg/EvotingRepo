package com.evoting.controller.util;

import com.evoting.entity.Groups;
import com.evoting.enums.RoleTypeEnum;
import com.evoting.facade.GroupsFacade;
import com.evoting.facade.UsersFacade;
import java.io.Serializable;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.auth.Subject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * This JSF/CDI Managed Bean provides a way for users to log out of the
 * application.
 */
@Named(value = "logoutBean")
@SessionScoped
public class LogoutBean implements Serializable {

    @Inject
    private UsersFacade userFacade;
    @Inject
    private GroupsFacade groupFacade;
    private static Logger log = Logger.getLogger(LogoutBean.class.getName());
    private RoleTypeEnum userRole;

    public RoleTypeEnum getUserRole() {
        return userRole;
    }

    public void setUserRole(RoleTypeEnum userRole) {
        this.userRole = userRole;
    }

    public boolean isAdmin() {
        if (userRole == null) {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            Groups group = groupFacade.findByUserName(request.getRemoteUser());
            setUserRole(RoleTypeEnum.valueOf(group.getGroupName()));
            return userRole.equals(userRole.Admin);
        } else if (userRole.equals(RoleTypeEnum.Admin)) {
            return true;
        } else if (userRole.equals(RoleTypeEnum.User)) {
            return false;
        }
        return false;
    }

    public boolean isLoggedIn() {
        return ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRemoteUser() == null ? true : false;
    }

    public String getLoggedInUser() {
        String loggedUser = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRemoteUser();
        if(loggedUser == null) {
            return "Guest";
        }
        return loggedUser;
    }

    public String logout() {
        // Notice the redirect syntax. The forward slash means start at
        // the root of the web application.
        String destination = "/index?faces-redirect=true";

        // FacesContext provides access to other container managed objects,
        // such as the HttpServletRequest object, which is needed to perform
        // the logout operation.
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request
                = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            HttpSession session = request.getSession();
            session.invalidate();
            setUserRole(null);
            // this does not invalidate the session but does null out the user Principle
            request.logout();
        } catch (ServletException e) {
            log.log(Level.SEVERE, "Failed to logout user!", e);
            destination = "../loginerror?faces-redirect=true";
        }

        return destination; // go to destination
    }

}
