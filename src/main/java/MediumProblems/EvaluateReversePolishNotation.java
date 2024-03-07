package MediumProblems;

import java.util.Stack;

public class EvaluateReversePolishNotation {

  public static void main(String[] args) {
    //        String[] tokens = {"2", "1", "+", "3", "*"};
    //        String[] tokens = {"4","13","5","/","+"};
    //        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
    String[] tokens = {"4", "-2", "/", "2", "-3", "-", "-"};
    System.out.println(evalRPN(tokens));
  }

  public static int evalRPN(String[] tokens) {
    Integer result = null;
    Stack<Integer> tokenStack = new Stack<>();

    for (int i = 0; i < tokens.length; i++) {
      if ("+".equals(tokens[i])) {
        result = tokenStack.pop() + tokenStack.pop();
      } else if ("*".equals(tokens[i])) {
        result = tokenStack.pop() * tokenStack.pop();
      } else if ("-".equals(tokens[i])) {
        int firstNum = tokenStack.pop();
        int secondNum = tokenStack.pop();
        result = secondNum - firstNum;
      } else if ("/".equals(tokens[i])) {
        int firstNum = tokenStack.pop();
        int secondNum = tokenStack.pop();
        result = secondNum / firstNum;
      } else {
        tokenStack.push(Integer.valueOf(tokens[i]));
        continue;
      }
      tokenStack.push(result);
    }
    return tokenStack.peek();
  }
}
