package other;

import java.util.Stack;

/**
 * Created by Chenpi on 2017/8/10.
 */
public class Problem5Solution {
    public static int count = 0;
    public static int countSum = 0;

    public static void execute(int start, Stack<Integer> stack, int sum,
                               Stack<String> operate, final int N) {
        if (start == N) {
            if (sum == 100) {
                for (int i = 0; i < stack.size(); i++) {
                    System.out.print(stack.get(i));
                    if (i < operate.size()) {
                        System.out.print(" " + operate.get(i) + " ");
                    }
                }
                System.out.println(" = 100");
                count++;
            }
            countSum++;
            return;
        }
        int next = start + 1;
        // j=0代表两数之间相连，j=1代表加，j=2代表减；
        for (int j = 0; j < 3; j++) {
            if (j == 0) {
                int preInt = stack.pop();//前一个
                int current = preInt * 10 + next;
                stack.push(current);
                if (!operate.isEmpty() && operate.peek().equals("+")) {
                    sum = sum - preInt + current;
                } else if (!operate.isEmpty() && operate.peek().equals("-")) {
                    sum = sum + preInt - current;
                } else {
                    sum = sum - preInt + current;
                }
                execute(next, stack, sum, operate, N);
                // 现场还原
                int reback = stack.pop();
                int preBack = reback / 10;
                stack.push(preBack);
                if (!operate.isEmpty() && operate.peek().equals("+")) {
                    sum = sum - reback + preBack;
                } else if (!operate.isEmpty() && operate.peek().equals("-")) {
                    sum = sum + reback - preBack;
                } else {
                    sum = sum - reback + preBack;
                }
            } else if (j == 1) {
                sum = sum + next;
                operate.push("+");
                stack.push(next);
                execute(next, stack, sum, operate, N);
                operate.pop();
                int addNum = stack.pop();
                sum = sum - addNum;
            } else if (j == 2) {
                sum = sum - next;
                operate.push("-");
                stack.push(next);
                execute(next, stack, sum, operate, N);
                operate.pop();
                int decNum = stack.pop();
                sum = sum + decNum;
            }
        }
    }
}
