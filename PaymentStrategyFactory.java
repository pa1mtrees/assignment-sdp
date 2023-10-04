public class PaymentStrategyFactory {
    public IPaymentStrategy createPaymentStrategy(String strategyName, String cardNumber, String cardHolder, String email) {
        if ("CreditCard".equalsIgnoreCase(strategyName)) {
            return new CreditCardPayment(cardNumber, cardHolder);
        } else if ("PayPal".equalsIgnoreCase(strategyName)) {
            return new PayPalPayment(email);
        }
        // Add more strategy creation logic as needed
        return null; // Handle unknown strategies gracefully
    }
}
