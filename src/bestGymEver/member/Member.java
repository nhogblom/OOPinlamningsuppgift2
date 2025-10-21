package bestGymEver.member;

import bestGymEver.MemberType;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Member {
    private String name;
    private String adress;
    private String personnummer;
    private String email;
    private final LocalDate dateOfBecomingMember;
    private LocalDate dateOfMostRecentMembershipRenewal;
    private MemberType memberType;
    private final boolean isTest;


    public Member(String name, String adress, String personnummer, String email, LocalDate dateOfBecomingMember, LocalDate dateOfMostRecentMembershipRenewal, MemberType memberType) {
        this.name = name;
        this.adress = adress;
        this.personnummer = personnummer;
        this.email = email;
        this.dateOfBecomingMember = dateOfBecomingMember;
        this.dateOfMostRecentMembershipRenewal = dateOfMostRecentMembershipRenewal;
        this.memberType = memberType;
        this.isTest = false;
    }

    public Member(String name, String adress, String personnummer, String email, LocalDate dateOfBecomingMember, LocalDate dateOfMostRecentMembershipRenewal, MemberType memberType, boolean isTest) {
        this.name = name;
        this.adress = adress;
        this.personnummer = personnummer;
        this.email = email;
        this.dateOfBecomingMember = dateOfBecomingMember;
        this.dateOfMostRecentMembershipRenewal = dateOfMostRecentMembershipRenewal;
        this.memberType = memberType;
        this.isTest = isTest;
    }

    public String logVisitString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return this.getName() + ", " + this.getPersonnummer() + " besökte gymmet " + LocalDateTime.now().format(dtf);
    }

    public void logVisit() {
        String filepath = "src/BestGymEver/membersactivity/";
        String filename = this.getPersonnummer() + ".txt";
        try (PrintWriter pw = new PrintWriter(new FileWriter(filepath + filename, true))) {
            pw.println(logVisitString());
            pw.flush();
            IO.println("Besök registrerades.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




    public boolean membershipValid() {
        Period period = Period.between(dateOfMostRecentMembershipRenewal, LocalDate.now());
        return period.toTotalMonths() <= 12;
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
