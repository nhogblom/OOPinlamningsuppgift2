import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class RecoverTool {
    List<Members> membersList = new ArrayList<>();

    @Test
    void readMembersFromFileTest(){
        String exampleRecoveryFileTextForTwoUsers = "Namn;Adress;Mailadress;Personnummer;Datum_köpt_gymmedlemskap;Datum_senast_uppdaterad;Medlemsnivå\n" +
                "Fredrik Berggren;Skolgränd 8, 16819 Norrköping;fredde@fakemail.se;851020-6728;2019-12-30;2021-12-30;Platina\n" +
                "Astrid Larsson;Järnvägsvägen 5, 64230 Gävle;asta@fakemail.de;540815-4382;2021-12-04;2022-12-04;Platina";
        Scanner sc = new Scanner(exampleRecoveryFileTextForTwoUsers);

        RecoverFromFile.readMembersFromFileToList(sc,membersList);

        assertEquals(2,membersList.size());
        assertNotEquals(1,membersList.size());
        assertNotEquals(3,membersList.size());

    }

}