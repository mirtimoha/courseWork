public class Main {
    private static final Employee[] employees = new Employee [10];

    public static void getEmployeesList(Employee[] employees) {
        for (Employee employee: employees) {
            System.out.println(employee.toString());
        }
    }
    public static int getSpending(Employee[] employees) {
        int sum = 0;
        for (Employee employee: employees) {
            sum = sum + employee.getSalary();
        }
        return sum;
    }
    public static void findMinSalary(Employee[] employees) {
        int min = employees[0].getSalary();
        String empName = employees[0].getFullName();
        for(Employee employee: employees) {
            if (employee.getSalary() < min) {
                min = employee.getSalary();
                empName = employee.getFullName();
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой " + empName + ". Зарплата - " + min);
    }
    public static void findMaxSalary(Employee[] employees) {
        int max = employees[0].getSalary();
        String empName = employees[0].getFullName();
        for(Employee employee: employees) {
            if (employee.getSalary() > max) {
                max = employee.getSalary();
                empName = employee.getFullName();
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой " + empName + ". Зарплата - " + max);
    }
    public static int getAverageSalary(Employee[] employees) {
        return getSpending(employees) / employees.length;
    }
    public static void getFullNames(Employee[] employees) {
        for (Employee employee: employees) {
            System.out.println(employee.getFullName());
        }
    }
    public static void indexSalaries(Employee[] employees, int percent) {
        for (Employee employee: employees) {
            employee.setSalary(employee.getSalary() + employee.getSalary() / 100 * percent);
        }
    }
    public static void findMinSalaryInDepartment (Employee[] employees, int department) {
        int min = 0;
        String empName = "";
        int count = 0;
        for (Employee employee: employees) {
            if (employee.getDepartment() == department) {
                min = employee.getSalary();
                empName = employee.getFullName();
                break;
            }
        }
        for (Employee employee: employees) {
            if (employee.getDepartment() == department) {
                if (employee.getSalary() <= min) {
                    min = employee.getSalary();
                    empName = employee.getFullName();
                    count++;
                }
            }
        }
        if (count > 0) {
            System.out.println("Сотрудник с минимальной зарплатой в отделе №" + department + " - " + empName);
        } else System.out.println("В данном отделе сотрудников нет");
    }
    public static void findMaxSalaryInDepartment (Employee[] employees, int department) {
        int max = 0;
        String empName = "";
        int count = 0;
        for (Employee employee: employees) {
            if (employee.getDepartment() == department) {
                max = employee.getSalary();
                empName = employee.getFullName();
                break;
            }
        }
        for (Employee employee: employees) {
            if (employee.getDepartment() == department) {
                if (employee.getSalary() >= max) {
                    max = employee.getSalary();
                    empName = employee.getFullName();
                    count++;
                }
            }
        }
        if (count > 0) {
            System.out.println("Сотрудник с максимальной зарплатой в отделе №" + department + " - " + empName);
        } else System.out.println("В данном отделе сотрудников нет");
    }
    public static int getSpendingInDepartment(Employee[] employees, int department) {
        int sum = 0;
        for (Employee employee: employees) {
            if (employee.getDepartment() == department) {
                sum = sum + employee.getSalary();
            }
        }
        return sum;
    }
    public static int getAverageSalaryInDepartment(Employee[] employees, int department) {
        int sum = 0;
        int count = 0;
        for (Employee employee: employees) {
            if (employee.getDepartment() == department) {
                sum = sum + employee.getSalary();
                count++;
            }
        }
        return sum / count;
    }
    public static void main(String[] args) {
        employees[0] = new Employee("Мирхамедов Тимур", 1, 234253423);
        employees[1] = new Employee("Иванов Николай1", 2, 123213);
        employees[2] = new Employee("Иванов Николай2", 3, 333333);
        employees[3] = new Employee("Иванов Николай3", 2, 23425);
        employees[4] = new Employee("Иванов Николай4", 4, 2342534);
        employees[5] = new Employee("Иванов Николай5", 4, 233453);
        employees[6] = new Employee("Иванов Николай6", 5, 234552);
        employees[7] = new Employee("Иванов Николай7", 3, 23412);
        employees[8] = new Employee("Иванов Николай8", 4, 22342);
        employees[9] = new Employee("Иванов Николай9", 1, 2342534);
        int sum = getSpending(employees);
        int averageSalary = getAverageSalary(employees);
        /*
        getEmployeesList(employees);
        findMinSalary(employees);
        getFullNames(employees);
        */
        findMaxSalary(employees);
        indexSalaries(employees, 50);
        findMaxSalary(employees);
        findMinSalaryInDepartment(employees, 4);
        findMaxSalaryInDepartment(employees, 4);
    }
}
class Employee {
    private static int idCount;
    final private String fullName;
    private int department;
    private int salary;
    private int id;
    public Employee (String fullName, int department, int salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        this.id = addId();
        idCount++;
    }
    public String getFullName() {
        return fullName;
    }
    public int getDepartment() {
        return department;
    }
    public int getSalary() {
        return salary;
    }
    public int getId() {
        return id;
    }
    public int addId() {
        return idCount;
    }
    public void setDepartment(int department){
        this.department = department;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    @Override
    public String toString(){
        return(fullName+ ", "
                +department+ ", "
                +salary);
    }
}