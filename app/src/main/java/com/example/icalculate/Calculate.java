package com.example.icalculate;

import android.graphics.Paint;

public class Calculate {
    StackAction stackAction;
    public Calculate(){
        this.stackAction = AnalysisCharacter.stackAction;
    }
    public String calculateHigherOrderOperator(){
        String str = "";
        double results = 0;
        addLatsValue();
        switch (stackAction.getOperatorStack().pop()){
            case "x":{
                str = String.valueOf(multiplyNumbers());
                break;
            }
            case "/":{
                str = String.valueOf(divisionNumbers());
                break;
            }
        }
        return str;
    }
    public void calculateAllBracket(){
        String str = "";
        double results = 0;
        addLatsValue();
            if ((stackAction.getOperatorStack().size() - AnalysisCharacter.countBracketRight - AnalysisCharacter.countMinusOutsideBracket) >= stackAction.getValueStack().size()) stackAction.getOperatorStack().pop();
            while (!stackAction.getOperatorStack().peek().equals("(")) {
                if (!stackAction.getOperatorStack().empty()) {
                    switch (stackAction.getOperatorStack().pop()) {
                        case "x": {
                            str = String.valueOf(multiplyNumbers());
                            stackAction.stackToValue(str);
                            break;
                        }
                        case "/": {
                            str = String.valueOf(divisionNumbers());
                            stackAction.stackToValue(str);
                            break;
                        }
                        case "+": {
                            str = String.valueOf(addingNumbers());
                            stackAction.stackToValue(str);
                            break;
                        }
                    }
                } else break;
            }
        if (!stackAction.getOperatorStack().empty()) stackAction.removeBracket();
    }
    public String recivedResults(){
        String str = "";

        if (!AnalysisCharacter.expressionValue.equals("")) {
            stackAction.stackToValue(AnalysisCharacter.expressionValue);
            AnalysisCharacter.expressionValue = "";
            AnalysisCharacter.nevegateCharacter();
            AnalysisCharacter.higherOrderCheck();
        }
        try{
            if (stackAction.getValueStack().size() == 1 && stackAction.getOperatorStack().size() >= 0) return str = stackAction.getValueStack().peek();
             while (stackAction.getValueStack().size() > 1) {
                switch (stackAction.getOperatorStack().pop()) {
                    case "+": {
                        str = String.valueOf(addingNumbers());
                        stackAction.stackToValue(str);
                        break;
                    }
                    case "x":{
                        str = String.valueOf(multiplyNumbers());
                        stackAction.stackToValue(str);
                        break;
                    }
                    case "/": {
                        str = String.valueOf(divisionNumbers());
                        stackAction.stackToValue(str);
                        break;
                    }
                    case "(":{
                        break;
                    }
                }

            }
            if ( AnalysisCharacter.countMinusOutsideBracket>0) AnalysisCharacter.countMinusOutsideBracket = 0;
        }
        catch (Exception ex){
            str = "Ошибка";
        }
        return stackAction.getValueStack().peek();
    }
    private double addingNumbers(){
        double results = 0;
        double value = 0;
        double two = 0;
        try {
            value = Double.parseDouble(stackAction.getValueStack().pop());
            two = Double.parseDouble(stackAction.getValueStack().pop());
            results = two + value;
            //stackAction.stackToValue(String.valueOf(results));
            if (AnalysisCharacter.countValueInBracket != 0) AnalysisCharacter.countValueInBracket--;
        }
        catch (Exception ex){

        }
        return results;
    }
    private double multiplyNumbers(){
        double results = 0;
        try {

            double value = Double.parseDouble(stackAction.getValueStack().pop());
            double two = Double.parseDouble(stackAction.getValueStack().pop());
            results = two * value;
           // stackAction.stackToValue(String.valueOf(results));
            if (AnalysisCharacter.countValueInBracket != 0) AnalysisCharacter.countValueInBracket--;
        }
        catch (Exception ex){

        }
        return results;
    }
    private double divisionNumbers(){
        double results = 0;
        try {
            double value = Double.parseDouble(stackAction.getValueStack().pop());
            double two = Double.parseDouble(stackAction.getValueStack().pop());
            results = two / value;
         //   stackAction.stackToValue(String.valueOf(results));
            if (AnalysisCharacter.countValueInBracket != 0) AnalysisCharacter.countValueInBracket--;
        }
        catch (Exception ex){

        }
        return results;
    }
    private void addLatsValue(){
        if (!AnalysisCharacter.expressionValue.equals("")) {
            stackAction.stackToValue(AnalysisCharacter.expressionValue);
            AnalysisCharacter.expressionValue = "";
        }
    }
}
