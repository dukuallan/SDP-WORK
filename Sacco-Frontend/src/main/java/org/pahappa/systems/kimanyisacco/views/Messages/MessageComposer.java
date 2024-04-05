package org.pahappa.systems.kimanyisacco.views.Messages;

import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;

public class MessageComposer {
    private MessageComposer() {
    }

    /**
     * Shows a message dialog with INFO severity
     *
     * @param title       - The title of the message
     * @param description - The description of the message
     */
    public static void compose(String title, String description) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, title, description);
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    /**
     * Shows a message dialog with WARN severity
     *
     * @param title       - The title of the message
     * @param description - The description of the message
     */
    public static void warn(String title, String description) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, title, description);
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    /**
     * Shows a message dialog with ERROR severity
     *
     * @param title       - The title of the message
     * @param description - The description of the message
     */
    public static void error(String title, String description) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, title, description);
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }
}