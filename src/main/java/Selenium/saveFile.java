package Selenium;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import static Selenium.variablesNadzor.documentWay;

/**
 * Created by noise on 14.06.17.
 */
public class saveFile {

    public static void saveTest() {

        int numberLines = 1;

        try {
            FileWriter writer = new FileWriter(documentWay, true);
            Scanner scanner = new Scanner(new File(documentWay));
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                numberLines++;
            }

            writer.write(numberLines + ") " + Sampler.ackNumber+"\n");
            writer.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
