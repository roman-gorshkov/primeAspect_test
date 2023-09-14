package dto;

import model.TypeOfNotification;
import org.hibernate.validator.constraints.Length;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDateTime;

public class NotificationSaveRq implements Serializable {

    @Length(max = 255)
    private String from;

    @Length(max = 255)
    private String subject;

    private String text;

    private TypeOfNotification type;

    @Length(max = 255)
    private String createdBy;


    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TypeOfNotification getType() {
        return type;
    }

    public void setType(TypeOfNotification type) {
        this.type = type;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
