package bestGymEver.member;

import bestGymEver.InvalidInputParameterForMember;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    List<Member> membersList;
    MemberService mS = new MemberService();

    @BeforeEach
    void setUp() {
        membersList = null;
        mS = null;
    }


    @Test
    void readMembersFromFileTest() throws IOException, InvalidInputParameterForMember {
        mS = new MemberService();

        String testFilePath = "testResources/gym_medlemmar.txt";
        Path path = Path.of(testFilePath);
        String incorrectFilePath = "/something-random";
        Path incorrectPath = Path.of(incorrectFilePath);

        membersList = mS.readMembersFromFileToList(path);

        int actual = membersList.size();
        int expected = 2;
        int unexpected = 1;
        int anotherUnexpected = 3;


        assertEquals(expected, actual);
        assertNotEquals(unexpected, actual);
        assertNotEquals(anotherUnexpected, actual);
        assertDoesNotThrow(() -> {
            mS.readMembersFromFileToList(path);
        });
        assertThrows(FileNotFoundException.class, () -> {
            mS.readMembersFromFileToList(incorrectPath);
        });

    }

    @Test
    void createMemberFromStringArrayTest() throws InvalidInputParameterForMember {
        mS = new MemberService();

        String[] rawMemberData = {"Fredrik Berggren", "Skolgränd 8, 16819 Norrköping", "fredde@fakemail.se", "851020-6728", "2019-12-30", "2021-12-30", "Platina"};
        String[] rawMemberDataFaulty = {"Fredrik Berggren", "Skolgränd 8, 16819 Norrköping", "fredde@fakemail.se", "851020-6728", "2019-12-30", "2021-12-30korv", "Platina"};
        Member member = mS.createMemberFromStringArray(rawMemberData);
        String expectedMemberName = "Fredrik Berggren";
        String expectedMemberAdress = "Skolgränd 8, 16819 Norrköping";
        String unexpectedMemberAdress = "Skolgränd 9, 16819 Norrköping";
        String expectedMemberEmail = "fredde@fakemail.se";
        String unexpectedMemberEmail = "redde@fakemail.se";
        String expectedMemberCreationDate = "2019-12-30";
        String expectedMemberLastUpdatedDate = "2021-12-30";
        String expectedMemberPersonnummer = "851020-6728";
        String unexpectedMemberName = "Stefan Johansson";
        String unexpectedMemberPersonnummer = "890101-1234";

        assertEquals(expectedMemberName, member.getName());
        assertEquals(expectedMemberPersonnummer, member.getPersonnummer());
        assertNotEquals(unexpectedMemberName, member.getName());
        assertNotEquals(unexpectedMemberPersonnummer, member.getPersonnummer());

        assertEquals(expectedMemberAdress, member.getAdress());
        assertNotEquals(unexpectedMemberAdress, member.getAdress());

        assertEquals(expectedMemberEmail, member.getEmail());
        assertNotEquals(unexpectedMemberEmail, member.getEmail());

        assertEquals(LocalDate.parse(expectedMemberCreationDate), member.getDateOfBecomingMember());

        assertEquals(LocalDate.parse(expectedMemberLastUpdatedDate), member.getDateOfMostRecentMembershipRenewal());

        assertThrows(InvalidInputParameterForMember.class, () -> mS.createMemberFromStringArray(rawMemberDataFaulty));
        assertDoesNotThrow(() -> mS.createMemberFromStringArray(rawMemberData));

    }


    @Test
    void searchTest() {
        mS = new MemberService();

        Member m1 = new Member("Niklas", "Borrvägen", "9000001234", "nhogblom@gmail.com", LocalDate.parse("2020-05-20"), LocalDate.parse("2020-05-20"), MemberType.PLATINA);
        Member m2 = new Member("Albin", "Borrvägen", "1900000124", "nhogblom@gmail.com", LocalDate.parse("2020-05-20"), LocalDate.parse("2020-05-20"), MemberType.PLATINA);
        List<Member> members = new ArrayList<>();
        members.add(m1);
        members.add(m2);
        assertEquals(m1, mS.search("Niklas", members));
        assertEquals(m2, mS.search("Albin", members));
        assertNotEquals(m2, mS.search("Niklas", members));
        assertNotEquals(m1, mS.search("Albin", members));
        assertEquals(m1, mS.search("9000001234", members));
        assertEquals(m2, mS.search("1900000124", members));
        assertNotEquals(m1, mS.search("Ingen heter så här", members));
    }
}