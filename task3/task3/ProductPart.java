package task3;

public class ProductPart implements IProductPart {
    private String name;

    public ProductPart(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}