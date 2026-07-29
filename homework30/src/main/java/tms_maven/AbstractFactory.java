package tms_maven;

interface Button {
    void render();
}

interface Checkbox {
    void render();
}

class WindowsButton implements Button {
    @Override
    public void render() {
    }
}

class MacButton implements Button {
    @Override
    public void render() {
    }
}

class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
    }
}

class MacCheckbox implements Checkbox {
    @Override
    public void render() {
    }
}

interface GUIFactory {
    Button createButton();

    Checkbox createCheckbox();
}

class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void render() {
        button.render();
        checkbox.render();
    }
}

