public class Main {
    public static void drawLine() {
        System.out.println("---------------------------------------------------------------");
    }
    public static void main(String[] args) {
        // проверка сохранения записей и работы методов
        // создание книги записей
        EmployeeBook employeesRecord = new EmployeeBook();
        // заполнение записями
        employeesRecord.makeRecord("Киркоров Филлип Бедросович", 1, 253001);
        employeesRecord.makeRecord("Ургант Иван Андреевич", 2, 120556);
        employeesRecord.makeRecord("Светлаков Сергей Юрьевич", 2, 120550);
        employeesRecord.makeRecord("Юнусов Тимати Ильдарович", 1, 253000);
        employeesRecord.makeRecord("Ревва Александр Владимирович", 2, 12055);
        employeesRecord.makeRecord("Мартиросян Гарик Юрьевич", 2, 120674);
        employeesRecord.makeRecord("Харламов Игорь Бадтрудинович", 2, 128430);
        employeesRecord.makeRecord("Медведев Дмитрий Анатольевич", 5, 653000);
        employeesRecord.makeRecord("Трамп Дональд Джонович", 3, 999885);
        employeesRecord.makeRecord("Байден Джозеф Робинеттович", 4, 2500);

        // отобразим список всех сотрудников с данными
        employeesRecord.showEmployeesList();
        drawLine();
        // выведем только ФИО сотрудников
        employeesRecord.getFullNames();
        drawLine();
        // отобразим сумму зарплат всех сотрудников за месяц
        System.out.println(employeesRecord.getSpending());
        drawLine();
        // отобразим среднее значение зарплат сотрудников
        System.out.println(employeesRecord.getAverageSalary());
        drawLine();
        // выведем сотрудника с минимальной зарплатой
        employeesRecord.findMinSalary();
        drawLine();
        // выведем сотрудника с максимальной зарплатой
        employeesRecord.findMaxSalary();
        drawLine();
        // проиндексируем всем сотрудникам зарплату на 10 процентов и выведем снова данные всех сотрудников
        employeesRecord.indexSalaries(10);
        employeesRecord.showEmployeesList();
        drawLine();
        // выведем сотрудника с минимальной зарплатой в отделе №2
        employeesRecord.findMinSalaryInDepartment(2);
        drawLine();
        // выведем сотрудника с максимальной зарплатой в отделе №1
        employeesRecord.findMaxSalaryInDepartment(1);
        drawLine();
        // отобразим сумму зарплат всех сотрудников за месяц по отделу №1
        System.out.println(employeesRecord.getSpendingInDepartment(1));
        drawLine();
        // отобразим среднее значение зарплат сотрудников по отделу №2
        System.out.println(employeesRecord.getAverageSalaryInDepartment(2));
        drawLine();
        // проиндексируем всем сотрудникам отдела №2 зарплату на 5 процентов
        employeesRecord.indexSalariesInDepartment(2, 5);
        // выведем данные всех сотрудников отдела №2
        employeesRecord.printEmployeesList(2);
        // выведем всех сотрудников с зарплатой ниже 100000
        employeesRecord.findSalaryLessThen(100000);
        drawLine();
        // выведем всех сотрудников с зарплатой выше 555000
        employeesRecord.findSalaryMoreThen(555000);
        drawLine();
        // удалим запись сотрудника с id 9 и выведем список всех сотрудников
        employeesRecord.deleteEmployee(9);
        drawLine();
        employeesRecord.getFullNames();
        drawLine();
        // изменим зарплату Байдену
        employeesRecord.changeSalary("Медведев Дмитрий Анатольевич", 800000);
        // изменим отдел Трампу
        employeesRecord.changeDepartment("Трамп Дональд Джонович", 5);
        // выведем отделы и сотрудников
        employeesRecord.showEmployeesByDepartments();
        drawLine();

    }
}
/*Класс Employee для создания новых сотрудников. Имеет четыре поля: ФИО, номер отдела, заработную плату и id.
  Имеется возможнсть изменить зарплату и номер отдела.*/
class Employee {
    private static int idCount = 0; // переменная-счётчик для поля id
    final private String fullName; // поле для хранения ФИО
    private int department; // поле для хранения номера отдела
    private int salary; //поле для хранения зарплаты
    private final int id; //поле для хранения id
    public Employee (String fullName, int department, int salary) { // объявляем конструктор класса
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        // присваиваем полю "id" значение переменной idCount, затем увеличиваем счётчик на 1
        this.id = idCount;
        idCount++;
    }
    // четыре геттера для полей
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
    // два сеттера для полей отдела и зарплаты
    public void setDepartment(int department){
        this.department = department;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    // переопределение стандартного метода toString
    @Override
    public String toString(){
        return("ФИО: " + fullName + ", id: " + id + ", отдел №" + department + ", зарплата: " + salary);
    }
}

/* Класс EmployeeBook для хранения записей сотрудников, содержащий методы работы с массивом объектов
   класса Employee*/
class EmployeeBook {
    private final Employee[] employees = new Employee[10]; // создание массив с типом Employee для хранения записей

    public EmployeeBook() {} // объявление конструктора класса

    // метод, реализующий создание нового объекта класса Employee с сохранением в массив
    public  void makeRecord(String fullName, int department, int salary) {
        int index = 0;
        // проход циклом по массиву, если запись пустая, сохраняем в эту запись нового сотрудника
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                index = i;
                break;
            }
        }
        employees[index] = new Employee(fullName, department, salary);
    }
    // метод, реализующий получение списка всех сотрудников со всеми имеющимися по ним данными
    public  void showEmployeesList() {
        for (Employee employee: employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }
    // метод, выводящий ФИО всех сотрудников
    public void getFullNames() {
        for (Employee employee: employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }
    // метод, возвращающий сумму затрат на зарплаты в месяц
    public int getSpending() {
        int sum = 0;
        for (Employee employee: employees) {
            if (employee != null) {
                sum = sum + employee.getSalary();
            }
        }
        return sum;
    }
    // метод, возвращающий среднее значение зарплат
    public  int getAverageSalary() {
        int count = 0;
        for (Employee employee: employees) {
            if (employee != null) {
                count++;
            }
        }
        return getSpending() / count;
    }
    // метод, выводящий сотрудника с минимальной зарплатой
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
    // метод, выводящий сотрудника с максимальной зарплатой
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
    // метод, индексирующий зарплату всем сотрудникам на определенный процент
    public  void indexSalaries(int percent) {
        for (Employee employee: employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() + employee.getSalary() / 100 * percent);
            }
        }
    }
    // метод, выводящий сотрудника с минимальной зарплатой в определенноом отделе
    public void findMinSalaryInDepartment (int department) {
        int min = 0;
        String empName = "";
        int count = 0;
        // сначала ищем первую ненулевую запись с нужным отделом, берем за минимальную
        for (Employee employee: employees) {
            if (employee != null && employee.getDepartment() == department) {
                min = employee.getSalary();
                empName = employee.getFullName();
                break;
            }
        }
        //в этом цикле сравниваем записи сотрудником в нужном отделе
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
    // метод, выводящий сотрудника с максимальной зарплатой в определенноом отделе
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
    // метод, возвращающий сумму зарплат по определенному отделу
    public  int getSpendingInDepartment(int department) {
        int sum = 0;
        for (Employee employee: employees) {
            if (employee != null && employee.getDepartment() == department) {
                sum = sum + employee.getSalary();
            }
        }
        return sum;
    }
    // метод, возвращающий среднее значение зарплат по определенному отделу
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
    // метод, индексирующий зарплату всем сотрудникам на определенный процент в определенном отделе
    public void indexSalariesInDepartment(int department, int percent) {
        for (Employee employee: employees) {
            if (employee != null && employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() + employee.getSalary() / 100 * percent);
            }
        }
    }
    // метод, выводящий данные всех сотрудников определенного отдела
    public void printEmployeesList(int department) {
        for (Employee employee: employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println("ФИО: " + employee.getFullName()
                        + ", id: " + employee.getId()
                        + ", зарплата: " + employee.getSalary());
            }
        }
    }
    // метод, выводящий всех сотрудников с зарплатой меньше указанного параметра
    public void findSalaryLessThen(int salary) {
        for (Employee employee: employees) {
            if (employee != null && employee.getSalary() < salary) {
                System.out.println("id: " + employee.getId()
                        + ", ФИО: " + employee.getFullName()
                        + ", зарплата " + employee.getSalary());
            }
        }
    }
    // метод, выводящий всех сотрудников с зарплатой больше (или равно) указанного параметра
    public void findSalaryMoreThen(int salary) {
        for (Employee employee: employees) {
            if (employee != null && employee.getSalary() >= salary) {
                System.out.println("id: " + employee.getId()
                        + ", ФИО: " + employee.getFullName()
                        + ", зарплата " + employee.getSalary());
            }
        }
    }
    // метод, удаляющий запись сотрудника по id
    public void deleteEmployee (int id) {
        boolean isExists = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i] = null;
                isExists = true;
            }
        }
        if (isExists) {
            System.out.println("Запись сотрудника успешно удалена");
        } else System.out.println("Сотрудник не найден");
    }
    // метод, изменяющий зарплату сотруднику с определенным ФИО
    public void changeSalary (String fullName, int salary) {
        for (Employee employee: employees) {
            if (employee != null && employee.getFullName().equals(fullName)) {
                employee.setSalary(salary);
            }
        }
    }
    // метод, изменяющий номер отдела сотруднику с определенным ФИО
    public void changeDepartment (String fullName, int department) {
        for (Employee employee: employees) {
            if (employee != null && employee.getFullName().equals(fullName)) {
                employee.setDepartment(department);
            }
        }
    }
    public void showEmployeesByDepartments() {
        for (Employee employee: employees) {
            if (employee != null) {
                System.out.println("Отдел №" + employee.getDepartment() + ", сотрудник: " + employee.getFullName());
            }
        }
    }
}