package additionalTask11.entity;

public class Bush extends Plant {
    private int branchiness;

    @Override
    public String toString() {
        return "Кустарник: " +
                super.getName() +
                ". Высотой " +
                super.getHeight() +
                " м. и ветвистостью " +
                branchiness +
                ".";
    }

    @Override
    public void grow() {
        double height = getHeight();
        setHeight(height + 0.25);
        branchiness++;
    }

    public int getBranchiness() {
        return branchiness;
    }

    public void setBranchiness(int branchiness) {
        this.branchiness = branchiness;

    }
}
