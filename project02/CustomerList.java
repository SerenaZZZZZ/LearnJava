package project02;

/**
 *
 * @Description Manage Customer objects, CRUD
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate 6/5/2021 7:18:27 AM
 *
 */
public class CustomerList {
    private Customer[] customers;
    private int total = 0;// number of customers

    public CustomerList() {
    }

    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];
    }

    public boolean addCustomer(Customer customer) {
        if (customers.length <= total)
            return false;
        customers[total++] = customer;
        return true;
    }

    public boolean replaceCustomer(int index, Customer cust) {
        if (index < 0 || index >= total)
            return false;
        customers[index] = cust;
        return true;
    }

    public boolean deleteCustomer(int index) {
        if (index < 0 || index >= total)
            return false;
        total--;
        for (int i = index + 1; i <= total; i++) {
            replaceCustomer(i - 1, customers[i]);
        }
        //老师的优化：最后一个要置空
        customers[total] = null;
        return true;
    }

    public Customer[] getAllCustomers() {
        //return customers;
        //老师的优化：后面有空的所以可以新建一个数组
        Customer[] custs = new Customer[total];
        for (int i = 0; i < total; i++) {
            custs[i] = customers[i];
        }
        return custs;
    }

    public Customer getCustomer(int index) {
        //老师的优化：
        if (index < 0 || index >= total){
            return null;
        }
        return customers[index];
    }

    public int getTotal() {
        return total;
    }
}
