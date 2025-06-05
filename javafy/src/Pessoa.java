public abstract class Pessoa {
    // Atributos
    private String nome;
    private String email;

    // Construtores
    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Pessoa(String nome) {
        this.nome = nome;
        this.email = null;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Métodos
    @Override
    public String toString() {
        return "Pessoa{nome='" + nome + "', email='" + email + "'}";
    }
}
