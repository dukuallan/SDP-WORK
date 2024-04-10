package org.pahappa.systems.kimanyisacco.views.authentication;

import org.mindrot.jbcrypt.BCrypt;
import org.pahappa.systems.kimanyisacco.controllers.Hyperlinks;
import org.pahappa.systems.kimanyisacco.models.users.User;
import org.pahappa.systems.kimanyisacco.services.UserService;
import org.pahappa.systems.kimanyisacco.services.impl.UserServiceImpl;
import org.pahappa.systems.kimanyisacco.views.Messages.MessageComposer;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@ManagedBean(name = "loginForm")
@SessionScoped
public class LoginForm {
    private User user;
    private final UserService userservice;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LoginForm() {

        this.user = new User();
        this.userservice = new UserServiceImpl();
    }

    // Perform login
    public void doLogin() throws IOException {
        String email = user.getEmail();
        String pass = user.getPassword();

        User user1 = userservice.getUserByEmail(email);
        if ((user1 != null) && user1.getEmail().equals(email) && BCrypt.checkpw(pass, user1.getPassword())) {
            if (user1.getStatus() == 0) {
                HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
                        .getSession(true);
                session.setAttribute("User", user1);
                String baseUrl = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
                FacesContext.getCurrentInstance().getExternalContext().redirect(baseUrl + Hyperlinks.dashboard);
            } else {
                MessageComposer.warn("Failure","Your account is frozen contact the admin");
                }
        } else {
           MessageComposer.warn("Failure","Invalid Credentials!");
        }
    }

    // perfom logout
    public void logout() {
        try {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            if (session != null) {
                session.invalidate();
                String baseUrl = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
                FacesContext.getCurrentInstance().getExternalContext().redirect(baseUrl + Hyperlinks.login);
            }
        } catch (IOException e) {
            MessageComposer.error("Failed","Failed to Logout,An error occurred!");
            e.printStackTrace();
        }
    }
}
