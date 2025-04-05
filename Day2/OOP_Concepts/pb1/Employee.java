package Day2.OOP_Concepts.pb1;

interface Department{
    void AssignDep(String Dept_Name);
    String getDept_Name();
}

public abstract class Employee {
    private int EmployeeId, Base_Salary;
    private String Name;

    public Employee(int EmployeeId, String Name, int Base_Salary){
        this.EmployeeId = EmployeeId;
        this.Name = Name;
        this.Base_Salary = Base_Salary;
    }

    protected Employee() {
    }

    public String getName() {return Name;}

    public int getEmployeeId() {return EmployeeId;}

    public int getBase_Salary() {return Base_Salary;}

    public void setBase_Salary(int base_Salary) {
        Base_Salary = base_Salary;
    }

    public abstract void Calculate_Salary();

    public void displayDetails() {
        System.out.println("ID: " + EmployeeId + ", Name: " + Name + ", Base Salary: " + Base_Salary);
    }
}

