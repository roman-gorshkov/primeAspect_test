package model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private UUID uuid;

    private String from;

    private String subject;

    private String text;

    @ManyToOne
    @JoinColumn(name = "typeOfNotification_code")
    private TypeOfNotification type;

    private boolean receiptSign = false;

    private int version = 0;

    @Length(max = 255)
    private String createdBy;

    @Length(max = 255)
    private String updatedBy;

    private LocalDateTime dateOfCreation;

    private LocalDateTime dateOfUpdate;

    private boolean signOfActivity = true;

    public Notification() {

    }

    public Notification(Long id,
                        UUID uuid,
                        String from,
                        String subject,
                        String text,
                        TypeOfNotification type,
                        boolean receiptSign,
                        int version,
                        String createdBy,
                        String updatedBy,
                        LocalDateTime dateOfCreation,
                        LocalDateTime dateOfUpdate,
                        boolean signOfActivity) {
        this.id = id;
        this.uuid = uuid;
        this.from = from;
        this.subject = subject;
        this.text = text;
        this.type = type;
        this.receiptSign = receiptSign;
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

    public boolean isReceiptSign() {
        return receiptSign;
    }

    public void setReceiptSign(boolean receiptSign) {
        this.receiptSign = receiptSign;
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
