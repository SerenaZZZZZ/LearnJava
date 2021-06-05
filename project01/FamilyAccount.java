package project01;
/**
 *
 * @Description This is a family account system. Users can track their incomes and expenditures
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version@date May 29, 2021 3:13:03 PM
 *
 */
public class FamilyAccount {
    public static void main(String[] args) {
        int balance = 10000;
        String details = "收支\t账户金额\t收支金额\t说明";
        outter: do {
            System.out.println("------------------家庭记账🧾------------------\n");
            System.out.println("                1 收支明细");
            System.out.println("                2 登记收入");
            System.out.println("                3 登记支出");
            System.out.println("                4 退   出\n");
            System.out.print("              请选择（1-4）：");

            char selection = Utility.readMenuSelection();
            switch (selection) {
                case '1':
                    System.out.println("\n---------------当前收支明细记录---------------");
                    System.out.println(details + "\n");
                    break;
                case '2':
                    int moneyIn = -1;
                    do {
                        System.out.print("本次收入金额：");
                        moneyIn = Utility.readNumber();
                        if (moneyIn < 0)
                            System.out.print("no负数\n");
                    } while (moneyIn < 0);
                    System.out.print("本次收入说明：");
                    String explainIn = Utility.readString();
                    System.out.println("------------------登记完成✅------------------\n");
                    balance += moneyIn;
                    details += "\n收入\t" + balance + "\t\t" + moneyIn + "\t\t" + explainIn;
                    break;
                case '3':
                    int moneyOut = -1;
                    do {
                        System.out.print("本次支出金额：");
                        moneyOut = Utility.readNumber();
                        if (moneyOut < 0)
                            System.out.print("no负数\n");
                    } while (moneyOut < 0);
                    balance -= moneyOut;
                    if (balance < 0)
                        System.out.println("提示：超出账户额度");
                    System.out.print("本次支出说明：");
                    String explainOut = Utility.readString();
                    System.out.println("------------------登记完成✅------------------\n");
                    details += "\n支出\t" + balance + "\t\t" + moneyOut + "\t\t" + explainOut;
                    break;
                case '4':
                    System.out.print("            确认是否退出（Y/N）：");
                    char yn = Utility.readConfirmSelection();
                    if (yn == 'Y')
                        break outter;
                    else
                        System.out.println();
            }
        } while (true);
    }
}
