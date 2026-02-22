/**
 * Base contract (LSP-friendly):
 * - send(Notification) never throws.
 * - Returns SendResult (success or error message). Invalid/channel-specific constraints
 *   are reported via result, not by tightening preconditions.
 * - No subtype may reject requests the base accepts; channel limits are reported as errors.
 */
public abstract class NotificationSender {
    protected final AuditLog audit;
    protected NotificationSender(AuditLog audit) { this.audit = audit; }
    public abstract SendResult send(Notification n);
}
