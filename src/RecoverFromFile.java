import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecoverFromFile {


    public static Member createMemberFromFileData(String[] rawMemberData) {
        Member member = null;
        try {
            String name = rawMemberData[0].trim();
            String adress = rawMemberData[1].trim();
            String email = rawMemberData[2].trim();
            String personnummer = rawMemberData[3].trim();
            LocalDate dateOfBecommingMember = LocalDate.parse(rawMemberData[4].trim());
            LocalDate dateOfMostRecentMembershipRenewal = LocalDate.parse(rawMemberData[5].trim());
            String memberTypeString = rawMemberData[6].trim();
            memberType memberTypeCurrent = null;
            for (memberType mType : memberType.values()) {
                if (mType.name().equalsIgnoreCase(memberTypeString)) {
                    memberTypeCurrent = mType;
                }
            }
            member = new Member(name, adress, personnummer, email, dateOfBecommingMember, dateOfMostRecentMembershipRenewal, memberTypeCurrent);
        } catch (Exception e) {
            System.out.println("Fel vid inläsning av användardata.."+e.getMessage());

        }
        return member;
    }

    public static List<Member> readMembersFromFileToList(Scanner sc) {
        List<Member> members = new ArrayList<>();
        String line;

        while ((line = sc.nextLine()) != null) {
            String[] memberValuesSeparated = new String[7];
            memberValuesSeparated = line.split(";");

            //String name =
        }
        return members;
    }
}
