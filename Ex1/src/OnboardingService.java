import java.util.*;

public class OnboardingService {
    private final StudentRepository db;
    private final InputParser parser = new InputParser();
    private final StudentValidator validator = new StudentValidator();
    private final OnboardingPrinter printer = new OnboardingPrinter();

    public OnboardingService(StudentRepository db) {
        this.db = db;
    }

    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) {
        printer.printInput(raw);
        Map<String, String> kv = parser.parse(raw);

        String name = kv.getOrDefault("name", "");
        String email = kv.getOrDefault("email", "");
        String phone = kv.getOrDefault("phone", "");
        String program = kv.getOrDefault("program", "");

        // validation inline, printing inline
        List<String> errors = validator.validate(name, email, phone, program);
        if (!errors.isEmpty()) {
            printer.printError(errors);
            return;
        }

        String id = IdUtil.nextStudentId(db.count());
        StudentRecord rec = new StudentRecord(id, name, email, phone, program);

        db.save(rec);
        printer.printSuccess(rec);
        printer.printSaved(db.count());
        printer.printConfirmation(rec);
    }
}
