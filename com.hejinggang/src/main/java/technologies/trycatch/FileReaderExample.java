package technologies.trycatch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {

    public static void main(String[] args) {
        // 标准做法：从 resources 目录读取文件
        // 文件放在 src/main/resources/example.txt
        try (
//                BufferedReader bufferedReader = new BufferedReader(
//                    new InputStreamReader(
//                            Objects.requireNonNull(FileReaderExample.class.getClassLoader().getResourceAsStream("example.txt"))
//                    )
//                );
                // Java中的相对路径是相对于项目根目录的，所以要使用"com.hejinggang/src/main/resources/example.txt"项目的顶级路径开始
                FileReader fileReader = new FileReader("com.hejinggang/src/main/resources/example.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                ) {
            String line;
            System.out.println("Reading file from resources:");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
