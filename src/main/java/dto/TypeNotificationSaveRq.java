package dto;

import model.Notification;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.List;

public class TypeNotificationSaveRq implements Serializable {

    @Length(max = 100)
    private List<Notification> code;

    @Length(max = 255)
    private String name;

    @Length(max = 6)
    private String color;

    private byte[] icon;

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
}
