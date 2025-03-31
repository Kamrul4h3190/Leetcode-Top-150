import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DummyClass1 {
    public static void main(String[] args) {
//        String[] words = {"This", "is", "an", "example", "of", "text", "justification.",};int maxWidth = 16;
//        String[] words = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};int maxWidth = 20;
//        String[] words = {"What","must","be","acknowledgment","shall","be"};int maxWidth = 16;
        String[] words = {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};int maxWidth = 16;
//        String[] words = {"Listen","to","many,","speak","to","a","few."};int maxWidth = 6;
        List<String> lines = fullJustify(words,maxWidth);
        System.out.println(lines);
//        String justifiedLine = lineJustify(words,0,3,8,maxWidth);
//        String justifiedLine = lineJustify(words,0,3,8,maxWidth);
//        System.out.println(justifiedLine);
//        System.out.println("len:"+justifiedLine.length());
    }
    public static List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> lines = new ArrayList<>();
        int n = words.length,left=0,right=0,lineLength=0,charCount=0;
        while (right<n){
            if (lineLength==0 && words[right].length()==maxWidth){
                lines.add(words[right]);
                left++;
            }
            else if (lineLength+words[right].length()>=maxWidth){
                String line = lineJustify(words,left,right,charCount,maxWidth);
                lines.add(line);
                lineLength=0;charCount=0;

                left=right;continue;
            } else if (lineLength<maxWidth && right==n-1) {
                StringBuilder line = new StringBuilder();
                while (left<=right){
                    line.append(words[left]);if (left!=right) line.append(" ");
                    left++;}
                if (line.length()<maxWidth)line.append(" ".repeat(maxWidth-line.length()));
                System.out.println("len:"+line.length());
                lines.add(line.toString());
            } else {
                charCount+=words[right].length();
                lineLength+=words[right].length();
                if (right-left>0)lineLength++;
            }
            right++;
        }

        return lines;
    }

public static String lineJustify(String[] words,int left, int right,int charCount,int maxWidth){
    StringBuilder line = new StringBuilder();

    int spaceBlocks = right-left-1,spaceCount=maxWidth-charCount;
    int normalSpace = spaceBlocks==0? 0: spaceCount/spaceBlocks;
    int extraSpace = spaceBlocks==0? 0: spaceCount%spaceBlocks;

    for (int i = left; i < right; i++) {
        line.append(words[i]);
        if (extraSpace==0 && normalSpace>0 && i!=right-1){
            line.append(" ".repeat(normalSpace));
        } else if (extraSpace>0 && normalSpace>0 && i!=right-1) {
            line.append(" ".repeat(normalSpace));
            line.append(" ");
            extraSpace--;
        }
    }
    if (line.length()<maxWidth)line.append(" ".repeat(maxWidth-line.length()));
    System.out.println("len:"+line.length());
    return line.toString();
    }
}

