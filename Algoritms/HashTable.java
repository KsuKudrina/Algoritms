package Algoritms;
class HasnMap{
    class Entity{
        int key;
        int value;
    }
    class Basket{

        Node head;

        class Node{
            Entity entity;
            Node next;
        }

        public boolean insert(Entity entity){
            Node node = new Node();
            node.entity = entity;

            if(head == null){
                head = node;
                return true;
            } else {
                Node cur = head;
                while(cur != null){
                    if(cur.entity.key == entity.key){
                        return false;
                    }
                    if(cur.next == null){
                        cur.next = node;
                        return true;
                    }
                    cur = cur.next;
                }
            }
            return false;
        }

    }
    public static int INIT_SIZE = 16;
    Basket[] baskets;

    public HasnMap(){
        this(INIT_SIZE);
    }

    public HasnMap(int size){
        baskets = new Basket[size];
    }

    int getIndex(int key){
        // return key.hashCode() % baskets.length; //если key объект
        return key % baskets.length;
    }

    public boolean insert(int key, int value){
        Entity entity = new Entity();
        entity.key = key;
        entity.value = value;

        int index = getIndex(key);

        Basket basket = baskets[index];

        if(basket == null){
            basket = new Basket();
            baskets[index] = basket;
        }
        return basket.insert(entity);
    }

}



public class HashTable {
    public static void main(String[] args) {

        HasnMap map = new HasnMap();

        map.insert(1, 2);
        map.insert(3, 4);
        map.insert(17, 6);


    }
}
