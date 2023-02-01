/* Класс EmployeeBook для хранения записей сотрудников, содержащий методы работы с массивом объектов
   класса Employee*/
public class EmployeeBook {
    private final Employee[] employees = new Employee[10]; // создание массив с типом Employee для хранения записей

    public EmployeeBook() {
    } // объявление конструктора класса

    // метод, реализующий создание нового объекта класса Employee с сохранением в массив
    public void makeRecord(String fullName, int department, int salary) {
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
    public void showEmployeesList() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    // метод, выводящий ФИО всех сотрудников
    public void getFullNames() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }

    // метод, возвращающий сумму затрат на зарплаты в месяц
    public int getSpending() {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum = sum + employee.getSalary();
            }
        }
        return sum;
    }

    // метод, возвращающий среднее значение зарплат
    public int getAverageSalary() {
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                count++;
            }
        }
        return getSpending() / count;
    }

    // метод, выводящий сотрудника с минимальной зарплатой
    public void findMinSalary() {
        int min = employees[0].getSalary();
        String empName = employees[0].getFullName();
        for (Employee employee : employees) {
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
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > max) {
                max = employee.getSalary();
                empName = employee.getFullName();
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой " + empName + ". Зарплата - " + max);
    }

    // метод, индексирующий зарплату всем сотрудникам на определенный процент
    public void indexSalaries(int percent) {
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() + employee.getSalary() / 100 * percent);
            }
        }
    }

    // метод, выводящий сотрудника с минимальной зарплатой в определенноом отделе
    public void findMinSalaryInDepartment(int department) {
        int min = 0;
        String empName = "";
        int count = 0;
        // сначала ищем первую ненулевую запись с нужным отделом, берем за минимальную
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                min = employee.getSalary();
                empName = employee.getFullName();
                break;
            }
        }
        //в этом цикле сравниваем записи сотрудником в нужном отделе
        for (Employee employee : employees) {
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
    public void findMaxSalaryInDepartment(int department) {
        int max = 0;
        String empName = "";
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                max = employee.getSalary();
                empName = employee.getFullName();
                break;
            }
        }
        for (Employee employee : employees) {
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
    public int getSpendingInDepartment(int department) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                sum = sum + employee.getSalary();
            }
        }
        return sum;
    }

    // метод, возвращающий среднее значение зарплат по определенному отделу
    public int getAverageSalaryInDepartment(int department) {
        int sum = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                sum = sum + employee.getSalary();
                count++;
            }
        }
        return sum / count;
    }

    // метод, индексирующий зарплату всем сотрудникам на определенный процент в определенном отделе
    public void indexSalariesInDepartment(int department, int percent) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() + employee.getSalary() / 100 * percent);
            }
        }
    }

    // метод, выводящий данные всех сотрудников определенного отдела
    public void printEmployeesList(int department) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println("ФИО: " + employee.getFullName()
                        + ", id: " + employee.getId()
                        + ", зарплата: " + employee.getSalary());
            }
        }
    }

    // метод, выводящий всех сотрудников с зарплатой меньше указанного параметра
    public void findSalaryLessThen(int salary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < salary) {
                System.out.println("id: " + employee.getId()
                        + ", ФИО: " + employee.getFullName()
                        + ", зарплата " + employee.getSalary());
            }
        }
    }

    // метод, выводящий всех сотрудников с зарплатой больше (или равно) указанного параметра
    public void findSalaryMoreThen(int salary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= salary) {
                System.out.println("id: " + employee.getId()
                        + ", ФИО: " + employee.getFullName()
                        + ", зарплата " + employee.getSalary());
            }
        }
    }

    // метод, удаляющий запись сотрудника по id
    public void deleteEmployee(int id) {
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
    public void changeSalary(String fullName, int salary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getFullName().equals(fullName)) {
                employee.setSalary(salary);
            }
        }
    }

    // метод, изменяющий номер отдела сотруднику с определенным ФИО
    public void changeDepartment(String fullName, int department) {
        for (Employee employee : employees) {
            if (employee != null && employee.getFullName().equals(fullName)) {
                employee.setDepartment(department);
            }
        }
    }

    public void showEmployeesByDepartments() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println("Отдел №" + employee.getDepartment() + ", сотрудник: " + employee.getFullName());
            }
        }
    }
}
