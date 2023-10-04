import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> cartItems = new ArrayList<>();
    private IPaymentStrategy paymentStrategy;

    public void addProduct(Product product) {
        cartItems.add(product);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Product product : cartItems) {
            totalPrice += product.getPrice() * product.getQuantity();
        }
        return totalPrice;
    }

    public void setPaymentStrategy(IPaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout() {
        double totalAmount = calculateTotalPrice();
        if (paymentStrategy != null) {
            paymentStrategy.processPayment(totalAmount);
        } else {
            System.out.println("Please set a payment strategy before checkout.");
        }
    }
}
