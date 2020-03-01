package com.example.icalculate;

import java.util.Stack;

public class StackAction {
    private Stack<String> valueStack = new Stack<>();
    private Stack<String> operatorStack = new Stack<>();
    public StackAction() {
    }

    public void stackToValue(String value) {
        valueStack.push(value);
    }

    public void stackToOperator(String operator) {
        operatorStack.push(operator);
    }

    public void CleaningStack(){
        if (!valueStack.empty()) valueStack.clear();
        if (!operatorStack.empty()) operatorStack.clear();
    }
    public void removeBracket(){
        if (operatorStack.peek().equals("(")){
            AnalysisCharacter.countBracketRight--;
            operatorStack.pop();
        }
    }
    public Boolean haveHighOrder(){
        if (operatorStack.search("x") != -1 || operatorStack.peek().equals("x") || operatorStack.search("/") != -1 || operatorStack.peek().equals("/")) {
            return true;
        }
        else return false;
    }

    public Stack<String> getValueStack() {
        return valueStack;
    }

    public Stack<String> getOperatorStack() {
        return operatorStack;
    }

    public void setValueStack(Stack<String> valueStack) {
        this.valueStack = valueStack;
    }

    public void setOperatorStack(Stack<String> operatorStack) {
        this.operatorStack = operatorStack;
    }
}
