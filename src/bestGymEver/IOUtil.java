package bestGymEver;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class IOUtil
{

    public void writeToFile(Path path, String string) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path.toString(),true))){
            pw.println(string);
            pw.flush();
        }
    }
}
