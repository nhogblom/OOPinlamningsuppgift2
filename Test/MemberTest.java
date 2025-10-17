import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {
    Member m1 = new Member("Niklas","Borrvägen","9000001234","nhogblom@gmail.com", LocalDate.parse("2020-05-20"),LocalDate.parse("2025-05-20"),memberType.PLATINA);
    Member m2 = new Member("Niklas","Borrvägen","9000001234","nhogblom@gmail.com", LocalDate.parse("2020-05-20"),LocalDate.parse("2022-05-20"),memberType.PLATINA);
    Member m3 = new Member("Niklas","Borrvägen","9000001234","nhogblom@gmail.com", LocalDate.parse("2020-05-20"),LocalDate.parse("2020-05-20"),memberType.PLATINA);
    Member m4 = new Member("Niklas","Borrvägen","9000001234","nhogblom@gmail.com", LocalDate.parse("2020-05-20"),LocalDate.parse("2020-05-20"),memberType.PLATINA);

    @Test
    void InfoToReceptionistTest() {
        String expected = "Niklas är en betalande Platina medlem.";
        String expected2 = "Niklas är en betalande Platina medlem.";
        String expected3 = "Niklas är en betalande Platina medlem.";
        String expected4 = "Niklas är en betalande Platina medlem.";

        assertEquals(expected,m1.InfoToReceptionist());

    }

    @Test
    void membershipValid() {
        assertTrue(m1.membershipValid());
        assertFalse(m2.membershipValid());
    }
}