package org.pahappa.systems.kimanyisacco.views.user;

import org.pahappa.systems.kimanyisacco.models.users.User;
import org.pahappa.systems.kimanyisacco.services.UserService;
import org.pahappa.systems.kimanyisacco.services.impl.UserServiceImpl;
import org.pahappa.systems.kimanyisacco.views.Messages.MessageComposer;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;
@ManagedBean(name = "userView")
@ViewScoped
public class UserView {
        List<User> userList;
        private UserService userService;

        @PostConstruct
        public void init() {
            this.userService= new UserServiceImpl();
            this.userList=userService.getAllUsers();
        }

        public void deleteUser(User user) {
            boolean check = userService.deleteUser(user.getEmail());
            if (check) {
                userList.remove(user);
               MessageComposer.compose("Success","User removed from the system");
            } else {
                MessageComposer.error("Failed","User not deleted!");

            }
        }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}


