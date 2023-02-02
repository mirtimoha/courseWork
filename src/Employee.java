/*Класс Employee для создания новых сотрудников. Имеет четыре поля: ФИО, номер отдела, заработную плату и id.
  Имеется возможнсть изменить зарплату и номер отдела.*/
public class Employee {
    private static int idCount = 0; // переменная-счётчик для поля id
    final private String fullName; // поле для хранения ФИО
    private int department; // поле для хранения номера отдела
    private int salary; //поле для хранения зарплаты
    private final int id; //поле для хранения id

    public Employee(String fullName, int department, int salary) { // объявляем конструктор класса
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
    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    // переопределение стандартного метода toString
    @Override
    public String toString() {
        return ("ФИО: " + fullName + ", id: " + id + ", отдел №" + department + ", зарплата: " + salary);
    }
}
