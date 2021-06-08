package acb;

import org.junit.Test;

/**
 *
 * @Description
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate 6/3/2021 3:45:12 PM
 *
 */
public class BankTest {
    // public static void main(String[] args) {
    @Test
    public void testBank() {
        Bank bank = new Bank();
        bank.addCustomer("Serena", "Zhang");
        bank.getCustomers(0).setAccount(new Account(2000));
        bank.getCustomers(0).getAccount().withdraw(500);
        System.out.println("Customer: " + bank.getCustomers(0).getFirstName() + "\tBalance: "
                + bank.getCustomers(0).getAccount().getBalance());
        System.out.println("Number of customers:" + bank.getNumberOfCustomer());
    }
}
