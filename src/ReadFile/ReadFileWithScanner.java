package ReadFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadFileWithScanner {
    public static void main(String[] args) throws FileNotFoundException {
        String url = "D:\\input2.txt";
        int totalWords = 0;
        try {
            FileInputStream fileInputStream = new FileInputStream(url);
            Scanner scanner = new Scanner(fileInputStream);
            StringBuilder content = new StringBuilder();

            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine()).append("\n");
            }
            scanner.close();
            fileInputStream.close();

            String[] lines = content.toString().split("\n");

            int totalLines = lines.length;

            int numOfParts = 10;

            int linesPerPart = totalLines / numOfParts;
            int extraLines = totalLines % numOfParts;

            int start = 0;
            System.out.printf("%-10s%-10s%-10s%-10s%n", "STT", "Lines", "Chars", "Words");

            for (int i = 0; i < numOfParts; i++) {
                int end = start + linesPerPart;
                if (i < extraLines) {
                    end++;
                }
                StringBuilder part = new StringBuilder();
                for (int j = start; j < end; j++) {
                    part.append(lines[j]).append("\n");
                }

                int wordCount = part.toString().split("\\s+").length;
                totalWords += wordCount;
                System.out.printf("%-10d%-10d%-10d%-10d%n",
                                 (i+1),
                                 (end - start),
                                 part.length(),
                                wordCount);

                start = end;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("Total words: " + totalWords);
    }
}
