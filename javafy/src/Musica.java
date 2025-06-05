public class Musica {
    private Artista artista;
    private String tituloMusica;
    private String generoMusica;
    private String duracaoMusica;
    private String dataLancamentoMusica;

    // Construtor
    public Musica(Artista artista, String tituloMusica, String generoMusica, String duracaoMusica, String dataLancamentoMusica) {
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

    public String getDataLancamentoMusica() {
        return dataLancamentoMusica;
    }

    public void setDataLancamentoMusica(String dataLancamentoMusica) {
        this.dataLancamentoMusica = dataLancamentoMusica;
    }

    // Método para exibir informações da música
    public void exibirInfo() {
        System.out.println("\n🎵 Informações da Música:");
        System.out.println("Título: " + tituloMusica);
        System.out.println("Artista: " + artista.getNome());
        System.out.println("Gênero: " + generoMusica);
        System.out.println("Duração: " + duracaoMusica);
        System.out.println("Data de Lançamento: " + dataLancamentoMusica);
    }
}
