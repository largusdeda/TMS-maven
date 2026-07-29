package tms_maven;

interface Transport {
    void deliver();
}

class Truck implements Transport {
    @Override
    public void deliver() {}
}

class Ship implements Transport {
    @Override
    public void deliver() {}
}

abstract class Logistics {
    public abstract Transport createTransport();
    public void planDelivery() {
        Transport transport = createTransport();
        transport.deliver();
    }
}

class RoadLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}

class SeaLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}