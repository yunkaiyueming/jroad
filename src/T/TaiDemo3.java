package T;

abstract class Employee {
    private String name;
    private String address;
    private int number;

    public Employee(String name, String address, int number) {
        System.out.println("Constructing an Employee");
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public double computePay() {
        System.out.println("Inside Employee computePay");
        return 0.0;
    }

    public void mailCheck() {
        System.out.println("Employee:Mailing a check to " + this.name
                + " " + this.address);
    }

    public String toString() {
        return name + " " + address + " " + number;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String newAddress) {
        address = newAddress;
    }

    public int getNumber() {
        return number;
    }
}

class Salary extends Employee {
    private double salary; //Annual salary

    public Salary(String name, String address, int number, double
            salary) {
        super(name, address, number);
        setSalary(salary);
    }

    public void mailCheck() {
        System.out.println("Salary:");
        System.out.println("Mailing check to " + getName()
                + " with salary " + salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double newSalary) {
        if (newSalary >= 0.0) {
            salary = newSalary;
        }
    }

    public double computePay() {
        System.out.println("Computing salary pay for " + getName());
        return salary / 52;
    }
}


class Smell extends Employee {
    private double salary; //Annual salary

    public Smell(String name, String address, int number, double
            salary) {
        super(name, address, number);
        setSalary(salary);
    }

    public void mailCheck() {
        System.out.println("Smell:");
        System.out.println("Mailing check to " + getName()
                + " with salary " + salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double newSalary) {
        if (newSalary >= 0.0) {
            salary = newSalary;
        }
    }

    public double computePay() {
        System.out.println("Computing salary pay for " + getName());
        return salary / 52;
    }
}

//通过继承抽象类 实现多态
public class TaiDemo3 {
    public void run(Employee e) {//使用抽象类参数，传递实现类 可以调用实现类的方法
        e.mailCheck();
    }

    public static void main(String[] args) {
        TaiDemo3 t3 = new TaiDemo3();
        Salary s = new Salary("Mohd Mohtashim", "Ambehta, UP", 3, 3600.00);

        Employee e = new Salary("John Adams", "Boston, MA", 2, 2400.00);
        Employee f = new Smell("tom ", "tom as, MA", 2, 1400.00);


        t3.run(s);
        t3.run(e);
        t3.run(f);
    }
}
