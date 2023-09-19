package Algoritms;
public class Lesson {
    //  односвязные и двусвязные списки

    Node head; // Описывает начало списка
    Node tail; // последний элемент в списке

    // стек и очередь

    // public void push(int val){
    //     Node node = new Node();
    //     node.val = val;
    //     node.next = head;
    //     head = node;
    // }
    // public Integer pop(){
    //     Integer result = null;
    //     if (head != null){
    //         result = head.val;
    //         head = head.next;
    //     }
    //     return result;
    // }

    public void push(int val){
        Node node = new Node();
        node.val = val;
        node.next = head;
        head.previous = node;
        head = node;
    }

    public Integer peek(){
        Integer result = null;
        if (tail != null){
            result = tail.val;
            tail.previous.next = null;
            tail = tail.previous;
        }
        return result;
    }
    // // метод для поиска нода в списке
    // public Node find(int val){
    //     Node currentNode = head;
    //     while (currentNode != null){
    //         if(currentNode.val == val){
    //             return currentNode;
    //         }
    //         currentNode = currentNode.next;
    //     }
    //     return null;
    // }

    // // метод вставки в конец связного списка
    // public void add(int val){
    //     Node node = new Node();
    //     node.val = val;
    //     if(head == null){
    //         head = node;
    //         tail = node;
    //     }else {
    //         tail.next = node;
    //         node.previous = tail;
    //         tail = node;
    //     }
    // }

    // // метод вставки в середину связного списка
    // public void add(int val, Node node){
    //     Node next = node.next;
    //     Node newNode = new Node();
    //     newNode.val = val;
    //     node.next = newNode;
    //     newNode.previous = node;
    //     if (next == null){
    //         tail = newNode;
    //     } else {
    //         next.previous = newNode;
    //         newNode.next = next;
    //     }
    // }

    // // метод удаления из связного списка
    // public void delete(Node node){
    //     Node previous = node.previous;
    //     Node next = node.next;
    //     if (previous == null){
    //         next.previous = null;
    //         head = next;
    //     } else {
    //         if (next == null){
    //             previous.next = null;
    //             tail = previous;
    //         } else {
    //             previous.next = next;
    //             next.previous = previous;
    //         }
    //     }
        
    // }

    // // метод разворота связного списка
    // public void revert(){
    //     Node curreentNode = head;
    //     while (curreentNode != null) {
    //         Node next = curreentNode.next;
    //         Node previous = curreentNode.previous;
    //         curreentNode.next = previous;
    //         curreentNode.previous = next;
    //         if(previous == null){
    //             tail = curreentNode;
    //         }
    //         if(next == null){
    //             head = curreentNode;
    //         }
    //         curreentNode = next;

    //     }
    // }

    public void revert(){
        if (head != null && head.next != null){
            revert(head.next, head);
        }
    }
    private void revert (Node curreentNode, Node previousNode){
        if (curreentNode.next == null){
            head = curreentNode;
        } else {
            revert(curreentNode.next, curreentNode);
        }
        curreentNode.next = previousNode;
        previousNode.next = null;
    }

    public class Node {
        int val; // значение
        Node next; // ссылка на следующий нод

        Node previous; // ссылка на предыдущий нод
    }

    

    
}
