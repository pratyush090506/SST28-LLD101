/**
 * Structured result of parsing raw registration input.
 * Passed between parser and validator (no re-parsing).
 */
public class ParsedRegistration {
    public final String name;
    public final String email;
    public final String phone;
    public final String program;

    public ParsedRegistration(String name, String email, String phone, String program) {
        this.name = name != null ? name : "";
        this.email = email != null ? email : "";
        this.phone = phone != null ? phone : "";
        this.program = program != null ? program : "";
    }
}
