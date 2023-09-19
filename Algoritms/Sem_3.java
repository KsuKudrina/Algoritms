package Algoritms;
class List{
    // Базовая структура односвязного списка
    Node head;
    

    class Node{
        int value;
        Node next;
    }

    public void push(int value){
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }

    public void pop(){
        if(head != null) {
            head = head.next;
        }
    }

    public Node find(int value){
        Node cur = head;
        while(cur != null){
            if(cur.value == value){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    public void print(){
        Node cur = head;
        while(cur != null){
            System.out.printf("%d ", cur.value);
            cur = cur.next;
        }
        System.out.println();
    }
}


class dList{
    Node head;
    Node tail;
    class Node{
        int value;
        Node next;
        Node prev;
    }

    public void push_front(int value){
        Node node = new Node();
        node.value = value;
        node.next = head;
        if(head == null) {
            tail = node;
        }else {
            head.prev = node;
        }
        head = node;
    }

    public void push_back(int value){
        Node node = new Node();
        node.value = value;

        node.prev = tail;
        if(tail == null) {
            head = node;
        }else {
            tail.next = node;
        }
        tail = node;
    }

    public void pop_front(){
        if(head != null) {
            head = head.next;
            if(head == null){
                tail = null;
            }else {
                head.prev = null;
            }
        }
    }

    public void pop_back(){
        if(tail != null) {
            tail = tail.prev;
            if(tail == null){
                head = null;
            }else {
                tail.next = null;
            }
        }
    }

    public Node find(int value){
        Node cur = head;
        while(cur != null){
            if(cur.value == value){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    public void print(){
        Node cur = head;
        while(cur != null){
            System.out.printf("%d ", cur.value);
            cur = cur.next;
        }
        System.out.println();
    }

    public void sort(){ // Bubble Sort
        boolean sorted = false;
        do {
            sorted = true;
            Node node = head;
            while (node != null && node.next != null) {
                if(node.value > node.next.value){
                    Node before = node.prev;
                    Node cur = node;
                    Node next = node.next;
                    Node after = next.next;

                    cur.next = after;
                    cur.prev = next;
                    next.next = cur;
                    next.prev = before;

                    if(before != null) {
                        before.next = next;
                    }else{
                        head = next;
                    }

                    if(after != null) {
                        after.prev = cur;
                    }else{
                        tail = cur;
                    }

                    sorted = false;
                }
                node = node.next;
            }
        }while(!sorted);
    }

}

public class Sem_3 {
    public static void main(String[] args) {

        // List list = new List();
        // for (int i = 0; i <= 5 ; i++) {
        //     list.push(i);  
        // }
        
        dList list = new dList();
        for(int i=0; i<10; i++){
            list.push_back((int)(Math.random() * 100));
        }

        list.print();
        // list.pop();
        list.pop_front();
        // list.sort();
        list.print();
        list.pop_back();
        list.print();
//
    //    System.out.println(list.find(3).value);
    //    System.out.println(list.find(5));
    }
    
}