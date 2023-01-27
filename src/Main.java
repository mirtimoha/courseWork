public class Main {
    public static void main(String[] args) {
        EmployeeBook rec1 = new EmployeeBook();
        rec1.makeRecord("Ivanov Ivan", 2, 25000);
        rec1.makeRecord("Petrov Petr", 3, 45000);
        rec1.showEmployeesList();
        System.out.println(rec1.getSpending());
        rec1.findMinSalary();
        rec1.findMaxSalary();
        System.out.println(rec1.getAverageSalary());
        rec1.getFullNames();
        rec1.indexSalaries(50);
        rec1.showEmployeesList();
        rec1.deleteEmployee(0);
    }
}
class Employee {
    private static int idCount;
    final private String fullName;
    private int department;
    private int salary;
    private final int id;
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
        return("ФИО: " + fullName + ", id: " + id + ", отдел №" + department + ", зарплата: " + salary);
    }
}
class EmployeeBook {
    private final Employee[] employees = new Employee[10];

    public EmployeeBook() {
    }

    public  void makeRecord(String fullName, int department, int salary) {
        int index = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                index = i;
                break;
            }
        }
        employees[index] = new Employee(fullName, department, salary);
    }
    public  void showEmployeesList() {
        for (Employee employee: employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }
    public void getFullNames() {
        for (Employee employee: employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }
    public int getSpending() {
        int sum = 0;
        for (Employee employee: employees) {
            if (employee != null) {
                sum = sum + employee.getSalary();
            }
        }
        return sum;
    }
    public  int getAverageSalary() {
        int count = 0;
        for (Employee employee: employees) {
            if (employee != null) {
                count++;
            }
        }
        return getSpending() / count;
    }
    public  void findMinSalary() {
        int min = employees[0].getSalary();
        String empName = employees[0].getFullName();
        for(Employee employee: employees) {
            if (employee != null && employee.getSalary() < min) {
                min = employee.getSalary();
                empName = employee.getFullName();
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой " + empName + ". Зарплата - " + min);
    }
    public void findMaxSalary() {
        int max = employees[0].getSalary();
        String empName = employees[0].getFullName();
        for(Employee employee: employees) {
            if (employee != null && employee.getSalary() > max) {
                max = employee.getSalary();
                empName = employee.getFullName();
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой " + empName + ". Зарплата - " + max);
    }
    public  void indexSalaries(int percent) {
        for (Employee employee: employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() + employee.getSalary() / 100 * percent);
            }
        }
    }
    public  void findMinSalaryInDepartment (int department) {
        int min = 0;
        String empName = "";
        int count = 0;
        for (Employee employee: employees) {
            if (employee != null && employee.getDepartment() == department) {
                min = employee.getSalary();
                empName = employee.getFullName();
                break;
            }
        }
        for (Employee employee: employees) {
            if (employee != null && employee.getDepartment() == department) {
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
    public void findMaxSalaryInDepartment (int department) {
        int max = 0;
        String empName = "";
        int count = 0;
        for (Employee employee: employees) {
            if (employee != null && employee.getDepartment() == department) {
                max = employee.getSalary();
                empName = employee.getFullName();
                break;
            }
        }
        for (Employee employee: employees) {
            if (employee != null && employee.getDepartment() == department) {
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
    public  int getSpendingInDepartment(int department) {
        int sum = 0;
        for (Employee employee: employees) {
            if (employee != null && employee.getDepartment() == department) {
                sum = sum + employee.getSalary();
            }
        }
        return sum;
    }
    public  int getAverageSalaryInDepartment(int department) {
        int sum = 0;
        int count = 0;
        for (Employee employee: employees) {
            if (employee != null && employee.getDepartment() == department) {
                sum = sum + employee.getSalary();
                count++;
            }
        }
        return sum / count;
    }
    public void indexSalariesInDepartment(int department, int percent) {
        for (Employee employee: employees) {
            if (employee != null && employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() + employee.getSalary() / 100 * percent);
            }
        }
    }
    public void printEmployeesList(int department) {
        for (Employee employee: employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println("ФИО: " + employee.getFullName()
                        + ", id: " + employee.getId()
                        + ", зарплата: " + employee.getSalary());
            }
        }
    }
    public void findSalaryLessThen(int salary) {
        for (Employee employee: employees) {
            if (employee != null && employee.getSalary() < salary) {
                System.out.println("id: " + employee.getId()
                        + ", ФИО: " + employee.getFullName()
                        + ", зарплата " + employee.getSalary());
            }
        }
    }
    public void findSalaryMoreThen(int salary) {
        for (Employee employee: employees) {
            if (employee != null && employee.getSalary() >= salary) {
                System.out.println("id: " + employee.getId()
                        + ", ФИО: " + employee.getFullName()
                        + ", зарплата " + employee.getSalary());
            }
        }
    }
    public void deleteEmployee (int id) {
        boolean isExists = false;
        for (Employee employee: employees) {
            if (employee != null && employee.getId() == id) {
                employee = null;
                isExists = true;
            }
        }
        if (isExists) {
            System.out.println("Запись сотрудника успешно удалена");
        } else System.out.println("Сотрудник не найден");
    }
}