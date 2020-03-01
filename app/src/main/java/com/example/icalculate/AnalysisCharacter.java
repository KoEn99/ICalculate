package com.example.icalculate;

public class AnalysisCharacter {
    public static StackAction stackAction = new StackAction();
    private static Calculate calculate = new Calculate();
    public static String expressionValue = "";
    public static String isLeftBracket = "";
    public static int countBracketRight = 0;
    public static int countValueInBracket = 0;
    public static int countMinusOutsideBracket = 0;
    public void detectCharacter(String expression){
        if ((   expression.indexOf("+") *
                expression.indexOf("-") *
                expression.indexOf("x") *
                expression.indexOf("/")) *
                expression.indexOf("(") *
                expression.indexOf(")") * -1
                != -1) {
            isLeftBracket = expression;
            if (!isLeftBracket.equals("(")) higherOrderCheck();
            else countBracketRight++;
            if (!expressionValue.equals("")) {
                stackAction.stackToValue(expressionValue);
                if (countBracketRight > 0) countValueInBracket++;
                expressionValue = "";
                nevegateCharacter();
            }
                if (!stackAction.getOperatorStack().empty()) if (isLeftBracket.equals("(") && stackAction.getOperatorStack().peek().equals("-")) countMinusOutsideBracket++;
                if (!expression.equals(")")) stackAction.stackToOperator(expression);
        }
        else {
            expressionValue += expression;
        }
    }
    public static void higherOrderCheck() {
        if (stackAction.getOperatorStack().size() != 0) {
            if (stackAction.getOperatorStack().peek().equals("x") ||
                    stackAction.getOperatorStack().peek().equals("/")) {
                stackAction.stackToValue(calculate.calculateHigherOrderOperator());
            }
            if (!stackAction.getOperatorStack().empty()) if (!stackAction.getOperatorStack().peek().equals("(") && isLeftBracket.equals(")") && !stackAction.getOperatorStack().peek().equals("-")){
                calculate.calculateAllBracket();
                isLeftBracket = "";
            }
            if ((stackAction.getOperatorStack().size() != 0) && stackAction.getOperatorStack().peek().equals("-")) {
                nevegateCharacter();
                if ( AnalysisCharacter.countMinusOutsideBracket>0) AnalysisCharacter.countMinusOutsideBracket --;
            }
        }
    }
    public static void nevegateCharacter(){
        if (stackAction.getOperatorStack().size() != 0){
            if (stackAction.getOperatorStack().peek().equals("-") && expressionValue.equals("")) {
                stackAction.getOperatorStack().pop();
                stackAction.stackToOperator("+");
                double translateMinus = Double.parseDouble(stackAction.getValueStack().pop()) * (-1);
                stackAction.stackToValue(String.valueOf(translateMinus));
                if (isLeftBracket.equals(")")) {
                    higherOrderCheck();
                }
            }
        }
    }

}
