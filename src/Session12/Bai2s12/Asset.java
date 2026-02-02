package Session12.Bai2s12;

import java.util.*;

abstract class Asset {
    protected String assetCode;
    protected String name;
    protected double purchasePrice;

    public Asset(String assetCode, String name, double purchasePrice) {
        this.assetCode = assetCode;
        this.name = name;
        this.purchasePrice = purchasePrice;
    }

    public abstract double getMarketValue();

    @Override
    public String toString() {
        return String.format("Mã: %s | Tên: %s | Giá gốc: %.2f", assetCode, name, purchasePrice);
    }
}

class Computer extends Asset {
    private int ram;
    private String cpu;

    public Computer(String assetCode, String name, double purchasePrice, int ram, String cpu) {
        super(assetCode, name, purchasePrice);
        this.ram = ram;
        this.cpu = cpu;
    }

    @Override
    public double getMarketValue() {
        return purchasePrice * 0.8; // Khấu hao 20%
    }
}

class NetworkDevice extends Asset {
    private int numberOfPorts;

    public NetworkDevice(String assetCode, String name, double purchasePrice, int numberOfPorts) {
        super(assetCode, name, purchasePrice);
        this.numberOfPorts = numberOfPorts;
    }

    @Override
    public double getMarketValue() {
        return purchasePrice * 0.9; // Khấu hao 10%
    }
}
