package customer;

import java.time.LocalDate;


public class CustomerInfo {
    private String personalIdentityNumber;
    private String name;
    private LocalDate lastPayment;

    public CustomerInfo(String personalIdentityNumber, String name, LocalDate lastPayment) {
        this.personalIdentityNumber = personalIdentityNumber;
        this.name = name;
        this.lastPayment = lastPayment;
    }

    public String getPersonalIdentityNumber() {
        return personalIdentityNumber;
    }

    public String getName() {
        return name;
    }

    public LocalDate getLastPayment() {
        return lastPayment;
    }
}
