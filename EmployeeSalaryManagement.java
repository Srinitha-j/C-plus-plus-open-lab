import java.util.*;

class Person
{
    int id;
    String name;

    Person(int id,String name)
    {
        this.id=id;
        this.name=name;
    }

    void display()
    {
        System.out.println("Employee ID : "+id);
        System.out.println("Name        : "+name);
    }
}

class Staff extends Person
{
    String department;

    Staff(int id,String name,String department)
    {
        super(id,name);
        this.department=department;
    }

    void display()
    {
        super.display();
        System.out.println("Department  : "+department);
    }
}

class Employee extends Staff
{
    String position;

    double hourlyRate;
    int workingDays;
    int overtimeHours;
    int leaveDays;

    double bonus;

    String bankAccount;
    String paymentDate;

    Employee(int id,String name,String department,String position,
             double hourlyRate,int workingDays,int overtimeHours,
             double bonus,String bankAccount,String paymentDate)
    {
        super(id,name,department);

        this.position=position;
        this.hourlyRate=hourlyRate;
        this.workingDays=workingDays;
        this.overtimeHours=overtimeHours;
        this.bonus=bonus;

        this.bankAccount=bankAccount;
        this.paymentDate=paymentDate;
    }

    double calculateSalary()
    {
        int effectiveDays = workingDays - leaveDays;

        if(effectiveDays < 0)
            effectiveDays = 0;

        int effectiveHours = effectiveDays * 8;

        double normalPay = hourlyRate * effectiveHours;

        double overtimePay = overtimeHours * hourlyRate * 1.5;

        double gross = normalPay + overtimePay + bonus;

        double tax;

        if(gross > 60000)
            tax = gross * 0.10;
        else
            tax = gross * 0.05;

        return gross - tax;
    }

    void applyLeave(int days)
    {
        leaveDays += days;
        System.out.println("Leave applied for "+days+" days");
    }

    void promote(String newPosition)
    {
        position = newPosition;
        System.out.println("Employee promoted to "+newPosition);
    }

    void addIncrement(double amount)
    {
        hourlyRate += amount;
        System.out.println("Salary increment added");
    }

    void generateSalarySlip()
    {
        int effectiveDays = workingDays - leaveDays;

        if(effectiveDays < 0)
            effectiveDays = 0;

        int effectiveHours = effectiveDays * 8;

        double normalPay = hourlyRate * effectiveHours;

        double overtimePay = overtimeHours * hourlyRate * 1.5;

        double gross = normalPay + overtimePay + bonus;

        double tax;

        if(gross > 60000)
            tax = gross * 0.10;
        else
            tax = gross * 0.05;

        double netSalary = gross - tax;

        System.out.println("\n====================================");
        System.out.println("            SALARY SLIP             ");
        System.out.println("====================================");

        System.out.println("Employee ID   : "+id);
        System.out.println("Name          : "+name);
        System.out.println("Department    : "+department);
        System.out.println("Position      : "+position);

        System.out.println("\nWork Details");
        System.out.println("Working Days  : "+workingDays);
        System.out.println("Leave Days    : "+leaveDays);
        System.out.println("Overtime Hrs  : "+overtimeHours);

        System.out.println("\nPayment Details");
        System.out.println("Bank Account  : "+bankAccount);
        System.out.println("Payment Date  : "+paymentDate);

        System.out.println("\nSalary Calculation");
        System.out.println("Normal Pay    : "+normalPay);
        System.out.println("Overtime Pay  : "+overtimePay);
        System.out.println("Bonus         : "+bonus);
        System.out.println("Gross Salary  : "+gross);
        System.out.println("Tax Deduction : "+tax);

        System.out.println("\nNet Salary Paid : "+netSalary);

        System.out.println("====================================\n");
    }

    void display()
    {
        super.display();
        System.out.println("Position    : "+position);
        System.out.println("Leave Days  : "+leaveDays);
    }
}

public class EmployeeSalaryManagement
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);

        ArrayList<Employee> employees=new ArrayList<>();

        int mainChoice;

        do
        {
            System.out.println("\n===== LOGIN MENU =====");
            System.out.println("1 Admin Login");
            System.out.println("2 Employee Login");
            System.out.println("3 Exit");

            mainChoice=sc.nextInt();

            if(mainChoice==1)
            {
                System.out.print("Username: ");
                String user=sc.next();

                System.out.print("Password: ");
                String pass=sc.next();

                if(user.equals("admin") && pass.equals("1234"))
                {
                    int choice;

                    do
                    {
                        System.out.println("\n===== ADMIN PANEL =====");
                        System.out.println("1 Add Employee");
                        System.out.println("2 Remove Employee");
                        System.out.println("3 Promote Employee");
                        System.out.println("4 Add Salary Increment");
                        System.out.println("5 Display Employees");
                        System.out.println("6 Exit");

                        choice=sc.nextInt();

                        switch(choice)
                        {
                            case 1:

                                System.out.print("ID: ");
                                int id=sc.nextInt();
                                sc.nextLine();

                                System.out.print("Name: ");
                                String name=sc.nextLine();

                                System.out.print("Department: ");
                                String dept=sc.nextLine();

                                System.out.print("Position: ");
                                String pos=sc.nextLine();

                                System.out.print("Hourly Rate: ");
                                double rate=sc.nextDouble();

                                System.out.print("Working Days: ");
                                int days=sc.nextInt();

                                System.out.print("Overtime Hours: ");
                                int overtime=sc.nextInt();

                                System.out.print("Bonus: ");
                                double bonus=sc.nextDouble();
                                sc.nextLine();

                                System.out.print("Bank Account: ");
                                String bank=sc.nextLine();

                                System.out.print("Payment Date: ");
                                String pay=sc.nextLine();

                                Employee emp=new Employee(id,name,dept,pos,rate,
                                        days,overtime,bonus,bank,pay);

                                employees.add(emp);

                                System.out.println("Employee added successfully.");

                                break;

                            case 2:

                                System.out.print("Enter Employee ID to remove: ");
                                int removeId=sc.nextInt();

                                employees.removeIf(e->e.id==removeId);

                                System.out.println("Employee removed.");

                                break;

                            case 3:

                                System.out.print("Employee ID: ");
                                int pid=sc.nextInt();

                                for(Employee e:employees)
                                {
                                    if(e.id==pid)
                                    {
                                        sc.nextLine();
                                        System.out.print("New Position: ");
                                        e.promote(sc.nextLine());
                                    }
                                }

                                break;

                            case 4:

                                System.out.print("Employee ID: ");
                                int iid=sc.nextInt();

                                for(Employee e:employees)
                                {
                                    if(e.id==iid)
                                    {
                                        System.out.print("Increment Amount: ");
                                        e.addIncrement(sc.nextDouble());
                                    }
                                }

                                break;

                            case 5:

                                for(Employee e:employees)
                                {
                                    e.display();
                                    System.out.println("Current Salary : "+e.calculateSalary());
                                    System.out.println("---------------------------");
                                }

                                break;

                        }

                    }while(choice!=6);
                }
                else
                {
                    System.out.println("Invalid login.");
                }
            }

            else if(mainChoice==2)
            {
                System.out.print("Enter Employee ID: ");
                int eid=sc.nextInt();

                boolean found=false;

                for(Employee e:employees)
                {
                    if(e.id==eid)
                    {
                        found=true;

                        System.out.println("Do you want to apply leave?");
                        System.out.println("1 Yes");
                        System.out.println("2 No");

                        int choice=sc.nextInt();

                        if(choice==1)
                        {
                            System.out.print("Enter leave days: ");
                            int days=sc.nextInt();
                            e.applyLeave(days);
                        }

                        e.generateSalarySlip();
                        
                    }
                }

                if(!found)
                {
                    System.out.println("Employee ID not found.");
                }
            }

        }while(mainChoice!=3);
    }
}