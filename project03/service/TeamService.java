package project03.service;

import project03.domain.Architect;
import project03.domain.Designer;
import project03.domain.Employee;
import project03.domain.Programmer;

/**
 *
 * @Description add/remove team member
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate 6/13/2021 9:14:52 PM
 *
 */
public class TeamService {
    private static int counter = 1;
    private final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total = 0;
    private int programmers = 0;
    private int designers = 0;
    private int architects = 0;

    public int getTotal() {
        return total;
    }

    public Programmer[] getTeam() {
        Programmer[] temp = new Programmer[total];
        for (int i = 0; i < total; i++) {
            temp[i] = team[i];
        }
        return temp;
    }

    public void addMember(Employee e) throws TeamException {
        if (total == MAX_MEMBER)
            throw new TeamException("The team is full.");
        if (e instanceof Programmer) {
            if (((Programmer) e).getStatus() == Status.BUSY) {
                for (int i = 0; i < total; i++) {
                    if (e == team[i])
                        throw new TeamException("This emplyee is already in the team.");
                }
                throw new TeamException("This emplyee is already in another team.");
            }
            if (((Programmer) e).getStatus() == Status.VOCATION)
                throw new TeamException("This emplyee is on vocation now.");
            if (e instanceof Architect) {
                if (architects == 1)
                    throw new TeamException("At most 1 architect allows in the team");
                else {
                    team[total] = (Architect) e;
                    architects++;
                }
            } else if (e instanceof Designer) {
                if (designers == 2)
                    throw new TeamException("At most 2 designers allows in the team");
                else {
                    team[total] = (Designer) e;
                    designers++;
                }
            } else {
                if (programmers == 3)
                    throw new TeamException("At most 3 programmers allows in the team");
                else {
                    team[total] = (Programmer) e;
                    programmers++;
                }
            }
            team[total].setStatus(Status.BUSY);
            team[total++].setMemberId(counter++);
        } else
            throw new TeamException("This employee is not a programmer.");
    }

    public void removeMember(int memberId) throws TeamException {
        if (total == 0)
            throw new TeamException("The team is empty.");
        for (int i = 0; i < total; i++) {
            if (memberId == team[i].getMemberId()) {
                team[i].setStatus(Status.FREE);
                if (team[i] instanceof Architect)
                    architects--;
                else if (team[i] instanceof Designer)
                    designers--;
                else
                    programmers--;
                for (int j = i + 1; j < total; j++) {
                    team[j - 1] = team[j];
                }
                team[total--] = null;
                return;
            }
        }
        throw new TeamException("Can't find the emplyee with this memberId in the team.");
    }

}
