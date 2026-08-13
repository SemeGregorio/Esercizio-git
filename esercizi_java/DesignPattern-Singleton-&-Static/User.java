public class User {

    private String nome;
    private int eta;

    //Costruttore con valori di default
    public User() {
        nome = "Nome di default";
        eta = 0;
    }

    //Getter del nome
    public String getNome() {
        return nome;
    }

    //Setter del nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    //Getter dell'età
    public int getEta() {
        return eta;
    }

    //Setter dell'età
    public void setEta(int eta) {
        this.eta = eta;
    }

    //Stampa le informazioni dell'utente
    public void stampaInformazioni() {
        System.out.println("Nome: " + nome);
        System.out.println("Età: " + eta);
    }
}