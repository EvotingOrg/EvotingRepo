package com.evoting.controller.util;

import com.evoting.entity.Users;
import com.evoting.enums.RoleTypeEnum;
import com.evoting.facade.GroupsFacade;
import com.evoting.facade.UsersFacade;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * This JSF/CDI Managed Bean provides a way for users to log out of the
 * application.
 */
@Named(value = "sessionBean")
@SessionScoped
public class SessionBean implements Serializable {

    private static Logger log = Logger.getLogger(SessionBean.class.getName());

    @Inject
    private UsersFacade userFacade;
    @Inject
    private GroupsFacade groupFacade;
    private Users currentUser;

    //ui handler
    private String selectedAdminPage;
    private String selectedUserPage;

    public Users getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Users currentUser) {
        this.currentUser = currentUser;
    }

    public String getSelectedAdminPage() {
        return selectedAdminPage;
    }

    public void setSelectedAdminPage(String selectedAdminPage) {
        this.selectedAdminPage = selectedAdminPage;
    }

    public String getSelectedUserPage() {
        return selectedUserPage;
    }

    public void setSelectedUserPage(String selectedUserPage) {
        this.selectedUserPage = selectedUserPage;
    }

    public RoleTypeEnum getUserRole() {
        return currentUser == null ? null : currentUser.getGroup().getGroupName();
    }

    private void instantiateUserGroup() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        setCurrentUser(userFacade.findByUserName(request.getRemoteUser()));
        if (getCurrentUser().getGroup() == null) {
            getCurrentUser().setGroup(groupFacade.findByUserName(getCurrentUser().getUserName()));
        }
    }

    public boolean isAdmin() {
        if (getUserRole() == null) {
            instantiateUserGroup();
            return getCurrentUser().getGroup().getGroupName().equals(RoleTypeEnum.admin);
        } else if (getUserRole().equals(RoleTypeEnum.admin)) {
            return true;
        } else if (getUserRole().equals(RoleTypeEnum.user)) {
            return false;
        }
        return false;
    }

    public boolean isLoggedIn() {
        return ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRemoteUser() == null ? false : true;
    }

    public String getLoggedInUser() {
        String loggedUser = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRemoteUser();
        if (loggedUser == null) {
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
            setCurrentUser(null);
            // this does not invalidate the session but does null out the user Principle
            request.logout();
        } catch (ServletException e) {
            log.log(Level.SEVERE, "Failed to logout user!", e);
            destination = "../loginerror?faces-redirect=true";
        }
        return destination; // go to destination
    }

    public void initializeUser() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        String userName = request.getRemoteUser();
        if (userName != null) {
            setCurrentUser(userFacade.findByUserName(request.getRemoteUser()));
        }
    }

    public String userAdminIndexPageNavigateByRole() {
        initializeUser();
        if (getUserRole() != null && getUserRole().equals(RoleTypeEnum.admin)) {
            return "faces/admin/index.xhtml?faces-redirect=true";
        } else if (getUserRole() != null && getUserRole().equals(RoleTypeEnum.user)) {
            return "faces/user/index.xhtml?faces-redirect=true";
        } else {
            return null;
        }
    }
}
