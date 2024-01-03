import com.services.BruteForce;
import com.util.FileUtil;

import java.io.IOException;
import java.util.Scanner;

import static com.services.Decryption.decryptData;
import static com.services.Encryption.encryptData;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите цифру, соответствующую действию:\n1)Encryption\n2)Decryption\n3)Brute force");

        int action = Integer.parseInt(sc.nextLine());
        System.out.println("Введите название файла: ");
        String currentFileName = sc.nextLine();
        FileUtil currentFile = new FileUtil("files/" + currentFileName);
        String inputString = currentFile.getFileContent();


        switch (action) {
            case (1):
                System.out.println("Введите число: ");
                int encryptKey = Integer.parseInt(sc.nextLine());
                String encryptString = encryptData(inputString, encryptKey);
                currentFile.writeFile(encryptString);
                break;
            case (2):
                System.out.println("Введите число: ");
                int decryptKey = Integer.parseInt(sc.nextLine());
                String decryptString = decryptData(inputString, decryptKey);
                currentFile.writeFile(decryptString);
                break;
            case (3):
                BruteForce bruteForce = new BruteForce();
                bruteForce.runBruteForce(inputString);
                break;
            default:
                System.out.println("Введите число от 1 до 3");
                break;
        }
        sc.close();
    }
}