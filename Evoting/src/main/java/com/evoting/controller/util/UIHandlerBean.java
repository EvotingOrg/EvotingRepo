/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evoting.controller.util;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Rajesh Yadav <developerrajeshyadav@gmail.com>
 */
@Named("uiHandlerBean")
@SessionScoped
public class UIHandlerBean implements Serializable {

    private String selectedAdminPage;
    private String selectedUserPage;

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
}
