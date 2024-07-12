package entity;

public class CellPhone extends Phone {
    private String portableCountry;
    private String status;


    public CellPhone(int id, String phoneName, double price, int quantity, String producer, String portableCountry, String status) {
        super(id, phoneName, price, quantity, producer);
        this.portableCountry = portableCountry;
        this.status = status;
    }

    public String getPortableCountry() {
        return portableCountry;
    }

    public void setPortableCountry(String portableCountry) {
        this.portableCountry = portableCountry;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CellPhone{" +
                "portableCountry='" + portableCountry + '\'' +
                ", status='" + status + '\'' +
                "} " + super.toString();
    }
}
