import java.util.List;

/**
 * Persistence abstraction for student records.
 * Onboarding flow depends on this interface, not on FakeDb.
 */
public interface StudentStore {
    void save(StudentRecord r);
    int count();
    List<StudentRecord> all();
}
