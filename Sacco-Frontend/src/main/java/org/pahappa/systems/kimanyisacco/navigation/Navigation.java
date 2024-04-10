package org.pahappa.systems.kimanyisacco.navigation;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * Contains the links to the different pages with in the application.
 * It is to help us navigate between the pages in the application easily.
 */
@ManagedBean(name = "navigation")
@ApplicationScoped
public class Navigation {
    private final String dashboard="/pages/dashboard/Dashboard.xhtml";
    private final String users= "/pages/users/Users.xhtml";
    private final String addUser= "/pages/users/AddUser.xhtml";
    private final String patients = "/pages/Patient/PatientInformation.xhtml";
    private final String viewPatients = "/pages/Patient/PatientView.xhtml";
    private final String login= "/pages/welcome/Welcome.xhtml";
    public String getUsers() {
        return users;
    }

    public String getAddUser() {
        return addUser;
    }

    public String getPatients() {
        return patients;
    }

    public String getDashboard() {
        return dashboard;
    }

    public String getViewPatients() {
        return viewPatients;
    }
        public String getLogin () {
            return login;
        }
    }
