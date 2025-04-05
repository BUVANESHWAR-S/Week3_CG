package Day2.OOP_Concepts.pb1;

public class Partime_Employe extends Employee implements Department{


    String Department;
    int increment;

    public Partime_Employe(int Employee_ID, String name, int base_salary ){
        super(Employee_ID, name, base_salary);
    }

    @Override
    public void AssignDep(String Dept_Name) {
        Department = Dept_Name;
    }

    @Override
    public String getDept_Name() {
        return Department;
    }



    @Override
    public void Calculate_Salary() {
        increment = 3000;
        setBase_Salary(getBase_Salary() + increment);
    }


}
