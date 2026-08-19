package tms_maven;

import java.util.HashMap;
import java.util.Map;

public class Smartphone_Prototype implements Cloneable {
    private String model;
    private String os;
    private int storage;

    public Smartphone_Prototype (String model, String os, int storage) {
        this.model = model;
        this.os = os;
        this.storage = storage;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return String.format("Smartphone{model = %s, os = %s, storage = %d}", model, os, storage);
    }
}

class PrototypeRegistry {
    private static final Map<String, Smartphone_Prototype> prototypes = new HashMap<>();

    static {
        prototypes.put("base", new Smartphone_Prototype("BaseModel", "Android", 64));
        prototypes.put("premium", new Smartphone_Prototype("PremiumModel", "Android",  256));
    }

    public static Smartphone_Prototype getClone(String key) {
        return (Smartphone_Prototype) prototypes.get(key).clone();
    }
}
