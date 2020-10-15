import customer.CustomerInfo;
import customer.CustomerStatus;
import customer.list.CustomerFileList;
import customer.list.CustomerList;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.Scanner;

public class CustomerControl {

    public static final String CUSTOMERS_FILE = "src/Customers.txt";

    public static void main(String[] args) {
        CustomerList customerList = new CustomerFileList(CUSTOMERS_FILE);
        String personalIdentityNumberOrName = askUserPersonalIdentityNumberOrName();
        CustomerInfo customerFromList = customerList.findCustomerInfoWithNameOrPersonalIdentityNumber(personalIdentityNumberOrName);
        CustomerStatus customerStatus = checkCustomerStatus(customerFromList);
        showUserCustomerStatus(customerFromList, customerStatus);
        if (customerStatus == CustomerStatus.CURRENTCUSTOMER)
            saveCustomerTrainingSession(customerFromList);
    }

    private static String askUserPersonalIdentityNumberOrName() {
        Scanner sc= new Scanner(System.in);
        System.out.println("Ange din personnummer eller namn");
        String input = sc.nextLine();
        sc.close();
        return input;
    }

    protected static CustomerStatus checkCustomerStatus(CustomerInfo customerInfo) {
        if (customerInfo == null)
            return CustomerStatus.UNAUTHORIZED;
        else if (customerInfo.getLastPayment().isBefore(LocalDate.now().minusYears(1)))
            return CustomerStatus.PREVIOUSCUSTOMER;
        else
            return CustomerStatus.CURRENTCUSTOMER;
    }

    private static void showUserCustomerStatus(CustomerInfo customer, CustomerStatus customerStatus) {
        System.out.println("Du är " + customerStatus.getSwedishText().toLowerCase());
    }

    private static void saveCustomerTrainingSession(CustomerInfo customer) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of("src/träningslista.txt"), StandardOpenOption.APPEND)){

            bufferedWriter.write(customer.getName() + ", " + customer.getPersonalIdentityNumber() + ", " + LocalDate.now());
            bufferedWriter.newLine();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("File not Found. Try again");
        }
    }
}
