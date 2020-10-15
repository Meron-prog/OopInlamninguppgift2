package customer.list;

import customer.CustomerInfo;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerFileList implements CustomerList {

    protected List<CustomerInfo> customers;

    public CustomerFileList(String customersFile) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(customersFile))){
            customers = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] lineParts = line.split(",");
                String line2;
                if((line2 = bufferedReader.readLine()) != null) {
                    if (!line.isEmpty() && !line2.isEmpty()) {
                        customers.add(new CustomerInfo(lineParts[0], lineParts[1].trim(), LocalDate.parse(line2)));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("File not Found.");
            System.exit(0);
        }
    }

    @Override
    public CustomerInfo findCustomerInfoWithNameOrPersonalIdentityNumber(String personalIdentityNumberOrName) {
        for (CustomerInfo customerInfo : customers) {
            if (customerInfo.getName().equals(personalIdentityNumberOrName) || customerInfo.getPersonalIdentityNumber().equals(personalIdentityNumberOrName))
                return customerInfo;
        }
        return null;
    }

}
