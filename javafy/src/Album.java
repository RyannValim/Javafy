import java.util.ArrayList;

public class Album extends Musica {
    private String tituloAlbum;
    private Artista artista;
    private String dataLancamentoAlbum; 
    private ArrayList<Musica> musicas = new ArrayList<>();
    private TipoAlbum tipo; // ENUM SINGLE ou ALBUM

    // Construtor
    public Album(String tituloAlbum, Artista artista, String dataLancamentoAlbum) {
        // Como herda Musica, deve chamar super com algo genérico (ou vazio) para Musica
        // Mas álbum não é música, então aqui um workaround: passar dados "vazios" para super
        super(artista, "", "", "", dataLancamentoAlbum);
        this.tituloAlbum = tituloAlbum;
        this.artista = artista;
        this.dataLancamentoAlbum = dataLancamentoAlbum;
        this.tipo = TipoAlbum.SINGLE; // padrão SINGLE
    }

    // Getters e setters

    public String getTituloAlbum() {
        return tituloAlbum;
    }

    public void setTituloAlbum(String tituloAlbum) {
        this.tituloAlbum = tituloAlbum;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public String getDataLancamentoAlbum() {
        return dataLancamentoAlbum;
    }

    // sem setter para data de lançamento, se quiser pode adicionar

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(ArrayList<Musica> musicas) {
        this.musicas = musicas;
        atualizarTipo();
    }

    // Métodos

    private void atualizarTipo() {
        // implementar a lógica para atualizar o tipo (single/album) baseado no tamanho do álbum. 
    }

    public void adicionarMusica(Musica musica) {
    // implementar a lógica para listar as músicas do álbum.
    }

    public void removerMusica(String tituloMusica) {
    // implementar a lógica para listar as músicas do álbum.
    }

    public void listarMusicas() {
    // implementar a lógica para listar as músicas do álbum.
    }

    public TipoAlbum getTipo() {
        return tipo;
    }

    public void setTipo(TipoAlbum tipo) {
        this.tipo = tipo;
    }
}
