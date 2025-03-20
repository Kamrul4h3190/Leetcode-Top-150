import java.util.Arrays;

public class DummyClass1 {
    public static void main(String[] args) {

        String s = "PAYPALISHIRING";int numRows =4;
        String output = convert(s,numRows);
        System.out.println("output :"+output);
    }
    public static String convert(String s, int numRows) {
        if (numRows ==1 || numRows>= s.length()) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {rows[i] = new StringBuilder();}

        boolean goingDown = false;
        int currRow = 0;
        for (char c : s.toCharArray()) {
            rows[currRow].append(c);
            if (currRow == 0 || currRow == numRows-1) goingDown =!goingDown;
            currRow += goingDown ? 1 : -1;
        }

        StringBuilder converted = new StringBuilder();
        for (StringBuilder row : rows) {converted.append(row);}
        return converted.toString();
    }
}
