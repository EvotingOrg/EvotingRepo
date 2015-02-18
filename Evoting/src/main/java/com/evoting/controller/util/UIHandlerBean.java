/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evoting.controller.util;

import com.evoting.entity.Groups;
import com.evoting.entity.Users;
import com.evoting.enums.RoleTypeEnum;
import com.evoting.facade.GroupsFacade;
import com.evoting.facade.UsersFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Rajesh Yadav <developerrajeshyadav@gmail.com>
 */
@Named("uiHandlerBean")
@SessionScoped
public class UIHandlerBean implements Serializable {

    @Inject
    private GroupsFacade groupFacade;
    @Inject
    private SessionBean sessionBean;
    
    private String selectedAdminPage;
    private String selectedUserPage;
    private Groups currentUser;

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

    public void setGroupFacade(GroupsFacade groupFacade) {
        this.groupFacade = groupFacade;
    }

    public Groups getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Groups currentUser) {
        this.currentUser = currentUser;
    }

  

    public String userAdminIndexPageNavigateByRole() {
        if (currentUser.getGroupName().equals(RoleTypeEnum.admin)) {
            return "faces/admin/index.xhtml?faces-redirect=true";
        } else if (currentUser.getGroupName().equals(RoleTypeEnum.user)) {
            return "faces/user/index.xhtml?faces-redirect=true";
        } else {
            return null;
        }
    }
}
