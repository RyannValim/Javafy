public class Musica {
    // Atributos
    private Artista artista;
    private String tituloMusica;
    private String generoMusica;
    private Integer duracaoMusica;

    // Construtor
    public Musica(Artista artista, String tituloMusica, String generoMusica, Integer duracaoMusica){
        this.artista = artista;
        this.tituloMusica = tituloMusica;
        this.generoMusica = generoMusica;
        this.duracaoMusica = duracaoMusica;
    }

    // Getters/Setters
    public Artista getArtista(){
        return artista;
    }
    public void setArtista(Artista artista){
        this.artista = artista;
    }

    public String getTituloMusica(){
        return tituloMusica;
    }
    public void setTituloMusica(String tituloMusica){
        this.tituloMusica = tituloMusica;
    }

    public String getGeneroMusica(){
        return generoMusica;
    }
    public void setGeneroMusica(String generoMusica){
        this.generoMusica = generoMusica;
    }

    public Integer getDuracaoMusica(){
        return duracaoMusica;
    }
    public void setDuracaoMusica(Integer duracaoMusica){
        this.duracaoMusica = duracaoMusica;
    }

    // Métodos
    public void exibirInformacoes(){
        // implementar a lógica para exibir as informações da música atual.
    }
}
