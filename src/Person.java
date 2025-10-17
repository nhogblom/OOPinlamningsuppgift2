public abstract class Person {
    private String name;
    private String adress;
    private String personnummer;

    public Person(String name, String adress, String personnummer) {
        this.name = name;
        this.adress = adress;
        this.personnummer = personnummer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPersonnummer() {
        return personnummer;
    }

    public void setPersonnummer(String personnummer) {
        this.personnummer = personnummer;
    }
}
