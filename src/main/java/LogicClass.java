import org.json.JSONObject;

import java.io.*;
import java.util.Scanner;

public class LogicClass implements InterfaceClass {

    int wordCount = 1;
    @Override
    public void FileReaderMethod() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First File Address With File name and extension");
        String FirstFileAddress = sc.nextLine();
        File file1 = new File(FirstFileAddress);
        System.out.println("Enter second File Address With File name and extension");
        String SecondFileAddress = sc.nextLine();
        File file2 = new File(SecondFileAddress);
        FileReader r1 = new FileReader(file1);
        FileReader r2 = new FileReader(file2);
        BufferedReader reader1 = new BufferedReader(r1);
        BufferedReader reader2 = new BufferedReader(r2);
        String str1 = reader1.readLine();
        String str2 = reader2.readLine();
        char[] arr = str1.toCharArray();
        boolean areEqual = false;
        int LineCount = 1;
        while (str1 != null && str2 != null)
        {
            if (str1.equalsIgnoreCase(str2))
            {
                areEqual = true;
                LineCount++;
                for (int i = 0; i < arr.length; i++)
                {
                    if (arr[i] == ' ') {
                        wordCount++;
                    }
                }

            } else {
                areEqual = false;
                break;
            }
            str1 = reader1.readLine();
            str2 = reader2.readLine();
            wordCount++;
        }

        if (areEqual)
        {
            System.out.println("Both Files Content is same:");
            JsonFileMethod();

        } else {
            System.out.println("Both Files content is not same at Line Number "+LineCount);
        }

    }
    @Override
    public void JsonFileMethod() throws IOException {
        JSONObject obj = new JSONObject();
        FileWriter MyWriter = new FileWriter("my_json.json");
        MyWriter.write(String.valueOf(obj.put("Words"," No.Of words  "+wordCount)));
        System.out.println("Words"+" No.Of words "+wordCount+" is  Entered in Json File ");
        MyWriter.flush();
        MyWriter.close();
    }
}
