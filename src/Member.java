import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;

public class Member extends Person {
    private String email;
    private LocalDate dateOfBecomingMember;
    private LocalDate dateOfMostRecentMembershipRenewal;
    private memberType memberType;

    public String logVisitString() {
        return this.getName() + ", " + this.getPersonnummer() + " besökte gymmet " + LocalDate.now();
    }

    public void logVisit() {
        String filename = this.getPersonnummer()+".txt";
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename,true))) {
            pw.println(logVisitString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Member(String name, String adress, String personnummer, String email, LocalDate dateOfBecomingMember, LocalDate dateOfMostRecentMembershipRenewal, memberType memberType) {
        super(name, adress, personnummer);
        this.email = email;
        this.dateOfBecomingMember = dateOfBecomingMember;
        this.dateOfMostRecentMembershipRenewal = dateOfMostRecentMembershipRenewal;
        this.memberType = memberType;
    }

    public boolean membershipValid() {
        Period period = Period.between(dateOfMostRecentMembershipRenewal, LocalDate.now());
        if (period.toTotalMonths() <= 12) {
            return true;
        } else {
            return false;
        }
    }

    public String InfoToReceptionist() {
        if (this.membershipValid()) {
            return this.getName() + " är en betalande " + this.memberType.getPrintableName() + " medlem.";
        }
        return this.getName() + " är en före detta medlem.";
    }
}
