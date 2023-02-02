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

