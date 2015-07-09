package additionalTask11.entity;

public abstract class Plant {
    private String name;
    private double height;

    public abstract void grow();

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
