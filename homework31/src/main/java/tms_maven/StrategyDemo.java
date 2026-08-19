package tms_maven;

interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    public CreditCardPayment() {}

    @Override
    public void pay(int amount) {
        System.out.println("Оплата " +  amount + " кредитной картой");
    }
}

class PayPalPayment implements PaymentStrategy {
    public PayPalPayment() {}

    @Override
    public void pay(int amount) {
        System.out.println("Оплата " +  amount + " через PayPal");
    }
}

class CashPayment implements PaymentStrategy {
    public CashPayment() {}

    @Override
    public void pay(int amount) {
        System.out.println("Оплата " +  amount + " наличными");
    }
}

class ShoppingCart {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void checkout(int amount) {
        if (strategy == null)
            throw new IllegalStateException("Способ оплаты не выбран");

        strategy.pay(amount);
    }
}

public class StrategyDemo {
    public static void main() {
        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout(1000);

        cart.setPaymentStrategy(new CashPayment());
        cart.checkout(500);
    }
}
