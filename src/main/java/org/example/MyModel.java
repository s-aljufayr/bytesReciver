package org.example;

public class MyModel {
    private int num;
    private double num2;
    private String name;
    private boolean status;

    public MyModel(int num, double num2, String name, boolean status) {
        this.num = num;
        this.num2 = num2;
        this.name = name;
        this.status = status;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MyModel{" +
                "num=" + num +
                ", num2=" + num2 +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
