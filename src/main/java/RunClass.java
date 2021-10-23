import java.io.IOException;
import java.util.Scanner;

class RunClass
{
    public void Start() throws IOException {
        Scanner sc = new Scanner(System.in);
        LogicClass logicClass = new LogicClass();
        System.out.println("Please Enter key 1 :");
        System.out.println("To Compare two files content");
        int number = sc.nextInt();
        switch (number)
        {
            case 1:
                logicClass.FileReaderMethod();
                break;
            default:
                System.out.println("invalid key  :");
                Start();
        }


    }

}
