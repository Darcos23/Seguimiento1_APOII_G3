package model;

public class Billboard {

    private double width;
    private double height;
    private boolean inUse;
    private String brand;

    public Billboard (double width, double height, boolean inUse, String brand) {
        this.width = width;
        this.height = height;
        this.inUse = inUse;
        this.brand = brand;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public boolean getInUse() {
        return inUse;
    }

    public String getBrand() {
        return brand;
    }

    public double calculateArea() {
        double area = this.width * this.height;
        return area;
    }
}