//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Scanner;

import java.io.*;

public class SubtitlesParse {

    static String trimTrim(String trimLine) {
        trimLine = trimLine
                // GENERAL CORRECTIONS
                // grammar
                .replace(" i ", " I ")
                .replace("i'm", "I'm")
                .replace(" um ", " ")
                .replace(" uh ", " ")

                // academia
                .replace(" dr ", " Dr. ")
                .replace("professor", "Professor")
                .replace("institute", "Institute")
                .replace("free university", "Free University")
                .replace("university", "University")

                // DH-specific
                .replace("nyu", "NYU")
                .replace("deutsche's house", "Deutsches Haus")
                .replace("deutsch's house", "Deutsches Haus")
                .replace("deutsche house", "Deutsches Haus")
                .replace("deutsche south", "Deutsches Haus")
                .replace("deutsches", "Deutsches")
                .replace("deutsches house", "Deutsches Haus")
                // DH-specific names
                .replace("juliana", "Juliane")
                .replace("yuliana", "Juliane")
                .replace("julianna", "Juliane")
                .replace("julian", "Juliane")
                .replace("camfield", "Camfield")
                .replace("sarah", "Sarah")
                .replace("zara", "Sarah")
                .replace("christian", "Christian")
                .replace("mendonza", "Mendonça")
                .replace("sasha", "Sasha")

                // relevant geographic locations
                .replace("germany", "Germany")
                .replace("german", "German")
                .replace("european", "European")
                .replace("europe", "Europe")
                .replace("berlin", "Berlin")
                .replace("nazi", "Nazi")

                .replace("new york", "New York")
                .replace("american", "American")
                .replace("america", "America")
                .replace("united states", "United States")

                // months
                .replace("january", "January")
                .replace("february", "February")
                .replace("march", "March")
                .replace("april", "April")
                .replace("may", "May")
                .replace("june", "June")
                .replace("july", "July")
                .replace("august", "August")
                .replace("september", "September")
                .replace("october", "October")
                .replace("november", "November")
                .replace("december", "December")

                // video-specific (delete when working on other videos)

                // Margret and Volkmar
                .replace("margaret", "Margret")
                .replace(" mark ", " Margret ")
                .replace("folkman", "Volkmar")
                .replace("folkmart", "Volkmar")
                .replace("folkmar", "Volkmar")
                .replace("zander", "Sander")
                .replace("sandler", "Sander")
                .replace("zumba", "Sander")
                .replace("sander", "Sander")

                // other names
                .replace("heinz", "Heinz")
                .replace("franz", "Heinz")
                .replace("igstad", "Ickstadt")
                .replace("ixted", "Ickstadt")
                .replace("ighstant", "Ickstadt")
                .replace("igstart's", "Ickstadt")
                .replace("igstart", "Ickstadt")
                .replace("eikstein", "Ickstadt")
                .replace("andrew", "Andrew")
                .replace("cross", "Gross")
                .replace("gross", "Gross")
                .replace("kennedy", "Kennedy")
                .replace("susan", "Susan")
                .replace("zuzana", "Susan")
                .replace("neiman", "Neiman")
                .replace("marty", "Marty")
                .replace("ruderschen", "Reutershan")
                .replace("joan", "Joan")
                .replace("doris", "Doris")

                // things video mentions
                .replace("trump", "Trump")
        ;
        return trimLine;
    }

    public static void main(String[] args) throws FileNotFoundException {
        // The name of the file to open.
        String fileName = "captions.vtt";
        String outputFile = "edited_subtitles.vtt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            BufferedReader reader = new BufferedReader(fileReader);
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            while((line = reader.readLine()) != null) {

                String trimLine = line.trim();

                writer.write(trimTrim(trimLine) + System.getProperty("line.separator"));
            }

            System.out.println("Conversion done!");

            // Always close files.
            reader.close();
            writer.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
        }

    }
}
