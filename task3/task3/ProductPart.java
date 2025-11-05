public class ProductPart implements IProductPart {
    private final String name;

    public ProductPart(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
