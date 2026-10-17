
import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> mainStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= '0' && ch <= '9') {
                int num = 0;

                while (i < s.length() &&
                       s.charAt(i) >= '0' &&
                       s.charAt(i) <= '9') {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }

                i--;
                numberStack.push(num);

            } else if (ch != ']') {
                mainStack.push(String.valueOf(ch));

            } else {
                String str = "";

                while (!mainStack.peek().equals("[")) {
                    str = mainStack.pop() + str;
                }

                mainStack.pop();

                int repetitionNumber = numberStack.pop();
                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < repetitionNumber; j++) {
                    sb.append(str);
                }

                mainStack.push(sb.toString());
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!mainStack.isEmpty()) {
            ans.insert(0, mainStack.pop());
        }

        return ans.toString();
    }
}
