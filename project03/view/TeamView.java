package project03.view;

import project03.domain.Architect;
import project03.domain.Designer;
import project03.domain.Employee;
import project03.domain.Programmer;
import project03.service.NameListService;
import project03.service.TeamException;
import project03.service.TeamService;

/**
 *
 * @Description
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate 6/13/2021 9:56:14 PM
 *
 */
public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    public static void main(String[] args) {
        TeamView view = new TeamView();
        view.enterMainMenu();
    }

    public void enterMainMenu() {
        char menu = 0;
        do {
            if (menu != '1')// 新增 若看了团队列表就直接显示菜单栏
                listAllEmployees();
            System.out.println(
                    "-----------------------------------------------------------------------------------------");
            System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员  4-退出  请选择(1-4): ");
            switch (menu = TSUtility.readMenuSelection()) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.print("            确认是否退出（Y/N）：");
                    char yn = TSUtility.readConfirmSelection();
                    if (yn == 'Y')
                        return;
                    else
                        System.out.println();
            }
        } while (true);
    }

    private void listAllEmployees() {
        System.out.println("------------------------------------开发团队调度软件-------------------------------------\n");
        System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
        Employee[] employees = listSvc.getAllEmployees();
        if (employees == null || employees.length == 0) // 新增判断 严谨
            System.out.println("公司无员工");
        else {
            for (int i = 0; i < employees.length; i++) {
                System.out.println(employees[i].toString());
            }
        }
    }

    private void getTeam() {
        System.out.println("\n--------------------团队成员列表---------------------");
        System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
        Programmer[] team = teamSvc.getTeam();
        if (teamSvc.getTotal() == 0) {
            System.out.println("The team is empty.");
        } else {
            for (int i = 0; i < teamSvc.getTotal(); i++) {
                System.out.print(team[i].getMemberId() + "/" + team[i].getId() + "\t" + team[i].getName() + "\t"
                        + team[i].getAge() + "\t" + team[i].getSalary() + "\t" + team[i].getPosition());
                if (team[i] instanceof Designer)
                    System.out.print("\t" + ((Designer) team[i]).getBonus());
                if (team[i] instanceof Architect)
                    System.out.print("\t" + ((Architect) team[i]).getStock());
                System.out.println();
            }
        }
        System.out.println("-----------------------------------------------------\n");
        TSUtility.readReturn();
    }

    private void addMember() {
        System.out.println("---------------------添加成员---------------------");
        System.out.print("请输入要添加的员工ID: ");
        int id = TSUtility.readInt();
        try {
            Employee e = listSvc.getEmployee(id);
            teamSvc.addMember(e);
            System.out.println("添加成功");
            // TSUtility.readReturn();
        } catch (TeamException e) {
            System.out.println("添加失败，原因：" + e.getMessage());
        }
        TSUtility.readReturn();
    }

    private void deleteMember() {
        System.out.println("---------------------删除成员---------------------");
        System.out.print("请输入要删除的员工TID: ");
        int memberId = TSUtility.readInt();
        System.out.print("确认是否删除（Y/N）：");
        char yn = TSUtility.readConfirmSelection();
        if (yn == 'N')
            return;
        try {
            teamSvc.removeMember(memberId);
            System.out.println("删除成功");
        } catch (TeamException e) {
            System.out.println("删除失败，原因：" + e.getMessage());
        }
        TSUtility.readReturn();
    }
}
