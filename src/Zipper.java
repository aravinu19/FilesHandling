import java.io.*;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Zipper {

    public String file = "";

    public Zipper(String file) {
        this.file = file;
    }

    public void zip(){
        try {
            FileInputStream inputStream = new FileInputStream(file);
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream("new.zip"));
            ZipEntry zipEntry = new ZipEntry(file);
            zipOutputStream.putNextEntry(zipEntry);
            int i = 0;

            while ((i = inputStream.read()) != -1){
               zipOutputStream.write((byte) i);
               zipOutputStream.flush();
            }

            inputStream.close();
            zipOutputStream.closeEntry();
            zipOutputStream.close();

            System.out.format("The file %s was zipped.\n", file);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void unzip(){
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file));
            ZipEntry entry = zipInputStream.getNextEntry();
            file = entry.getName();
            File newFile = new File(file);
            FileOutputStream outputStream = new FileOutputStream(newFile);
            outputStream.flush();
            outputStream.close();
            zipInputStream.close();
            System.out.println(file + " unzipped.");

        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] ivara){
        System.out.println("Type in the name of file:");
        Scanner scanner = new Scanner(System.in);

        Zipper zipper = new Zipper(scanner.nextLine());
        System.out.println("Enter -z to zip a file or -u to unzip file.");
        String command = scanner.nextLine();

        if (command .contains("-z")){
            zipper.zip();
        }else if (command.contains("-u")){
            zipper.unzip();
        }else {
            System.out.println("Invalid Command");
        }

    }

}
