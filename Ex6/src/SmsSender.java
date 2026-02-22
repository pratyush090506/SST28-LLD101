/**
 * Honors base contract: never throws. Subject is channel-appropriate to omit for SMS.
 */
public class SmsSender extends NotificationSender {
    public SmsSender(AuditLog audit) { super(audit); }

    @Override
    public SendResult send(Notification n) {
        System.out.println("SMS -> to=" + n.phone + " body=" + n.body);
        audit.add("sms sent");
        return SendResult.success();
    }
}
