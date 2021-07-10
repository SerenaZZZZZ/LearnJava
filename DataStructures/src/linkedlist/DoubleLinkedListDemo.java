package linkedlist;

import java.util.Stack;

/**
 * @author xiangxiang
 * @create 07/09/2021 22:38
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.addToTail(new HeroNode2(1, "宋江", "及时雨"));
        list.addToTail(new HeroNode2(2, "B", "bb"));
        list.addToTail(new HeroNode2(4, "C", "cc"));
        list.addToTail(new HeroNode2(5, "D", "dd"));
        list.addByNo(new HeroNode2(3, "E", "ee"));
        list.addByNo(new HeroNode2(6, "F", "ff"));
        list.addByNo(new HeroNode2(0, "G", "gg"));
        list.addByNo(new HeroNode2(5, "G", "gg"));
        list.update(new HeroNode2(5, "G", "gg"));
        list.update(new HeroNode2(8, "H", "hh"));
        list.delete(0);
        list.delete(3);
        list.delete(6);
        list.showList(list.head);
    }
}

class DoubleLinkedList {
    HeroNode2 head = new HeroNode2(0, "", "");

    public void addToTail(HeroNode2 newNode) {
        HeroNode2 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.pre = temp;
    }

    public void addByNo(HeroNode2 newNode) {
        HeroNode2 temp = head;
        while (temp.next != null) {
            if (temp.next.no < newNode.no)
                temp = temp.next;
            else if (temp.next.no == newNode.no) {
                System.out.println("A node with NO." + newNode.no + " exists. Can't insert");
                return;
            } else
                break;
        }
        HeroNode2 tempNext = temp.next;
        temp.next = newNode;
        newNode.pre = temp;
        newNode.next = tempNext;
        if (tempNext != null)
            tempNext.pre = newNode;
    }

    public void update(HeroNode2 newNode) {
        HeroNode2 temp = head;
        while (temp.next != null) {
            temp = temp.next;
            if (temp.no == newNode.no) {
                temp.name = newNode.name;
                temp.nickname = newNode.nickname;
                return;
            }
        }
        System.out.println("No node with No." + newNode.no + ". Can't update");
    }

    public void delete(int no) {
        HeroNode2 temp = head.next;
        while (temp != null) {
            if (temp.no == no) {
                temp.pre.next = temp.next;
                if (temp.next != null)
                    temp.next.pre = temp.pre;//only run this when temp is not the last node
                return;
            }
            temp = temp.next;
        }
        System.out.println("No node with No." + no + ". Can't delete");
    }

    public void showList(HeroNode2 head) {
        HeroNode2 temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public HeroNode reverseList(HeroNode head) {
        if (head.next == null || head.next.next == null)
            return head;
        HeroNode reversedHead = new HeroNode(0, "", "");
        HeroNode temp1 = head.next;
        while (temp1 != null) {
            HeroNode tempNext = temp1.next;
            HeroNode temp2 = reversedHead.next;
            reversedHead.next = temp1;
            temp1.next = temp2;
            temp1 = tempNext;
        }
        return reversedHead;
    }

    public HeroNode reverseListWithStack(HeroNode head) {
        if (head.next == null || head.next.next == null)
            return head;
        Stack<HeroNode> stack = new Stack<>();
        HeroNode temp = head.next;
        while (temp != null) {
            HeroNode tempNext = temp.next;
            temp.next = null;
            stack.push(temp);
            temp = tempNext;
        }
        temp = head;
        while (!stack.isEmpty()) {
            temp.next = stack.pop();
            temp = temp.next;
        }
        return head;
    }
}

class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "linkedlist.HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}