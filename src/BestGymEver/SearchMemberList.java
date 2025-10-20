package BestGymEver;

import BestGymEver.Member.Member;

import java.util.List;

public class SearchMemberList {

    public static Member search(String searchString, List<Member> memberList) {
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
}
