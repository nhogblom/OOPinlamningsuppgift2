import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class BestGymEver {
    String filename = "src/gym_medlemmar.txt";
    List<Member> members = null;

    public void logVisit(Member member){

    }


    public BestGymEver() {

        try (Scanner sc = new Scanner(new File(filename))) {
            members = RecoverFromFile.readMembersFromFileToList(sc);
        } catch (FileNotFoundException e) {
            System.out.println("Kunde inte hitta medlemsfil.");
        }

        while (true && members != null) {
            String match = IO.readln("Skriv in ett namn eller personnummer:\n");
            if  (match.equals("quit")) {
                IO.println("Användaren valde att avsluta programmet.\n");
                break;
            }
            Member member = SearchMemberList.search(match, members);
            if (member == null) {
                IO.println("Ingen träff, försök igen.");
            } else {
                IO.println(member.InfoToReceptionist());
                member.logVisit();
            }
        }
    }
}
