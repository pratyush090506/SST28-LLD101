/**
 * Orchestrates registration workflow: parse -> validate -> persist -> confirm.
 * No longer parses, validates, or formats output; uses composed components.
 */
public class OnboardingService {
    private final InputParser parser;
    private final RegistrationValidator validator;
    private final StudentStore store;
    private final OnboardingPrinter printer;

    public OnboardingService(InputParser parser, RegistrationValidator validator,
                             StudentStore store, OnboardingPrinter printer) {
        this.parser = parser;
        this.validator = validator;
        this.store = store;
        this.printer = printer;
    }

    public void registerFromRawInput(String raw) {
        ParsedRegistration parsed = parser.parse(raw);
        printer.printInput(raw);

        ValidationResult result = validator.validate(parsed);
        if (!result.isValid()) {
            printer.printValidationErrors(result.getErrors());
            return;
        }

        String id = IdUtil.nextStudentId(store.count());
        StudentRecord rec = new StudentRecord(id, parsed.name, parsed.email, parsed.phone, parsed.program);
        store.save(rec);
        printer.printSuccess(rec, store.count());
    }
}
