package org.pahappa.systems.kimanyisacco.views.user;


import org.pahappa.systems.kimanyisacco.constants.Department;
import org.pahappa.systems.kimanyisacco.controllers.Hyperlinks;
import org.pahappa.systems.kimanyisacco.models.users.User;
import org.pahappa.systems.kimanyisacco.services.UserService;
import org.pahappa.systems.kimanyisacco.services.impl.UserServiceImpl;
import org.pahappa.systems.kimanyisacco.views.Messages.MessageComposer;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@ManagedBean(name = "userRegister")
@SessionScoped
public class UserRegisterView {
    private User user;
    private UserService userService;
    private List<Department> departmentList;
    private String confirmPassword;
    private Long selectedObjectId;

    @PostConstruct
    public void init(){
        this.userService = new UserServiceImpl();
        this.user = new User();
        this.departmentList= Arrays.asList(Department.values());
    }
//save a user and reset the model
    public void saveUser() {
        try {
            userService.saveUser(user);
            resetModal();
            String baseUrl = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
            redirect(baseUrl,Hyperlinks.users);
        }catch (Exception e){
            MessageComposer.warn("Failed",e.getMessage());
        }
    }
    public void editUser(User user){
        System.out.println("User to edit: "+user.getLastname());
        System.out.println("User id: "+user.getUser_id());
        setSelectedObjectId(user.getUser_id());
        System.out.println("Selected object id: "+ selectedObjectId);
        this.user=user;
        String baseUrl = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
        redirect(baseUrl,Hyperlinks.editUser);
    }
public void updateUser(){
    System.out.println("Update Reached");
    System.out.println("Object id: "+user.getUser_id());
    System.out.println("Object parameters"+user.getLastname());
    this.user.setUser_id(selectedObjectId);
    System.out.println("Object id: "+user.getUser_id()+"selected object "+selectedObjectId);
        boolean update=userService.updateUser(user);
        if(update){
            resetModal();
            MessageComposer.compose("Success","User updated successfully!");
        }
        else
            MessageComposer.warn("Failed","Failed to updated the user details");
}
public void redirect(String baseurl,String pageLink){
    try {
        FacesContext.getCurrentInstance().getExternalContext().redirect(baseurl +
                pageLink);
    }catch(IOException e){
        MessageComposer.warn("Failed","Failed to go to the desired page");
    }
}

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void resetModal(){
        this.user=new User();
        selectedObjectId=null;
   }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public Long getSelectedObjectId() {
        return selectedObjectId;
    }

    public void setSelectedObjectId(Long selectedObjectId) {
        this.selectedObjectId = selectedObjectId;
    }
}
