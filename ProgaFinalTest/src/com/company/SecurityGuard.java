package com.company;

import java.util.Objects;

public class SecurityGuard extends Employee {
    private String guardedObject;

    public SecurityGuard( String name, Positions position, int salary, String pathToIcon, String guardedObject ) {
        super(name, position, salary, pathToIcon);
        this.guardedObject = guardedObject;
    }

    public String getGuardedObject() {
        return guardedObject;
    }

    @Override
    public boolean equals( Object o ) {
        if (this == o) return true;
        if (!( o instanceof SecurityGuard )) return false;
        if (!super.equals(o)) return false;
        SecurityGuard that = (SecurityGuard) o;
        return Objects.equals(getGuardedObject(), that.getGuardedObject());
    }

    public void setGuardedObject( String guardedObject ) {
        this.guardedObject = guardedObject;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getGuardedObject());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SecurityGuard{");
        sb.append(super.toString());
        sb.append(", guardedObject='").append(guardedObject).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
