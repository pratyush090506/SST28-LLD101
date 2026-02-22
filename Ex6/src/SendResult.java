/**
 * Result of send: success or error. Base contract: send() never throws; use result instead.
 */
public class SendResult {
    public final String errorMessage;

    private SendResult(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static SendResult success() {
        return new SendResult(null);
    }

    public static SendResult error(String message) {
        return new SendResult(message);
    }

    public boolean isError() {
        return errorMessage != null;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
