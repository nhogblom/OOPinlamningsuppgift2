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
    Scanner sc = new Scanner(System.in);

    public String collectStringFromTerminal(String prompt) {
        String line = "";
        System.out.println(prompt);
        if (sc.hasNextLine()) {
            if ((line = sc.nextLine()) == null || line.equals("quit")) {
                System.out.println("Avslutar program");
                System.exit(0);
            }
        }
        return line;
    }

    public BestGymEver() {
        try (Scanner sc = new Scanner(new File(filename))) {
            members = memberService.readMembersFromFileToList(sc);
        } catch (FileNotFoundException e) {
            System.out.println("Kunde inte hitta medlemsregistret.");
        }

        while (true && members != null) {

            String match = collectStringFromTerminal("Skriv in ett namn eller personnummer:");
            Member member = memberService.search(match, members);

            if (member == null) {
                IO.println("Ingen träff, försök igen.");
            } else {
                IO.println(member.InfoToReceptionist());
                if (member.membershipValid()) {
                    member.logVisit();
                }
            }
        }
    }
}
