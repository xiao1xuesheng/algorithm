package technologies.trycatch;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {

    public static void main(String[] args) {

        try (
                // 第二个参数 true 表示追加写入
                FileWriter fileWriter =  new FileWriter("com.hejinggang/src/main/resources/example.txt", true);
                BufferedWriter bw = new BufferedWriter(fileWriter);
                ) {
            bw.write("Hello, World!");
            bw.newLine(); // 换行
            bw.write("This is a file writer example.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
