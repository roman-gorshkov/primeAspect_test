package exception;

public enum CustomErrorCode {
    TYPE_NOT_FOUND("Тип не найден"),
    NOTIFICATION_NOT_FOUND("Уведомление не найдено");


    CustomErrorCode(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }
}
