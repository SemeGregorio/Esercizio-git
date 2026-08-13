public class Builder {

    private String firstName;
    private String lastName;
    private int age;
    private String address;

    // Costruttore con i campi obbligatori
    public Builder(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Imposta l'età
    public Builder age(int age) {
        this.age = age;
        return this;
    }

    // Imposta l'indirizzo
    public Builder address(String address) {
        this.address = address;
        return this;
    }

    // Getter del nome
    public String getFirstName() {
        return firstName;
    }

    // Getter del cognome
    public String getLastName() {
        return lastName;
    }

    // Getter dell'età
    public int getAge() {
        return age;
    }

    // Getter dell'indirizzo
    public String getAddress() {
        return address;
    }

    // Costruisce e restituisce l'oggetto Person
    public Person build() {
        return new Person(this);
    }
}