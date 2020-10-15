package customer.list;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFileListTest {

    @Test
    public void readCustomerInfoFromFile(){
        CustomerFileList customerFileList = new CustomerFileList("Test/testcustomers.txt");
        assertTrue(customerFileList.customers.size()==2);
        assertTrue(customerFileList.customers.get(0).getName().equals("Alhambra Aromes"));
        assertTrue(customerFileList.customers.get(1).getPersonalIdentityNumber().equals("8104021234"));
        assertTrue(customerFileList.customers.get(1).getLastPayment().equals(LocalDate.parse("2018-12-02")));
    }

    @Test
    public void findCustomerInfoWithNameOrPersonalIdentityNumber(){
        CustomerFileList customerFileList = new CustomerFileList("Test/testcustomers.txt");

        assertTrue(customerFileList.findCustomerInfoWithNameOrPersonalIdentityNumber("7603021234").getName().equals("Alhambra Aromes"));
        assertTrue(customerFileList.findCustomerInfoWithNameOrPersonalIdentityNumber("Bear Belle").getPersonalIdentityNumber().equals("8104021234"));
        assertTrue(customerFileList.findCustomerInfoWithNameOrPersonalIdentityNumber("NotInList") == null);
    }
}