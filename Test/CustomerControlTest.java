import customer.CustomerInfo;
import customer.CustomerStatus;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.assertTrue;


public class CustomerControlTest {

    @Test
    public void CheckCustomerStatusTest(){
        CustomerInfo customerInfoPreviousCustomer = new CustomerInfo("585858", "Meron", LocalDate.now().minusMonths(13));
        CustomerInfo customerInfoCurrentCustomer = new CustomerInfo("2343", "Michael", LocalDate.now().minusMonths(11));

        assertTrue(CustomerControl.checkCustomerStatus(customerInfoPreviousCustomer) == CustomerStatus.PREVIOUSCUSTOMER);

        assertTrue(CustomerControl.checkCustomerStatus(customerInfoCurrentCustomer) == CustomerStatus.CURRENTCUSTOMER);

        assertTrue(CustomerControl.checkCustomerStatus(null) == CustomerStatus.UNAUTHORIZED);
    }


}
