package bestGymEver.member;

import bestGymEver.IOUtil;
import bestGymEver.MemberType;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
            } else if (searchString.equals(memberList.get(i).getPersonnummer())) {
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
            System.out.println("Fel vid inläsning av användardata.." + e.getMessage());
        }
        return member;
    }



    public List<Member> readMembersFromFileToList(Path path) throws IOException {
        List<Member> members = new ArrayList<>();
        IOUtil ioUtil = new IOUtil();
        List<String> allTheLines = ioUtil.readFromFile(path);
        // skip first line
        allTheLines.removeFirst();
        for (String line : allTheLines) {
            String[] memberValuesSeparated = line.split(";");
            members.add(createMemberFromFileData(memberValuesSeparated));
        }
        return members;
    }
}
