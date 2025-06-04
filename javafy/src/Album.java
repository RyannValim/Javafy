import java.time.LocalDateTime;
import java.util.ArrayList;

public class Album {
    //Atributos
    private String tituloAlbum;
    private Artista artista;
    private final LocalDateTime dataLancamentoAlbum;
    private ArrayList<Musica> musicas = new ArrayList<>();
    private TipoAlbum tipo; // ENUM para decidir se vai ser single ou album.

    // Construtor
    public Album(String tituloAlbum, Artista artista, LocalDateTime dataLancamentoAlbum){
        this.tituloAlbum = tituloAlbum;
        this.artista = artista;
        this.dataLancamentoAlbum = dataLancamentoAlbum;
        this.tipo = TipoAlbum.SINGLE; // Inicializa ENUM em single por enquanto.
    }

    // Getters/Setters
    public String getTituloAlbum(){
        return tituloAlbum;
    }
    public void setTituloAlbum(String tituloAlbum){
        this.tituloAlbum = tituloAlbum;
    }

    public Artista getArtista() {
        return artista;
    }
    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public LocalDateTime getDataLancamentoAlbum(){
        return dataLancamentoAlbum; // sem setter por que não faz sentido.
    }

    public ArrayList<Musica> getMusicas(){
        return musicas;
    }
    public void setMusicas(ArrayList<Musica> musicas){
        this.musicas = musicas;
        atualizarTipo(); // sempre que alterar, garantir que o tipo seja atualizado.
    }

    // Métodos
    private void atualizarTipo() {
        // implementar a lógica para atualizar o tipo (single/album) baseado no tamanho do álbum. 
    }

    public void adicionarMusica(Musica musica){
        // implementar a lógica para adicionar a música no álbum.
    }

    public void removerMusica(String tituloMusica){
        // implementar a lógica para remover a música do álbum.
    }
    
    public void listarMusicas(){
        // implementar a lógica para listar as músicas do álbum.
    }
}
