// 34. Сделайте класс User, в котором будут следующие protected поля - name (имя), age (возраст), public методы setName, getName, setAge, getAge.
// Сделайте класс Worker, который наследует от класса User и вносит дополнительное private поле salary (зарплата), а также методы public getSalary и setSalary.
// Создайте объект этого класса 'Иван', возраст 25, зарплата 1000. Создайте второй объект этого класса 'Вася', возраст 26, зарплата 2000.
// Найдите сумму зарплата Ивана и Васи. Сделайте класс Student, который наследует от класса User и вносит дополнительные private поля стипендия, курс,
// а также геттеры и сеттеры для них.

class User {
    protected String name;
    protected int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Worker extends User {
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class Student extends User {
    private double stipend;
    private int course;

    public double getStipend() {
        return stipend;
    }

    public void setStipend(double stipend) {
        this.stipend = stipend;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }
}

public class P_Main_34 {
    public static void main(String[] args) {
        Worker ivan = new Worker();
        ivan.setName("Иван");
        ivan.setAge(25);
        ivan.setSalary(1000);

        Worker vasya = new Worker();
        vasya.setName("Вася");
        vasya.setAge(26);
        vasya.setSalary(2000);

        double totalSalary = ivan.getSalary() + vasya.getSalary();
        System.out.println("Сумма зарплат Ивана и Васи: " + totalSalary);

        Student student = new Student();
        student.setName("Петр");
        student.setAge(20);
        student.setStipend(500);
        student.setCourse(2);

        System.out.println("Студент: " + student.getName() + ", возраст: " + student.getAge() +
                ", стипендия: " + student.getStipend() + ", курс: " + student.getCourse());
    }
}
