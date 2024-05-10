import com.home.model.IPhone;

import java.util.Scanner;

public class Program {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        IPhone iphone1 = new IPhone("X");
        String userInput;

        System.out.println("Welcome to " + iphone1);
        System.out.println("Here you can");
        System.out.println(iphone1.getOptions());

        do {
            System.out.println("What you want to do?");
            userInput = scan.next();

            if(userInput.equals("0"))
                break;

            iphone1.activeOption(userInput);

        } while(true);
    }
}
