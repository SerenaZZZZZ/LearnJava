package project02;

/**
 *
 * @Description Main model, serve for menu view and manipulate the users'
 *              operation.
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate 6/5/2021 7:16:33 AM
 *
 */
public class CustomerView {
    CustomerList customerList = new CustomerList(3);

    public static void main(String[] args) {
        CustomerView view = new CustomerView();
        view.enterMainMenu();
    }

    public void enterMainMenu() {
        do {
            System.out.println("-----------------客户信息管理💻-----------------\n");
            System.out.println("                1 添加客户");
            System.out.println("                2 修改客户");
            System.out.println("                3 删除客户");
            System.out.println("                4 客户列表");
            System.out.println("                5 退   出\n");
            System.out.print("              请选择（1-5）：");
            char select = CMUtility.readMenuSelection();
            switch (select) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.print("            确认是否退出（Y/N）：");
                    char yn = CMUtility.readConfirmSelection();
                    if (yn == 'Y')
                        return;
                    else
                        System.out.println();
            }
        } while (true);
    }

    private void addNewCustomer() {
        Customer cust = new Customer();
        // 老师的优化：也有添加失败的情况
        System.out.println("\n--------------------添加客户-------------------");
        if (!customerList.addCustomer(cust)) {
            System.out.println("Customer list is full. Please delete first");
            System.out.println("-------------------添加失败❎-------------------\n");
            return;
        }
        System.out.print("姓名：");
        cust.setName(CMUtility.readString(50));
        System.out.print("性别(F/M)：");
        cust.setGender(CMUtility.readChar('F'));
        System.out.print("年龄：");
        cust.setAge(CMUtility.readInt(0));
        System.out.print("电话：");
        cust.setPhone(CMUtility.readString(13));
        System.out.print("邮箱：");
        cust.setEmail(CMUtility.readString(40));
        System.out.println("-------------------添加完成✅-------------------\n");

    }

    private void modifyCustomer() {
        int total = customerList.getTotal();
        if (total < 1) {
            System.out.println("No customer. Please add customer first\n");
            return;
        }
        System.out.println("\n--------------------修改客户-------------------");
        System.out.print("       请选择待修改客户编号（1-" + total + "）(-1退出)：");
        int index = enterIndex(total);
        if (index == -1) {
            System.out.println();
            return;
        }
        Customer cust = customerList.getCustomer(index);
        System.out.print("姓名（" + cust.getName() + "）：");
        cust.setName(CMUtility.readString(50, cust.getName()));
        System.out.print("性别（" + cust.getGender() + "）：");
        cust.setGender(CMUtility.readChar(cust.getGender()));
        System.out.print("年龄（" + cust.getAge() + "）：");
        cust.setAge(CMUtility.readInt(cust.getAge()));
        System.out.print("电话（" + cust.getPhone() + "）：");
        cust.setPhone(CMUtility.readString(11, cust.getPhone()));
        System.out.print("邮箱（" + cust.getEmail() + "）：");
        cust.setEmail(CMUtility.readString(40, cust.getEmail()));
        System.out.println("-------------------修改完成✅-------------------\n");
    }

    private void deleteCustomer() {
        int total = customerList.getTotal();
        if (total < 1) {
            System.out.println("No customer. Please add customer first\n");
            return;
        }
        do {
            System.out.println("\n--------------------删除客户-------------------");
            System.out.print("       请选择待删除客户编号（1-" + total + "）(-1退出)：");
            int index = enterIndex(total);
            if (index == -1)
                return;
            System.out.print("        确认是否删除<" + (index + 1) + "号>（Y/N）：");
            char yn = CMUtility.readConfirmSelection();
            if (yn == 'Y') {
                customerList.deleteCustomer(index);
                System.out.println("------------------删除完成✅-------------------\n");
                return;
            }
        } while (true);
    }

    private void listAllCustomers() {
        Customer[] customers = customerList.getAllCustomers();
        int total = customerList.getTotal();
        System.out.println("--------------------客户列表-------------------");
        if (total < 1) {
            System.out.println("No customer. Please add customer first.\n");
            return;
        }
        System.out.println("编号\t姓名\t性别\t年龄\t电话\t邮箱");
        for (int i = 0; i < total; i++) {
            System.out.println((i + 1) + "\t" + customers[i].getName() + "\t" + customers[i].getGender() + "\t"
                    + customers[i].getAge() + "\t" + customers[i].getPhone() + "\t" + customers[i].getEmail());
        }
        System.out.println("-----------------客户列表完成✅-----------------\n");
    }

    private int enterIndex(int total) {
        int index;
        for (;;) {
            index = CMUtility.readInt();
            if (index == -1)
                return index;
            else if (index <= 0 || index > total) {
                System.out.print("Wrong index, please re-enter: ");
            } else
                break;
        }
        index--;
        return index;
    }
}
