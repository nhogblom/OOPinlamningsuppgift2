package bestGymEver;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IOUtil {

    public void writeToFile(Path path, String string) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path.toString(), true))) {
            pw.println(string);
            pw.flush();
        }
    }

    public String readLastLineFromFile(Path path) throws IOException {
        String stringToReturn = "";
        try (BufferedReader br = new BufferedReader(new FileReader(path.toString()))) {
            String line;
            while ((line = br.readLine()) != null) {
                stringToReturn = line;
            }
        }
        return stringToReturn;
    }

    public List<String> readFromFile(Path path) throws IOException {
        List<String> listOfStringToReturn = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path.toString()))){
            String line;
            while ((line = br.readLine()) != null){
                listOfStringToReturn.add(line);
            }
        }
        return listOfStringToReturn;
    }


}
