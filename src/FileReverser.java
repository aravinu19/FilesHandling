import java.io.*;

public class FileReverser {

    private void readFile(){

        try {

            BufferedReader reader = new BufferedReader(new FileReader("book.txt"));
            PrintWriter writer = new PrintWriter(new FileWriter("reader_output.txt"));
            String readFromFile = "";
            String writeToFile = "";

            while ((readFromFile = reader.readLine()) != null){
                writeToFile = reverseWord(readFromFile);
                writer.write(writeToFile);
                writer.write("\n");
            }

            reader.close();
            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO Exection Occured ");
        }

    }

    private String reverseWord(String fileLine){

        int len = fileLine.length();
        String reversed = "";

        for (int i = 0; i < len; i++){
            char element = fileLine.charAt(len - i - 1);
            reversed += element;
        }

        return reversed;

    }

    public static void main(String ivara[]){
        FileReverser reverser = new FileReverser();
        reverser.readFile();
        System.out.println("Thank you for using file reverser by ivara");
    }

}
