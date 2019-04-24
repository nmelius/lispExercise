import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(checkBalance("()"));
        System.out.println(checkBalance("(}"));
        System.out.println(checkBalance("{Abcd}"));
        System.out.println(checkBalance("(){}[]"));
        System.out.println(checkBalance("]["));
        System.out.println(checkBalance("({{()}})"));
    }

    public static boolean checkBalance(String str)
    {
        if (str.isEmpty()) {
            return true;
        }

        //Stack to store characters
        Stack<Character> charStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            //Check for left Parenthesis
            if (currentChar == '{' || currentChar == '(' || currentChar == '[') {
                charStack.push(currentChar);
            }

            //Check for right Parenthesis
            if (currentChar == '}' || currentChar == ')' || currentChar == ']') {
                //False is stack is empty without left Parenthesis
                if (charStack.isEmpty()) {
                    return false;
                }

                //Check for last character
                char lastChar = charStack.peek();
                //If current character is right Parenthesis and last character is left Parenthesis, remove from stack
                if ((currentChar == '}' && lastChar == '{') || (currentChar == ')' && lastChar == '(') ||
                        (currentChar == ']' && lastChar == '[')) {
                    charStack.pop();
                }
                else {
                    return false;
                }
            }
        }
        return charStack.isEmpty();
    }
}
