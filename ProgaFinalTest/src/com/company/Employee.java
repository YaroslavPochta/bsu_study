package com.company;

import java.util.Objects;

public class Employee  implements Comparable<Employee>{
    private String name;
    private Positions position;
    private int salary;
    private String pathToIcon;

    public Employee() {
    }

    public Employee( String name, Positions position, int salary, String pathToIcon ) {
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.pathToIcon = pathToIcon;
    }

    @Override
    public boolean equals( Object o ) {
        if (this == o) return true;
        if (!( o instanceof Employee )) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getName(), employee.getName()) &&
                getPosition() == employee.getPosition() &&
                Objects.equals(getSalary(), employee.getSalary()) &&
                Objects.equals(getPathToIcon(), employee.getPathToIcon());
    }

    @Override
    public int compareTo( Employee o ) {
        if (this.position.equals(o.position)) {
            if (this.name.equals(o.name)) {
                return -(this.salary - o.salary);
            } else return this.name.compareTo(o.name);
        }
        return this.position.compareTo(o.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPosition(), getSalary(), getPathToIcon());
    }

    public Positions getPosition() {
        return position;
    }

    public String getPathToIcon() {
        return pathToIcon;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary( Integer salary ) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("name='").append(name).append('\'');
        sb.append(", position=").append(position);
        sb.append(", salary=").append(salary);
        sb.append(", pathToIcon=").append(pathToIcon);
        sb.append('}');
        return sb.toString();
    }
}
