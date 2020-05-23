package lambdaInterface;

import java.math.BigDecimal;

public class Employee {

    private String username;
    private Integer age;
    private BigDecimal salary;

    public Employee(){}

    public static Integer getIntValue(){
        return 666;
    }

    public Double getDoubleValue(){
        return 66.6;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Employee(String username, Integer age, BigDecimal salary) {
        this.username = username;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
