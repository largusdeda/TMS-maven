package tms_maven;

interface EuropeanSocket {
    void plugIn();
}

class AmericanPlug {
    public AmericanPlug() {}

    void insertIntoFlatSocket() {
        System.out.println("Подключено через плоские контакты");
    }
}

class PlugAdapter implements EuropeanSocket {
    private AmericanPlug americanPlug;

    public PlugAdapter(AmericanPlug americanPlug) {
        this.americanPlug = americanPlug;
    }

    @Override
    public void plugIn() {
        System.out.println("Адаптер");
        americanPlug.insertIntoFlatSocket();
        System.out.println("Круглые контакты преобразованы в плоские");
    }
}

public class AdapterDemo {
    public static void main() {
        AmericanPlug macbook = new AmericanPlug();
        EuropeanSocket adapter = new PlugAdapter(macbook);

        adapter.plugIn();
    }
}