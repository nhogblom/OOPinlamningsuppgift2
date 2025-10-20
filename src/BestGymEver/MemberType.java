package BestGymEver;

public enum MemberType {
    PLATINA("Platina"),
    GULD("Guld"),
    STANDARD("Standard");

    private String printableName;
    MemberType(String printableName) {
        this.printableName = printableName;
    }

    public String getPrintableName() {
        return printableName;
    }
}
