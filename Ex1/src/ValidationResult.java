import java.util.Collections;
import java.util.List;

/**
 * Result of validation: either valid or a list of error messages (order preserved).
 */
public class ValidationResult {
    private final List<String> errors;

    public ValidationResult(List<String> errors) {
        this.errors = errors != null ? errors : Collections.emptyList();
    }

    public boolean isValid() {
        return errors.isEmpty();
    }

    public List<String> getErrors() {
        return errors;
    }
}
