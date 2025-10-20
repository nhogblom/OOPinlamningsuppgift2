package BestGymEver;

import BestGymEver.Member.Member;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class RecoverFromFileTest {
    List<Member> membersList;

    @Test
    void createMemberFromFileDataTest() {
        String[] rawMemberData = {"Fredrik Berggren", "Skolgränd 8, 16819 Norrköping", "fredde@fakemail.se", "851020-6728", "2019-12-30", "2021-12-30","Platina"};
        Member member = RecoverFromFile.createMemberFromFileData(rawMemberData);
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

    }

    @Test
    void readMembersFromFileTest() {
        String exampleRecoveryFileTextForTwoUsers = "Namn;Adress;Mailadress;Personnummer;Datum_köpt_gymmedlemskap;Datum_senast_uppdaterad;Medlemsnivå\n" +
                "Fredrik Berggren;Skolgränd 8, 16819 Norrköping;fredde@fakemail.se;851020-6728;2019-12-30;2021-12-30;Platina\n" +
                "Astrid Larsson;Järnvägsvägen 5, 64230 Gävle;asta@fakemail.de;540815-4382;2021-12-04;2022-12-04;Platina";
        Scanner sc = new Scanner(exampleRecoveryFileTextForTwoUsers);

        membersList = RecoverFromFile.readMembersFromFileToList(sc);

        assertEquals(2, membersList.size());
        assertNotEquals(1, membersList.size());
        assertNotEquals(3, membersList.size());

    }
}