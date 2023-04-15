package py.edu.facitec.mymail.Models;

import java.util.Date;

public class Email {

    private String subject;
    private String sender;
    private String message;
    private String color;

    public Email(String subject, String sender, String message, String color, Date dateSend) {
        this.subject = subject;
        this.sender = sender;
        this.message = message;
        this.color = color;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}
