package code;

import java.io.*;

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private Integer age;
    private Integer grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }

    public static void main(String[] args) {
        File file = new File("D://output.log");
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            Student student = new Student();
            student.setAge(10);
            student.setName("zhang");
            student.setGrade(3);
            objectOutputStream.writeObject(student);
            objectOutputStream.close();
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
            Student student1 = (Student)inputStream.readObject();
            System.out.println(student1);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
