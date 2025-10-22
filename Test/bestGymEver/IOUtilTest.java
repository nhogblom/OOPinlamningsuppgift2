package bestGymEver;

import bestGymEver.member.Member;
import bestGymEver.member.MemberType;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class IOUtilTest {
    IOUtil ioUtil = new IOUtil();


    // stöd metod till writeToFileTest
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


    @Test
    void writeToFileTest() throws IOException {
        Path pathOfTestFile = Path.of("testResources/writeTest.txt");

        //  time stamp till expected
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime ldt = LocalDateTime.now();
        String dt = ldt.format(formatter);

        String expected = "Det här skrev jag ner till fil precis! Och klockan var " + dt;
        String unexpected = "Det var inte det här jag skrev ner.";
        // skriv till fil
        ioUtil.writeToFile(pathOfTestFile,expected,true);
        //jämför
        String actual = readLastLineFromFile(pathOfTestFile);

        assertEquals(expected,actual);
        assertNotEquals(unexpected,actual);
    }

    // stöd metod till readFromFileTest
    public String stringListToString(List<String> listOfStringToReturn) {
        return listOfStringToReturn.toString();
    }

    @Test
    void readFromFileTest() throws IOException {
        Path pathOfTestFile = Path.of("testResources/readTest.txt");
        Path brokenPath = Path.of("asdmasj");

        String expected = "[Det, här, är, bara, ett, test!]";
        String unexpected = "Något annat";
        String actual = stringListToString(ioUtil.readFromFile(pathOfTestFile));

        assertEquals(expected,actual);
        assertNotEquals(unexpected,actual);
        assertThrows(FileNotFoundException.class, () -> ioUtil.readFromFile(brokenPath));
        assertThrows(IOException.class, () -> ioUtil.readFromFile(brokenPath));
    }

    @Test
    void collectStringFromTerminalTest(){
        IOUtil ioUtil = new IOUtil(true);

        String expected = "Hejsan hur mår du?";
        String unexpected = "Dra åt skogen!";
        String actual = ioUtil.collectStringFromTerminal("här behöver det egentligen inte stå någonting",new Scanner("Inte här heller"));

        assertEquals (expected,actual);
        assertNotEquals(unexpected,actual);
    }
}
