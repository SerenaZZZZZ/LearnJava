package linkedlist;

import java.util.Stack;

/**
 * @author xiangxiang
 * @create 07/09/2021 14:18
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.addToTail(new HeroNode(1, "宋江", "及时雨"));
        list.addToTail(new HeroNode(2, "B", "bb"));
        list.addToTail(new HeroNode(4, "C", "cc"));
        list.addToTail(new HeroNode(5, "D", "dd"));
        list.addByNo(new HeroNode(3, "E", "ee"));
        list.addByNo(new HeroNode(6, "F", "ff"));
        list.addByNo(new HeroNode(0, "G", "gg"));
        list.addByNo(new HeroNode(5, "G", "gg"));
        list.update(new HeroNode(5, "G", "gg"));
        list.update(new HeroNode(8, "H", "hh"));
        list.delete(0);
        list.delete(3);
        list.delete(6);
        list.showList(list.head);

        HeroNode reverseList = list.reverseList(list.head);
        list.showList(reverseList);

        list.showList(list.reverseListWithStack(reverseList));
    }
}

class SingleLinkedList {
    HeroNode head = new HeroNode(0, "", "");

    public void addToTail(HeroNode newNode) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void addByNo(HeroNode newNode) {
        HeroNode temp = head;
        while (temp.next != null) {
            if (temp.next.no < newNode.no)
                temp = temp.next;
            else if (temp.next.no == newNode.no) {
                System.out.println("A node with NO." + newNode.no + " exists. Can't insert");
                return;
            } else
                break;
        }
        HeroNode tempNext = temp.next;
        temp.next = newNode;
        newNode.next = tempNext;
    }

    public void update(HeroNode newNode) {
        HeroNode temp = head;
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
        HeroNode prev = head;
        while (prev.next != null) {
            HeroNode temp = prev.next;
            if (temp.no == no) {
                prev.next = temp.next;
                temp.next = null;
                return;
            }
            prev = temp;
        }
        System.out.println("No node with No." + no + ". Can't delete");
    }

    public void showList(HeroNode head) {
        HeroNode temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public HeroNode reverseList(HeroNode head){
        if (head.next == null || head.next.next == null)
            return head;
        HeroNode reversedHead = new HeroNode(0,"","");
        HeroNode temp1 = head.next;
        while (temp1!= null) {
            HeroNode tempNext = temp1.next;
            HeroNode temp2 = reversedHead.next;
            reversedHead.next = temp1;
            temp1.next = temp2;
            temp1 = tempNext;
        }
        return reversedHead;
    }

    public HeroNode reverseListWithStack(HeroNode head){
        if (head.next == null || head.next.next == null)
            return head;
        Stack<HeroNode> stack = new Stack<>();
        HeroNode temp = head.next;
        while (temp!= null){
            HeroNode tempNext = temp.next;
            temp.next = null;
            stack.push(temp);
            temp = tempNext;
        }
        temp = head;
        while (!stack.isEmpty()){
            temp.next = stack.pop();
            temp = temp.next;
        }
        return head;
    }
}

class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "linkedlist.HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}