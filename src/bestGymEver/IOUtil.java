package bestGymEver;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOUtil {
    private final boolean isTest;

    public IOUtil() {
        this.isTest = false;
    }

    public IOUtil(boolean isTest) {
        this.isTest = isTest;
    }

    public void writeToFile(Path path, String string,Boolean append) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path.toString(), append))) {
            pw.println(string);
            pw.flush();
        }
    }

    public List<String> readFromFile(Path path) throws IOException {
        List<String> listOfStringToReturn = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path.toString()))) {
            String line;
            while ((line = br.readLine()) != null) {
                listOfStringToReturn.add(line);
            }
        }
        return listOfStringToReturn;
    }

    public String collectStringFromTerminal(String prompt, Scanner sc) {
        String line = "";
        if (isTest) {
            sc = new Scanner("Hejsan hur mår du?");
        } else {
            System.out.println(prompt);
        }

        if (sc.hasNextLine()) {
            line = sc.nextLine().trim();
        }
        return line;
    }

}
