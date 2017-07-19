package Selenium.logging;

import Selenium.TestAct.Sampler;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static Selenium.variablesNadzor.documentWay;

/**
 * Created by noise on 14.06.17.
 */
public class saveDocument {

    public static void saveActNumber() {

        int numberLines = 1;

        try {
            FileWriter writer = new FileWriter(documentWay, true);
            Scanner scanner = new Scanner(new File(documentWay));
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                numberLines++;
            }

            writer.write(numberLines + ") " + Sampler.ackNumber + " " + new SimpleDateFormat("dd.MM.yyyy").format(new Date()) + "\n");
            writer.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
