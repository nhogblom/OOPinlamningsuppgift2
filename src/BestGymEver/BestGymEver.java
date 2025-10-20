package BestGymEver;

import BestGymEver.Member.Member;
import BestGymEver.Member.MemberService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class BestGymEver {
    String filename = "src/BestGymEver/Resources/gym_medlemmar.txt";
    List<Member> members = null;
    MemberService memberService = new MemberService();


    public BestGymEver() {

        try (Scanner sc = new Scanner(new File(filename))) {
            members = memberService.readMembersFromFileToList(sc);
        } catch (FileNotFoundException e) {
            System.out.println("Kunde inte hitta medlemsregistret.");
        }

        while (true && members != null) {
            String match = IO.readln("Skriv in ett namn eller personnummer:\n");
            if (match.equals("quit")) {
                IO.println("Användaren valde att avsluta programmet.\n");
                break;
            }
            Member member = memberService.search(match, members);
            if (member == null) {
                IO.println("Ingen träff, försök igen.");
            } else {
                IO.println(member.InfoToReceptionist());
                if (member.membershipValid()) {
                    member.logVisit();
                    IO.println("Besök registrerades.");
                }
            }
        }
    }
}
