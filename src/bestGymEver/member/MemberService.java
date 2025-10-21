package bestGymEver.member;

import bestGymEver.MemberType;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberService {
    private final boolean isTest;

    public MemberService() {
        this.isTest = false;
    }

    public MemberService(boolean isTest) {
        this.isTest = isTest;
    }

    public Member search(String searchString, List<Member> memberList) {
        Member member = null;
        for (int i = 0; i < memberList.size(); i++) {
            if (searchString.toLowerCase().equals(memberList.get(i).getName().toLowerCase())) {
                return memberList.get(i);
            }else if (searchString.equals(memberList.get(i).getPersonnummer())) {
                return memberList.get(i);
            }
        }
        return member;
    }

    public Member createMemberFromFileData(String[] rawMemberData) {
        Member member = null;
        try {
            String name = rawMemberData[0].trim();
            String adress = rawMemberData[1].trim();
            String email = rawMemberData[2].trim();
            String personnummer = rawMemberData[3].trim();
            LocalDate dateOfBecomingMember = LocalDate.parse(rawMemberData[4].trim());
            LocalDate dateOfMostRecentMembershipRenewal = LocalDate.parse(rawMemberData[5].trim());
            String memberTypeString = rawMemberData[6].trim();
            MemberType memberTypeCurrent = null;
            for (MemberType mType : MemberType.values()) {
                if (mType.name().equalsIgnoreCase(memberTypeString)) {
                    memberTypeCurrent = mType;
                }
            }
            member = new Member(name, adress, personnummer, email, dateOfBecomingMember, dateOfMostRecentMembershipRenewal, memberTypeCurrent);
        } catch (Exception e) {
            System.out.println("Fel vid inläsning av användardata.."+e.getMessage());
        }
        return member;
    }



    public List<Member> readMembersFromFileToList(Path path) throws FileNotFoundException {
        List<Member> members = new ArrayList<>();
        String line;
        try (Scanner sc = new Scanner(new File(path.toString()))){
            // skip first row
            sc.nextLine();
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                String[] memberValuesSeparated = new String[7];
                memberValuesSeparated = line.split(";");
                members.add(this.createMemberFromFileData(memberValuesSeparated));
            }
        }
        return members;
    }


}
