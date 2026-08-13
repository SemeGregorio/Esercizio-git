public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private String address;

    //Costruisce Person utilizzando i dati presenti nel Builder
    public Person(Builder builder) {
        this.firstName = builder.getFirstName();
        this.lastName = builder.getLastName();
        this.age = builder.getAge();
        this.address = builder.getAddress();
    }

    //Getter e setter del nome
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //Getter e setter del cognome
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //Getter e setter dell'età
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //Getter e setter dell'indirizzo
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}