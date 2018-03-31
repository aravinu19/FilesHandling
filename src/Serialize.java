import java.io.*;
import java.util.Scanner;
import java.util.UUID;

public class Serialize {

    public static void shipObject(BankAccount account){
        account.createAccount();
        String fileExtension = account.name + ".ser";
        try {
            File newFile = new File(fileExtension);
            FileOutputStream outputStream = new FileOutputStream(newFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(account);
            objectOutputStream.flush();
            objectOutputStream.close();
            outputStream.close();
            System.out.println("the object is in " + account.name + ".ser");
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
        } catch (IOException e) {
            System.out.println("IO EXCEPTION OCCURRED");
        }
    }

    public static void main(String[] ivara){
        BankAccount ba = new BankAccount();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in your name :");
        ba.name = scanner.nextLine();
        System.out.println("Type in your Email :");
        ba.email = scanner.nextLine();
        System.out.println("Type in your pin number :");
        ba.pin = scanner.nextInt();

        UUID uuid = UUID.randomUUID();
        ba.account = uuid.toString();

        shipObject(ba);
    }

}
