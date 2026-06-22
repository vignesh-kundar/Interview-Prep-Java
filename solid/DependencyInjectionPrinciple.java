public class DependencyInjectionPrinciple {

    public static void main (String args []) {
        // High level module should not be dependent on Low level module, Both should be dependent on abstractions / Interfaces!
    }

    // problem
    class Problem {
        class Employee {
            // Here high level module (Employee) is directly dependent on the Solid Low level module (emailSender)
            // Causes Tight Coupling , Limited Reusability , Testability
            public void notifyEmployee(EmailSender emailSender) {
                emailSender.sendPromotionEmail(this);
            }
        }
        // Actual problem comes when we have to implement the new Notfication
        // via - whatsapp , sms etc etc ...
    }

    // Solution
    class Solution {
        interface Notifier {  void notifyPromotion(); }

        class EmailSender implements Notifier {  /*Core Buisness Logic*/ }
        class SmsSender implements Notifier { /*Core Businsess Lofic*/ }
        class Employee {
            public void sendPromotionalNotification( Notifier notifier ) {
                notifier.notifyPromotion(this);
            }
        }
    }
}