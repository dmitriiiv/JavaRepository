package additionalTask11.entity;

public class Tree extends Plant {
    private String type;

    @Override
    public String toString() {
        return type +
                " дерево: " +
                super.getName() +
                ". Высотой " +
                super.getHeight() +
                " м.";
    }

    @Override
    public void grow() {
        double height = getHeight();
        setHeight(height + 0.5);
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
