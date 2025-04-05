package Day2.OOP_Concepts.pb1;

public class Fulltime_Employee extends Employee implements Department{
    //int basesalary = getBase_Salary();
    int work_exp, increment;
    String Department;

    public Fulltime_Employee(int Employeeid, String name, int salary, int work_exp){
        super(Employeeid, name, salary);
        this.work_exp = work_exp;
    }
    @Override
    public void Calculate_Salary(){
        int current_salary = getBase_Salary();
        if(work_exp > 5){
            increment = 10000;
        }
        else if(work_exp >=3 && work_exp<5){
            increment = 5000;
        }
        else{
            increment = 0;
        }
        setBase_Salary(current_salary+ increment);
    }

    @Override
    public void AssignDep(String Dept_Name) {
        Department = Dept_Name;
    }

    @Override
    public String getDept_Name() {
        return Department;
    }

//    public void setBasesalary(int basesalary) {
//        this.basesalary = basesalary;
//    }
}
