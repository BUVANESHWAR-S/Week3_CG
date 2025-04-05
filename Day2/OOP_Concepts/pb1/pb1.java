package Day2.OOP_Concepts.pb1;

public class pb1 {
    public static void main(String[] args) {
        Fulltime_Employee emp1 = new Fulltime_Employee(1, "Chef", 40000, 10);
        Fulltime_Employee emp2 = new Fulltime_Employee(2, "Chief", 30000, 2);
        Fulltime_Employee emp3 = new Fulltime_Employee(3, "Kuroko", 50000, 3);
        Partime_Employe emp4 = new Partime_Employe(4, "Buvaneshwar", 20000);

        emp1.Calculate_Salary();
        emp1.displayDetails();
        emp1.AssignDep("developer");
        System.out.println(emp1.getDept_Name());
        emp4.Calculate_Salary();
        emp4.displayDetails();

    }
}
