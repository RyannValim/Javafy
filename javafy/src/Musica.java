import java.time.LocalDateTime;

public class Musica {
    private Artista artista;
    private String tituloMusica;
    private String generoMusica;
    private String duracaoMusica;
    private LocalDateTime dataLancamentoMusica;

    // Construtor
    public Musica(Artista artista, String tituloMusica, String generoMusica, String duracaoMusica, LocalDateTime dataLancamentoMusica) {
        this.artista = artista;
        this.tituloMusica = tituloMusica;
        this.generoMusica = generoMusica;
        this.duracaoMusica = duracaoMusica;
        this.dataLancamentoMusica = dataLancamentoMusica;
    }

    // Getters e Setters
    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public String getTituloMusica() {
        return tituloMusica;
    }

    public void setTituloMusica(String tituloMusica) {
        this.tituloMusica = tituloMusica;
    }

    public String getGeneroMusica() {
        return generoMusica;
    }

    public void setGeneroMusica(String generoMusica) {
        this.generoMusica = generoMusica;
    }

    public String getDuracaoMusica() {
        return duracaoMusica;
    }

    public void setDuracaoMusica(String duracaoMusica) {
        this.duracaoMusica = duracaoMusica;
    }

    public LocalDateTime getDataLancamentoMusica() {
        return dataLancamentoMusica;
    }

    public void setDataLancamentoMusica(LocalDateTime dataLancamentoMusica) {
        this.dataLancamentoMusica = dataLancamentoMusica;
    }

    // Método para exibir informações da música
    public void exibirInfo() {
        System.out.println("Título: " + tituloMusica);
        System.out.println("Artista: " + artista.getNome());
        System.out.println("Gênero: " + generoMusica);
        System.out.println("Duração: " + duracaoMusica);
        System.out.println("Data de Lançamento: " + dataLancamentoMusica.toLocalDate());
    }
}
