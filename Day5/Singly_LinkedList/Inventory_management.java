import java.util.NoSuchElementException;

public class Inventory_management{
    private Node head, tail;
    private int size;

    public Inventory_management(){
        this.size = 0;
    }

    public void insert_first(String item_name, int item_id, int price, int quantity){
        Node node = new Node(item_name, item_id, price, quantity);
        node.next = head;
        head = node;
        if(tail == null){
            tail = head;
        }
        size++;
    }
    
    public void insert_last(String item_name, int item_id, int price, int quantity){
        if(tail == null){
            insert_first(item_name, item_id, price, quantity);
            return;
        }
        Node node = new Node(item_name, item_id, price, quantity);
        tail.next = node;
        tail = node;
        size++;

    }
    
    public void insert(String item_name, int item_id, int price, int quantity, int index){
        if(index == 0){
            insert_first(item_name, item_id, price, quantity);
            return;
        }
        else if(index == size-1){
            insert_last(item_name, item_id, price, quantity);
            return;
        }
        else if(index >= size){
            throw new IndexOutOfBoundsException("out of bound");
        }
        Node node = new Node(item_name, item_id, price, quantity);
        Node temp = head;
        for(int i = 1; i<index; i++){
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;

        size++;

    }

    public void delete_first(){
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
    }

    public void delete(int index){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException("Index out of range");
        }
        if(index == 0){
            delete_first();
            return;
        }
        if(index == size-1){
            delete_last();
            return;
        }
        Node del_node = get(index-1);
        del_node.next = del_node.next.next;
        size--;
    }

    public void delete_last(){
        if(size <= 1){
            delete_first();
            return;
        }
        tail = get(size-2);
        tail.next = null;
        size--;
    }

    public void delete_val(int id){
        int index = find(id);
        delete(index);
    }
    
    public void delete_val(String item_name){
        int index = find(item_name);
        delete(index);
    }

    public void update(int quantity, int item_id){
        int index = find(item_id);
        Node temp = head;

        for(int i =0; i<index; i++){
            temp = temp.next;
        }
        temp.quantity = quantity;
    }

    public Node get(int index){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException("Index out of range");
        }
        Node temp = head;
        for(int i =0; i<index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public int find(int id){
        Node temp = head;
        int index = 0;
        while(temp != null){
            if(temp.item_id == id){
                return index;
            }
            temp = temp.next;
            index++;
        }
        throw new NoSuchElementException(id + " is not found");
    }

    public int find(String item_name){
        Node temp = head;
        int index = 0;
        while(temp != null){
            if(temp.item_name.equals(item_name)){
                return index;
            }
            temp = temp.next;
            index++;
        }
        throw new NoSuchElementException(item_name + " is not found");
    }

    public void display_price(){
        Node temp = head;
        int total = 0;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println(total);
    }
    
    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.println("item name: " +temp.item_name+ " -> item id: " +temp.item_id+ " -> price: " +temp.price+ " -> quantity: " +temp.quantity);
            temp = temp.next;
        }
        System.out.println("|_> END");

    }
    public void sortByName(boolean ascending) {
        head = mergeSortByName(head, ascending);
        updateTail();
    }
    
    private Node mergeSortByName(Node head, boolean ascending) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = getMiddle(head);
        Node midNext = mid.next;
        mid.next = null;
    
        Node left = mergeSortByName(head, ascending);
        Node right = mergeSortByName(midNext, ascending);
    
        return mergeByName(left, right, ascending);
    }
    
    private Node mergeByName(Node a, Node b, boolean ascending) {
        if (a == null) return b;
        if (b == null) return a;
    
        int comparison = a.item_name.compareToIgnoreCase(b.item_name);
        if ((ascending && comparison <= 0) || (!ascending && comparison > 0)) {
            a.next = mergeByName(a.next, b, ascending);
            return a;
        } else {
            b.next = mergeByName(a, b.next, ascending);
            return b;
        }
    }
    
    public void sortByPrice(boolean ascending) {
        head = mergeSortByPrice(head, ascending);
        updateTail();
    }
    
    private Node mergeSortByPrice(Node head, boolean ascending) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = getMiddle(head);
        Node midNext = mid.next;
        mid.next = null;
    
        Node left = mergeSortByPrice(head, ascending);
        Node right = mergeSortByPrice(midNext, ascending);
    
        return mergeByPrice(left, right, ascending);
    }
    
    private Node mergeByPrice(Node a, Node b, boolean ascending) {
        if (a == null) return b;
        if (b == null) return a;
    
        if ((ascending && a.price <= b.price) || (!ascending && a.price > b.price)) {
            a.next = mergeByPrice(a.next, b, ascending);
            return a;
        } else {
            b.next = mergeByPrice(a, b.next, ascending);
            return b;
        }
    }
    
    private Node getMiddle(Node head) {
        if (head == null) return head;
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private void updateTail() {
        if (head == null) {
            tail = null;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        tail = temp;
    }
    

    private class Node{
        private Node next;
        private int item_id, price, quantity;
        private String item_name;

        public Node(String item_name, int item_id, int price, int quantity){
            this.item_name = item_name;
            this.item_id = item_id;
            this.price = price;
            this.quantity = quantity;
        }
    }
}