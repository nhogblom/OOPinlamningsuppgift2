package BestGymEver;

import BestGymEver.Member.Member;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {
    Member m1 = new Member("Niklas", "Borrvägen", "9000001234", "nhogblom@gmail.com", LocalDate.parse("2020-05-20"), LocalDate.parse("2025-05-20"), MemberType.PLATINA);
    Member m2 = new Member("Johan", "Borrvägen", "9000001234", "nhogblom@gmail.com", LocalDate.parse("2020-05-20"), LocalDate.parse("2022-05-20"), MemberType.PLATINA);
    Member m3 = new Member("Stefan", "Borrvägen", "9000001234", "nhogblom@gmail.com", LocalDate.parse("2020-05-20"), LocalDate.parse("2025-05-20"), MemberType.STANDARD);

    @Test
    void InfoToReceptionistTest() {
        String expected = "Niklas är en betalande Platina medlem.";
        String expected2 = "Johan är en före detta medlem.";
        String expected3 = "Stefan är en betalande Standard medlem.";
        assertEquals(expected, m1.InfoToReceptionist());
        assertEquals(expected2, m2.InfoToReceptionist());
        assertEquals(expected3, m3.InfoToReceptionist());
    }

    @Test
    void logVisitStringTest() {
        String expected = "Niklas, 9000001234 besökte gymmet " + LocalDate.now();
        System.out.println(expected);
        assertEquals(expected, m1.logVisitString());
        assertNotEquals(expected, m2.logVisitString());
    }

    @Test
    void membershipValid() {
        assertTrue(m1.membershipValid());
        assertFalse(m2.membershipValid());
    }
}