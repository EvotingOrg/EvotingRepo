/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evoting.controller.util;

import com.evoting.facade.UserDetailFacade;
import com.evoting.facade.UsersFacade;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author HSA
 */
@Named(value = "fileUploadController")
@SessionScoped
public class FileUploadController implements Serializable {
    
    @EJB
    private UserDetailFacade userDetailFacade;
      
    
     private UploadedFile file;
    private String destination = "D:\\images\\";

    public FileUploadController() {
    }
    
     public UploadedFile getFile() {
        return file;
    }
     
      public void setFile(UploadedFile file) {
        this.file = file;
        System.out.println(this.file.getFileName());
    }

    public void upload() {
        if (file != null) {
            FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);

            try {
                copyFile(file.getFileName(), file.getInputstream());
                
               
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void copyFile(String fileName, InputStream in) {
        try {

            // write the inputStream to a FileOutputStream
            OutputStream out = new FileOutputStream(new File(destination + fileName));

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            in.close();
            out.flush();
            out.close();

            System.out.println("New file created!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
