public class FactoryPattern {

    interface Payment {
        void pay(double amount);
    }

    static class CreditCardPayment implements Payment {
        public void pay(double amount) {
            System.out.println("Paid ₹" + amount + " using Credit Card");
        }
    }

    static class UPIPayment implements Payment {
        public void pay(double amount) {
            System.out.println("Paid ₹" + amount + " using UPI");
        }
    }

    static class NetBankingPayment implements Payment {
        public void pay(double amount) {
            System.out.println("Paid ₹" + amount + " using Net Banking");
        }
    }

    static class PaymentFactory {
        public static Payment getPayment(String type) {

            if (type == null) {
                throw new IllegalArgumentException("Payment type cannot be null");
            }

            switch (type.toUpperCase()) {
                case "CREDIT":
                    return new CreditCardPayment();
                case "UPI":
                    return new UPIPayment();
                case "NETBANKING":
                    return new NetBankingPayment();
                default:
                    throw new IllegalArgumentException("Invalid payment type");
            }
        }
    }

    public static void main(String[] args) {

        Payment payment1 = PaymentFactory.getPayment("UPI");
        payment1.pay(1000);

        Payment payment2 = PaymentFactory.getPayment("CREDIT");
        payment2.pay(2500);
    }
}
