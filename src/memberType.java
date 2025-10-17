public enum memberType {
    PLATINA("Platina"),
    GOLD("Guld"),
    STANDARD("Standard"),
    ;

    private String printableName;
    memberType(String printableName) {
        this.printableName = printableName;
    }
}
