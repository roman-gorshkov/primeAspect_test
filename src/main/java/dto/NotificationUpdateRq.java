package dto;

import model.TypeOfNotification;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

public class NotificationUpdateRq implements Serializable {

    @Length(max = 255)
    private String from;

    private TypeOfNotification type;

    private boolean receiptSign;

    private boolean signOfActivity;


    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
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

    public boolean isSignOfActivity() {
        return signOfActivity;
    }

    public void setSignOfActivity(boolean signOfActivity) {
        this.signOfActivity = signOfActivity;
    }
}
