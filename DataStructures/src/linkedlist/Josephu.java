package linkedlist;

/**
 * @author xiangxiang
 * @create 07/09/2021 23:18
 */
public class Josephu {
    public static void main(String[] args) {
        int n = 5;//k children
        int m = 2;//per m child go out the circle
        CircleSingleLinkedList childList = new CircleSingleLinkedList();
        childList.addNChild(n);
        childList.showList();

        int count = 1;
        Child prev = childList.getLast();
        Child cur = childList.getFirst();
        while (cur!=prev) {
            if (count % m == 0) {
                System.out.println(cur.getId());
                prev.setNext(cur.getNext());
                cur = prev.getNext();
            }else{
                cur = cur.getNext();
                prev = prev.getNext();
            }
            count++;
        }
        System.out.println(cur.getId());
    }
}

class CircleSingleLinkedList {
    private Child first = null;
    private Child last = null;

    public Child getFirst() {
        return first;
    }

    public Child getLast() {
        return last;
    }

    public void addNChild(int nums) {
        if (nums < 1) {
            System.out.println("Invalid id.");
            return;
        }
        first = new Child(1);
        Child temp = first;
        for (int i = 2; i <= nums; i++) {
            temp.setNext(new Child(i));
            temp = temp.getNext();
        }
        temp.setNext(first);
        last = temp;
    }

    public void showList() {
        if (isEmpty()) {
            System.out.println("Empty list. No child.");
            return;
        }
        Child temp = first;
        while (temp.getNext() != first) {
            System.out.println(temp);
            temp = temp.getNext();
        }
        System.out.println(temp);
    }

    public boolean isEmpty() {
        return first == null;
    }

}

class Child {
    private int id;
    private Child next;

    public Child(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Child getNext() {
        return next;
    }

    public void setNext(Child next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                '}';
    }
}
