import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchMemberListTest {

    Member m1 = new Member("Niklas","Borrvägen","9000001234","nhogblom@gmail.com",LocalDate.parse("2020-05-20"),LocalDate.parse("2020-05-20"),memberType.PLATINA);
    Member m2 = new Member("Albin","Borrvägen","1900000124","nhogblom@gmail.com", LocalDate.parse("2020-05-20"),LocalDate.parse("2020-05-20"),memberType.PLATINA);
    List<Member> members = new ArrayList<>();



    @Test
    void searchTest() {
        members.add(m1);
        members.add(m2);
        assertEquals(m1,SearchMemberList.search("Niklas",members));
        assertEquals(m2,SearchMemberList.search("Albin",members));
        assertNotEquals(m2,SearchMemberList.search("Niklas",members));
        assertNotEquals(m1,SearchMemberList.search("Albin",members));
        assertEquals(m1,SearchMemberList.search("9000001234",members));
        assertEquals(m2,SearchMemberList.search("1900000124",members));
        assertNotEquals(m1,SearchMemberList.search("Ingen heter så här",members));
    }
}