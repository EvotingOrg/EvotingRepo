/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evoting.controller;

import com.evoting.entity.AbstractLongPKEntity;
import com.evoting.facade.AbstractFacade;
import java.io.Serializable;
import javax.inject.Inject;
import org.jboss.seam.international.status.Messages;

/**
 *
 * @author Rajesh Yadav <developerrajeshyadav@gmail.com>
 * @param <T>
 */
public abstract class AbstractViewController<T> implements Serializable {

    private Long idViewNavigate = 0l;
    @Inject
    protected Messages messages;
    private T current;

    public abstract AbstractFacade<T> getFacade();

    public T getSelected() {
        return current;
    }

    public void setSelected(T current) {
        this.current = current;
    }

    public Long getIdViewNavigate() {
        return idViewNavigate;
    }

    public void setIdViewNavigate(Long idViewNavigate) {
        this.idViewNavigate = idViewNavigate;
    }

    public void initToGetViewData() {
        try {
            setSelected(getFacade().find(idViewNavigate));
        } catch (Exception ex) {
        }
    }

    public String prepareEdit(AbstractLongPKEntity selected) {
        setSelected((T) selected);
        return "Edit?faces-redirect=true&id=" + selected.getId();
    }

    public String update(AbstractLongPKEntity selected) {
        try {
            getFacade().edit((T) selected);
            messages.info("Updated_Sucessfully");
            return "View?faces-redirect=true&id=" + selected.getId();
        } catch (Exception e) {
            messages.error("Persistence Error Occured");
            return null;
        }
    }

    // for dialog box
    public void prepareEditForDialog(AbstractLongPKEntity selected) {
        setSelected((T) selected);
    }

    public void prepareViewForDialog(AbstractLongPKEntity selected) {
        setSelected((T) selected);
    }
}
