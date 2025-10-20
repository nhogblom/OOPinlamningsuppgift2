package BestGymEver.member;

import BestGymEver.MemberType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberService {

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

    public List<Member> readMembersFromFileToList(Scanner sc) {
        List<Member> members = new ArrayList<>();
        String line;
        // skip first row
        sc.nextLine();
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            String[] memberValuesSeparated = new String[7];
            memberValuesSeparated = line.split(";");
            members.add(this.createMemberFromFileData(memberValuesSeparated));
        }
        return members;
    }
}
