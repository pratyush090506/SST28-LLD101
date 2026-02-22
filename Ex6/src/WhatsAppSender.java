/**
 * Honors base contract: does not throw. E.164 requirement reported via SendResult when not met.
 */
public class WhatsAppSender extends NotificationSender {
    public WhatsAppSender(AuditLog audit) { super(audit); }

    @Override
    public SendResult send(Notification n) {
        if (n.phone == null || !n.phone.startsWith("+")) {
            return SendResult.error("phone must start with + and country code");
        }
        System.out.println("WA -> to=" + n.phone + " body=" + n.body);
        audit.add("wa sent");
        return SendResult.success();
    }
}
