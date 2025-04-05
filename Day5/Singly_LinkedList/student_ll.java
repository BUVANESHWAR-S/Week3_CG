import java.util.NoSuchElementException;

public class student_ll {

    private Node head;
    private Node tail;
    private int size;

    public student_ll(){
        this.size = 0;
    }

    public void insert_first(String Name, int Roll_num, int age, char grade){
        Node node = new Node(Name, Roll_num, age, grade);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }
        size++;
    }

    public void insert(String Name, int Roll_num, int age, char grade, int index){
        if(index == 0){
            insert_first(Name, Roll_num, age, grade);
            return;
        }
        else if(index == size){
            insert_last(Name, Roll_num, age, grade);
            return;
        }
        else if(index > size){
            System.out.println("Index out of Range");
            return;
        }
        Node temp = head;
        for(int i = 1; i<index; i++){
            temp = temp.next;
        }
        Node node = new Node(Name, Roll_num, age, grade);
        node.next = temp.next;
        temp.next = node;
        size++;

    }

    public void insert_last(String Name, int Roll_num, int age, char grade){
        if(tail == null){
            insert_first(Name, Roll_num, age, grade);
            return;
        }
        Node node = new Node(Name, Roll_num, age, grade);
        tail.next = node;
        tail = node;
        size++;
        
    }
    public void delete_first(){
        head = head.next;
        if(head == null){
            tail = null;
        }
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
    public void delete(int index){
        if(index>= size){
            throw new IndexOutOfBoundsException("Index out of range");
        }
        if(index == 0){
            //delete_first();
            delete_first();
            return;
        }
        else if(index == size-1){
           // delete_last();
            delete_last();
            return;
        }
        Node del_Node = get(index-1);
        del_Node.next = del_Node.next.next;
        size--;
    }
    public void delete_Roll_no(int Roll_num){
        int index = find(Roll_num);
        delete(index);
    }
    public Node get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if(index == 0){
            return head;
        }
        Node temp = head;
        for(int i = 0; i<index; i++){
            temp = temp.next;
        }
        return temp;
    }
    public int find(int Roll_num){
        Node node = head;
        int index = 0;
        while(node != null){
            if(node.Roll_num == Roll_num){
                return index;
            }
            node = node.next;
            index++;
        }
        throw new NoSuchElementException(Roll_num + " is not found");
    }
    public void update(int Roll_num, char new_grade){
        int index = find(Roll_num);
        Node temp = head;
        for(int i = 0; i<index; i++){
            temp = temp.next;
        }
        temp.grade = new_grade;
    }

    public void display(){
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.Name + " "+ temp.Roll_num +" "+ temp.age +" "+ temp.grade);
            temp = temp.next;
        }
        System.out.println("done");
    }

    private class Node{
        private int Roll_num, age;
        String Name;
        char grade;
        private Node next;

        public Node(String Name, int Roll_num, int age, char grade){
            this.Name = Name;
            this.Roll_num = Roll_num;
            this.age = age;
            this.grade = grade;
        }
    }
    
}