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

        Stack<Character> charStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (currentChar == '{' || currentChar == '(' || currentChar == '[') {
                charStack.push(currentChar);
            }

            if (currentChar == '}' || currentChar == ')' || currentChar == ']') {
                if (charStack.isEmpty()) {
                    return false;
                }

                char lastChar = charStack.peek();
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
