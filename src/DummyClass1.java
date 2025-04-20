import java.util.*;

import static java.lang.Integer.compare;

public class DummyClass1 {
    public static void main(String[] args) {
//        String path = "/home///user/./desktop/../movies";
//        String path = "/home///foo";
        String path = "/.../a/../b/c/../d/./";
        System.out.println("simple path : "+simplifyPath(path));
    }
    public static String simplifyPath(String path) {
        String[] directories = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String directory : directories) {
            if (!directory.isEmpty() && !directory.equals(".") && !directory.equals(".."))
                stack.push(directory);
            else if (!stack.isEmpty() && directory.equals(".."))
                stack.pop();
        }
        StringBuilder simplePath = new StringBuilder();
        for (String directory : stack) simplePath.append("/").append(directory);

        return simplePath.isEmpty() ? "/":simplePath.toString();
    }

}