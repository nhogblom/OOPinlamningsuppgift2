package BestGymEver.Member;

import BestGymEver.MemberType;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;

public class Member {
    private String name;
    private String adress;
    private String personnummer;
    private String email;
    private LocalDate dateOfBecomingMember;
    private LocalDate dateOfMostRecentMembershipRenewal;
    private MemberType memberType;

    public Member() {
    }

    public Member(String name, String adress, String personnummer, String email, LocalDate dateOfBecomingMember, LocalDate dateOfMostRecentMembershipRenewal, MemberType memberType) {
        this.name = name;
        this.adress = adress;
        this.personnummer = personnummer;
        this.email = email;
        this.dateOfBecomingMember = dateOfBecomingMember;
        this.dateOfMostRecentMembershipRenewal = dateOfMostRecentMembershipRenewal;
        this.memberType = memberType;
    }

    public String logVisitString() {
        return this.getName() + ", " + this.getPersonnummer() + " besökte gymmet " + LocalDate.now();
    }

    public void logVisit() {
        String filepath = "src/BestGymEver/membersactivity/";
        String filename = this.getPersonnummer() + ".txt";
        try (PrintWriter pw = new PrintWriter(new FileWriter(filepath + filename, true))) {
            pw.println(logVisitString());
            pw.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

    public String getEmail() {
        return email;
    }


    public LocalDate getDateOfBecomingMember() {
        return dateOfBecomingMember;
    }


    public LocalDate getDateOfMostRecentMembershipRenewal() {
        return dateOfMostRecentMembershipRenewal;
    }


    public String getName() {
        return name;
    }


    public String getAdress() {
        return adress;
    }


    public String getPersonnummer() {
        return personnummer;
    }

}
