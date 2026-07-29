package tms_maven;

interface Image {
    void display();
}

class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {}

    @Override
    public void display() {}
}

class ProxyImage implements Image {
    private RealImage image;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (image == null)
            image = new RealImage(filename);

        image.display();
    }
}

class SecurityProxy implements Image {
    private RealImage image;
    private String filename;
    private boolean isAdmin;

    public SecurityProxy(String filename, boolean isAdmin) {
        this.filename = filename;
        this.isAdmin = isAdmin;
    }

    @Override
    public void display() {
        if (!isAdmin) {
            return;
        }
        if (image == null)
            image = new RealImage(filename);

        image.display();
    }
}