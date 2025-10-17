import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BestGymEver {
    String filename = "src/gym_medlemmar.txt";
    List<Member> members = null;

    public BestGymEver() {
        try (Scanner sc = new Scanner(new File(filename))){
        members = RecoverFromFile.readMembersFromFileToList(sc);
        } catch (FileNotFoundException e) {
            System.out.println("Kunde inte hitta medlemsfil.");
        }
    }
}
