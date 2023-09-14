package model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "typeOfNotification")
public class TypeOfNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private UUID uuid;

    @OneToMany(mappedBy = "typeOfNotification", cascade = CascadeType.REMOVE)
    private List<Notification> code;

    private String name;

    private String color;

    private byte[] icon;

    private int version = 0;

    @Length(max = 255)
    private String createdBy;

    @Length(max = 255)
    private String updatedBy;

    private LocalDateTime dateOfCreation;

    private LocalDateTime dateOfUpdate;

    private boolean signOfActivity = true;

    public TypeOfNotification() {

    }

    public TypeOfNotification(Long id,
                              UUID uuid,
                              List<Notification> code,
                              String name,
                              String color,
                              byte[] icon,
                              int version,
                              String createdBy,
                              String updatedBy,
                              LocalDateTime dateOfCreation,
                              LocalDateTime dateOfUpdate,
                              boolean signOfActivity) {
        this.id = id;
        this.uuid = uuid;
        this.code = code;
        this.name = name;
        this.color = color;
        this.icon = icon;
        this.version = version;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.dateOfCreation = dateOfCreation;
        this.dateOfUpdate = dateOfUpdate;
        this.signOfActivity = signOfActivity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public List<Notification> getCode() {
        return code;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCode(List<Notification> code) {
        this.code = code;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
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
