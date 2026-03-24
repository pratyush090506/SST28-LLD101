import java.util.List;

public class OnboardingPrinter {
    public void printInput(String raw) {
        System.out.println("INPUT: " + raw);
    }

    public void printSuccess(StudentRecord r) {
        System.out.println("OK: created student " + r.id);
    }

    public void printError(List<String> errors) {
        System.out.println("ERROR: cannot register");
        for (String e : errors)
            System.out.println("  " + e);
    }

    public void printSaved(int count) {
        System.out.println("Saved. Total students: " + count);
    }

    public void printConfirmation(StudentRecord r) {
        System.out.println("CONFIRMATION:");
        System.out.println(r);
    }

    public void printDbDump(StudentRepository db) {
        System.out.println("-- DB DUMP --");
        System.out.println(TextTable.render3(db));
    }
}
