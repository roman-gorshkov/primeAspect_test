package exception;

public class CustomException extends Exception {
    private CustomErrorCode customErrorCode;

    public CustomException(CustomErrorCode customErrorCode) {
        this.customErrorCode = customErrorCode;
    }

    public CustomErrorCode getCustomErrorCode() {
        return customErrorCode;
    }

}
