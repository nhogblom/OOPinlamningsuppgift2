package bestGymEver.member;

import bestGymEver.IOUtil;
import bestGymEver.MemberType;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;

public class IOUtilTest {
    Member m1 = new Member("Niklas", "Borrvägen", "9000001234", "nhogblom@gmail.com", LocalDate.parse("2020-05-20"), LocalDate.parse("2025-05-20"), MemberType.PLATINA,true);
    IOUtil ioUtil = new IOUtil();

    @Test
    void writeToFileTest() throws IOException {

        Path pathOfTestFile = Path.of("testResources/writeTest.txt");


        String expected = "Det här skrev jag ner till fil precis";
        ioUtil.writeToFile(pathOfTestFile,expected);
        String actual = ioUtil.readLastLineFromFile(pathOfTestFile);


    }
}
