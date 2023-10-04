import java.util.Scanner;

public class ShoppingCartDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Product product1 = new Product("Item 1", 10.0, 2);
        Product product2 = new Product("Item 2", 20.0, 1);
        cart.addProduct(product1);
        cart.addProduct(product2);

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Select a payment strategy:");
            System.out.println("1. Credit Card");
            System.out.println("2. PayPal");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            PaymentStrategyFactory strategyFactory = new PaymentStrategyFactory();
            IPaymentStrategy paymentStrategy = null;

            if (choice == 1) {
                paymentStrategy = strategyFactory.createPaymentStrategy("CreditCard", "1234-5678-9012-3456", "John Doe", "");
            } else if (choice == 2) {
                paymentStrategy = strategyFactory.createPaymentStrategy("PayPal", "", "", "john.doe@example.com");
            } else {
                System.out.println("Invalid choice.");
                return;
            }

            cart.setPaymentStrategy(paymentStrategy);
            cart.checkout();
        } finally {
            scanner.close();
        }
    }
}
