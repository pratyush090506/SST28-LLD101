import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Single responsibility: validate parsed registration data.
 * Error messages and order match original behavior.
 * Program list is configurable (stretch) without touching onboarding workflow.
 */
public class RegistrationValidator {
    private final Set<String> allowedPrograms;

    public RegistrationValidator() {
        this.allowedPrograms = Set.of("CSE", "AI", "SWE");
    }

    public RegistrationValidator(String... programs) {
        this.allowedPrograms = Arrays.stream(programs).collect(Collectors.toSet());
    }

    public ValidationResult validate(ParsedRegistration p) {
        List<String> errors = new ArrayList<>();
        if (p.name.isBlank()) errors.add("name is required");
        if (p.email.isBlank() || !p.email.contains("@")) errors.add("email is invalid");
        if (p.phone.isBlank() || !p.phone.chars().allMatch(Character::isDigit)) errors.add("phone is invalid");
        if (!allowedPrograms.contains(p.program)) errors.add("program is invalid");
        return new ValidationResult(errors);
    }
}
