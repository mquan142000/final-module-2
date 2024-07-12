package entity;

public class GenuinePhone extends Phone {
    private String warrantyPeriod;
    private String warrantyScope;

    public GenuinePhone(int id, String phoneName, double price, int quantity, String producer, String warrantyPeriod, String warrantyScope) {
        super(id, phoneName, price, quantity, producer);
        this.warrantyPeriod = warrantyPeriod;
        this.warrantyScope = warrantyScope;
    }

    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(String warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getWarrantyScope() {
        return warrantyScope;
    }

    public void setWarrantyScope(String warrantyScope) {
        this.warrantyScope = warrantyScope;
    }

    @Override
    public String toString() {
        return "GenuinePhone{" +
                "warrantyPeriod='" + warrantyPeriod + '\'' +
                ", warrantyScope='" + warrantyScope + '\'' +
                "} " + super.toString();
    }
}
