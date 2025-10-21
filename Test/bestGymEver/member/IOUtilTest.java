package bestGymEver.member;

import bestGymEver.IOUtil;
import bestGymEver.MemberType;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class IOUtilTest {
    Member m1 = new Member("Niklas", "Borrvägen", "9000001234", "nhogblom@gmail.com", LocalDate.parse("2020-05-20"), LocalDate.parse("2025-05-20"), MemberType.PLATINA,true);
    IOUtil ioUtil = new IOUtil();

    @Test
    void writeToFileTest() throws IOException {

        Path pathOfTestFile = Path.of("testResources/writeTest.txt");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime ldt = LocalDateTime.now();
        String dt = ldt.format(formatter);

        String expected = "Det här skrev jag ner till fil precis! Och klockan var " + dt;
        String unexpected = "Det var inte det här jag skrev ner.";
        ioUtil.writeToFile(pathOfTestFile,expected);
        String actual = ioUtil.readLastLineFromFile(pathOfTestFile);

        assertEquals(expected,actual);
        assertNotEquals(unexpected,actual);

    }
}
