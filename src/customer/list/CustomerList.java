package customer.list;

import customer.CustomerInfo;


public interface CustomerList {
    public CustomerInfo findCustomerInfoWithNameOrPersonalIdentityNumber(String personalIdentityNumberOrName);
}
