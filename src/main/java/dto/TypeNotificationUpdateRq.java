package dto;

import model.Notification;
import org.hibernate.validator.constraints.Length;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class TypeNotificationUpdateRq implements Serializable {

    @Length(max = 100)
    @OneToMany(mappedBy = "typeOfNotification", cascade = CascadeType.REMOVE)
    private List<Notification> code;

    @Length(max = 255)
    private String name;

    @Length(max = 6)
    private String color;

    private byte[] icon;

    @Length(max = 255)
    private String updatedBy;

    private boolean signOfActivity;

    private LocalDateTime dateOfUpdate;


    public List<Notification> getCode() {
        return code;
    }

    public void setCode(List<Notification> code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public byte[] getIcon() {
        return icon;
    }

    public void setIcon(byte[] icon) {
        this.icon = icon;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getDateOfUpdate() {
        return dateOfUpdate;
    }

    public void setDateOfUpdate(LocalDateTime dateOfUpdate) {
        this.dateOfUpdate = dateOfUpdate;
    }

    public boolean isSignOfActivity() {
        return signOfActivity;
    }

    public void setSignOfActivity(boolean signOfActivity) {
        this.signOfActivity = signOfActivity;
    }
}
