package com.company.monthmath.models;

import java.util.Objects;

public class Month {
    private int number;
    private String name;

    private int id;

    public Month() {}
    public Month(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public Month(int number, String name, int id) {
        this.number = number;
        this.name = name;
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Month{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Month month = (Month) o;
        return number == month.number && id == month.id && Objects.equals(name, month.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, id);
    }
}
