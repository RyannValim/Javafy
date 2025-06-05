import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Musica {
    // Atributos
    private Artista artista;
    private String tituloMusica;
    private String generoMusica;
    private int duracaoMusica;
    private final LocalDate dataLancamentoMusica;

    // Construtor
    public Musica(Artista artista, String tituloMusica, String generoMusica, int duracaoMusica, LocalDate dataLancamentoMusica) {
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
        if (artista == null) {
            System.out.println("Erro: O artista não pode ser nulo.");
            return;
        }

        this.artista = artista;
    }

    public String getTituloMusica() {
        return tituloMusica;
    }
    public void setTituloMusica(String tituloMusica) {
        if (tituloMusica == null || tituloMusica.trim().isEmpty()) {
            System.out.println("Erro: O título da música não pode ser vazio.");
            return;
        }

        this.tituloMusica = tituloMusica;
    }

    public String getGeneroMusica() {
        return generoMusica;
    }
    public void setGeneroMusica(String generoMusica) {
        if (generoMusica == null || generoMusica.trim().isEmpty()) {
            System.out.println("Erro: O gênero da música não pode ser vazio.");
            return;
        }

        this.generoMusica = generoMusica;
    }

    public int getDuracaoMusica() {
        return duracaoMusica;
    }
    public void setDuracaoMusica(int duracaoMusica) {
        if (duracaoMusica < 0) {
            System.out.println("Erro: A duração da música não pode ser negativa.");
            return;
        }
        this.duracaoMusica = duracaoMusica;
    }

    public String getDataLancamentoMusicaFormatada() {
        return dataLancamentoMusica.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public LocalDate getLocalDateLancamentoMusica() {
        return dataLancamentoMusica;
    }

    public String getDuracaoMusicaEmFormatoMMSS() {
        int minutos = duracaoMusica / 60;
        int segundos = duracaoMusica % 60;
        return String.format("%02d:%02d", minutos, segundos);
    }

    // Métodos
    public void exibirInfo() {
        System.out.println("\n🎵 Informações da Música:");
        System.out.println("Título: " + tituloMusica);
        System.out.println("Artista: " + artista.getNome());
        System.out.println("Gênero: " + generoMusica);
        System.out.println("Duração: " + getDuracaoMusicaEmFormatoMMSS());
        System.out.println("Data de Lançamento: " + getDataLancamentoMusicaFormatada());
        System.out.println("-----------------------------");
    }

    @Override
    public String toString() {
        return "Título: " + tituloMusica +
                " | Artista: " + artista.getNome() +
                " | Gênero: " + generoMusica +
                " | Duração: " + getDuracaoMusicaEmFormatoMMSS();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Musica musica = (Musica) o;
        return tituloMusica.equalsIgnoreCase(musica.tituloMusica) &&
                Objects.equals(artista, musica.artista) &&
                generoMusica.equalsIgnoreCase(musica.generoMusica) &&
                duracaoMusica == musica.duracaoMusica;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tituloMusica.toLowerCase(), artista, generoMusica.toLowerCase(), duracaoMusica);
    }
}
