import java.time.LocalDate;

public class Member extends Person{
    private String email;
    private LocalDate dateOfBecommingMember;
    private LocalDate dateOfMostRecentMembershipRenewal;
    private memberType memberType;

    public Member(String name, String adress, String personnummer, String email, LocalDate dateOfBecommingMember, LocalDate dateOfMostRecentMembershipRenewal, memberType memberType) {
        super(name, adress, personnummer);
        this.email = email;
        this.dateOfBecommingMember = dateOfBecommingMember;
        this.dateOfMostRecentMembershipRenewal = dateOfMostRecentMembershipRenewal;
        this.memberType = memberType;
    }
}
