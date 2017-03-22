package ru.kpfu.itis.model;

/**
 * Created by Elina on 22.03.2017.
 */

public class Operation {

    private String first;
    private String second;
    private  String operand;

    public Operation(String first, String second, String operand){

        this.first = first;
        this.second = second;
        this.operand = operand;

    }

    public Operation(){}
    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }

    public String getOperand() {
        return operand;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public void setOperand(String operand) {
        this.operand = operand;
    }
}
