package acb;

/**
 *
 * @Description
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate 6/3/2021 3:39:45 PM
 *
 */
public class Bank {
    private Customer[] customers;
    private int numberOfCustomer = 0;

    public Bank(){
        customers = new Customer[10];
    }

    public void addCustomer(String f, String l) {
        Customer customer = new Customer(f, l);
        customers[numberOfCustomer++] = customer;
    }

    public int getNumberOfCustomer() {
        return numberOfCustomer;
    }

    public Customer getCustomers(int index) {
        if (index < 0 || index >= numberOfCustomer) {
            System.out.println("wrong index");
            return null;
        }
        return customers[index];
    }
}
