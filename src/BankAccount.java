import java.io.Serializable;

public class BankAccount implements Serializable {
    String name;
    String email;
    String account;
    int pin;

    public void createAccount(){
        System.out.format("Create an account number %s under the name %s with email: %s .\n", account, name, email);
    }

}
