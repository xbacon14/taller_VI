package py.edu.facitec.mymail.Models;

import java.util.Date;

import py.edu.facitec.mymail.Utils.Util;

public class Email {

    private String subject;
    private String sender;
    private String message;
    private String color;

    public Email(String subject, String sender, String message, String color, Date dateSend) {
        this.subject = subject;
        this.sender = sender;
        this.message = message;
        this.color = Util.getRandomColor();
    }

    public Email(String subject, String message, String sender) {
        this.subject=subject;
        this.message = message;
        this.sender=sender;
    }

    public Email() {

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
