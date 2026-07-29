package tms_maven;

public class Main {
    public static void main(String[] args) {
        // Singleton
        System.out.println("=== Singleton ===");
        DBConnection_Singleton db1 = DBConnection_Singleton.getInstance();
        DBConnection_Singleton db2 = DBConnection_Singleton.getInstance();
        System.out.println(db1 == db2); // true

        // Abstract Factory
        System.out.println("\n=== Abstract Factory ===");
        Application app = new Application(new WindowsFactory());
        app.render();

        // Factory Method
        System.out.println("\n=== Factory Method ===");
        Logistics logistics = new RoadLogistics();
        logistics.planDelivery();

        // Builder
        System.out.println("\n=== Builder ===");
        User_Builder user = new User_Builder.Builder()
                .firstName("John")
                .lastName("Doe")
                .age(30)
                .email("john@example.com")
                .phone("+123456789")
                .build();
        System.out.println(user);

        // Prototype
        System.out.println("\n=== Prototype ===");
        Smartphone_Prototype baseClone = PrototypeRegistry.getClone("base");
        Smartphone_Prototype premiumClone = PrototypeRegistry.getClone("premium");
        premiumClone.setModel("CustomModel");
        System.out.println(baseClone);
        System.out.println(premiumClone);

        // Proxy
        System.out.println("\n=== Proxy ===");
        Image image1 = new ProxyImage("photo.jpg");
        image1.display();
        image1.display();

        Image image2 = new SecurityProxy("secret.jpg", false);
        image2.display();
    }
}
