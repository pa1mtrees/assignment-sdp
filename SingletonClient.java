public class SingletonClient {
    public static void main(String[] args) {
        Singleton singletonInstance1 = Singleton.getInstance();

        singletonInstance1.showMessage();

        Singleton singletonInstance2 = Singleton.getInstance();

        if (singletonInstance1 == singletonInstance2) {
            System.out.println("Both instances are the same. Singleton pattern works!");
        } else {
            System.out.println("Singleton pattern is not working as expected.");
        }
    }
}
