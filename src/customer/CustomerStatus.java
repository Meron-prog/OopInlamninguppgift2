package customer;

public enum CustomerStatus {
    PREVIOUSCUSTOMER("Föredetta kund"), CURRENTCUSTOMER("Nuvarande kund"), UNAUTHORIZED("Obehörig");

    private String swedishText;

    CustomerStatus(String swedishText) {
        this.swedishText = swedishText;
    }

    public String getSwedishText() {
        return swedishText;
    }
}



