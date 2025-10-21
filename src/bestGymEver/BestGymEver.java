package bestGymEver;

import bestGymEver.member.Member;
import bestGymEver.member.MemberService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class BestGymEver {
    Path path = Path.of("Resources/gym_medlemmar.txt");
    List<Member> members = null;
    MemberService mS = new MemberService();
    Scanner sc = new Scanner(System.in);
    IOUtil ioUtil = new IOUtil();


    public void runProgram() {
        try {
            members = mS.readMembersFromFileToList(path);
            while (true) {
                String searchString = ioUtil.collectStringFromTerminal("Skriv in ett namn eller personnummer", sc);
                if (searchString.equals("quit") || searchString.isEmpty()) {
                    System.out.println("Användaren avslutade programmet.");
                    System.exit(0);
                    break;
                }
                Member searchedMember = mS.searchMember(searchString, members);

                if (searchedMember != null) {
                    System.out.println(searchedMember.InfoToReceptionist());
                    if (searchedMember.membershipValid()) {
                        searchedMember.logVisit();
                    }
                } else {
                    System.out.println("Ingen träff, försök igen.");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Filen hittades inte.");
            System.out.println(e.getMessage());
        }catch (InvalidInputParameterForMember e){
            System.out.println("Felaktig data för enskild medlem");
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            System.out.println("IO Exception inträffade.");
            System.out.println(e.getMessage());
        }
    }
}
