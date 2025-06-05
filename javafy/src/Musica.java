import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Musica {
    // Atributos
    private Artista artista;
    private String tituloMusica;
    private String generoMusica;
    private int duracaoMusica; // DECIDIDO: int para segundos
    private final LocalDate dataLancamentoMusica;

    // Construtor
    public Musica(Artista artista, String tituloMusica, String generoMusica, int duracaoMusica, LocalDate dataLancamentoMusica) {
        // Validações básicas (opcionais, mas boas práticas)
        if (artista == null) {
            throw new IllegalArgumentException("A música deve ter um artista.");
        }
        if (tituloMusica == null || tituloMusica.trim().isEmpty()) {
            throw new IllegalArgumentException("O título da música não pode ser vazio.");
        }
        if (generoMusica == null || generoMusica.trim().isEmpty()) {
            throw new IllegalArgumentException("O gênero da música não pode ser vazio.");
        }
        if (duracaoMusica < 0) { // Duração não pode ser negativa
            throw new IllegalArgumentException("A duração da música não pode ser negativa.");
        }
        if (dataLancamentoMusica == null) {
            throw new IllegalArgumentException("A data de lançamento da música não pode ser nula.");
        }

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

    // Getter para a duração em segundos (int)
    public int getDuracaoMusica() {
        return duracaoMusica;
    }
    // Setter para a duração em segundos (int)
    public void setDuracaoMusica(int duracaoMusica) {
        if (duracaoMusica < 0) {
            System.out.println("Erro: A duração da música não pode ser negativa.");
            return;
        }
        this.duracaoMusica = duracaoMusica;
    }

    // Getter para a data de lançamento formatada para exibição (String)
    public String getDataLancamentoMusicaFormatada() {
        return dataLancamentoMusica.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    
    // Getter para o objeto LocalDate cru, se necessário
    public LocalDate getLocalDateLancamentoMusica() {
        return dataLancamentoMusica;
    }

    // O MÉTODO QUE ESTÁ FALTANDO OU COM PROBLEMAS DE COMPILAÇÃO
    public String getDuracaoMusicaEmFormatoMMSS() {
        int minutos = duracaoMusica / 60;
        int segundos = duracaoMusica % 60;
        return String.format("%02d:%02d", minutos, segundos); // Formata para 05:35, 03:29, etc.
    }

    // Métodos
    public void exibirInfo() {
        System.out.println("\n🎵 Informações da Música:");
        System.out.println("Título: " + tituloMusica);
        System.out.println("Artista: " + artista.getNome());
        System.out.println("Gênero: " + generoMusica);
        System.out.println("Duração: " + getDuracaoMusicaEmFormatoMMSS()); // Usando o método formatado
        System.out.println("Data de Lançamento: " + getDataLancamentoMusicaFormatada());
        System.out.println("-----------------------------");
    }

    @Override
    public String toString() {
        return "Título: " + tituloMusica +
               " | Artista: " + artista.getNome() +
               " | Gênero: " + generoMusica +
               " | Duração: " + getDuracaoMusicaEmFormatoMMSS(); // Usando o método formatado
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