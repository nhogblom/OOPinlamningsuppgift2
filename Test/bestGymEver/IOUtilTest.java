package bestGymEver;

import bestGymEver.member.Member;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class IOUtilTest {
    Member m1 = new Member("Niklas", "Borrvägen", "9000001234", "nhogblom@gmail.com", LocalDate.parse("2020-05-20"), LocalDate.parse("2025-05-20"), MemberType.PLATINA,true);
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

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime ldt = LocalDateTime.now();
        String dt = ldt.format(formatter);

        String expected = "Det här skrev jag ner till fil precis! Och klockan var " + dt;
        String unexpected = "Det var inte det här jag skrev ner.";
        ioUtil.writeToFile(pathOfTestFile,expected);
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

        String expected = "[Det, här, är, bara, ett, test!]";
        String unexpected = "Något annat";
        String actual = stringListToString(ioUtil.readFromFile(pathOfTestFile));

        assertEquals(expected,actual);
        assertNotEquals(unexpected,actual);

    }
}
