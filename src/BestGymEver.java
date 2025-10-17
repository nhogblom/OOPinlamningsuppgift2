import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class BestGymEver {
    String filename = "src/gym_medlemmar.txt";
    List<Member> members = null;

    public BestGymEver() {

        try (Scanner sc = new Scanner(new File(filename))) {
            members = RecoverFromFile.readMembersFromFileToList(sc);
        } catch (FileNotFoundException e) {
            System.out.println("Kunde inte hitta medlemsfil.");
        }

        while (true) {
            String match = IO.readln("Skriv in ett namn eller personnummer:\n");
            Member member = SearchMemberList.search(match, members);
            if (member == null) {
                IO.println("Ingen träff, försök igen.");
            } else {
                IO.println(member.getAdress());
            }
        }
    }
}
