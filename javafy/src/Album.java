import java.time.LocalDateTime;
import java.util.ArrayList;

public class Album {
    //Atributos
    private String tituloAlbum;
    private LocalDateTime anoLancamento;
    private ArrayList<Musica> musicas;

    // Construtor
    public Album(String tituloAlbum, LocalDateTime anoLancamento){
        this.tituloAlbum = tituloAlbum;
        this.anoLancamento = anoLancamento; 
        this.musicas = new ArrayList<>();
    }

    // Getters/Setters
    public String getTituloAlbum(){
        return tituloAlbum;
    }
    public void setTituloAlbum(String tituloAlbum){
        this.tituloAlbum = tituloAlbum;
    }

    public LocalDateTime getAnoLancamento(){
        return anoLancamento;
    }
    public void setAnoLancamento(LocalDateTime anoLancamento){
        this.anoLancamento = anoLancamento;
    }

    public ArrayList<Musica> getMusicas(){
        return musicas;
    }
    public void setMusicas(ArrayList<Musica> musicas){
        this.musicas = musicas;
    }

    // Métodos
    public void adicionarMusica(Musica musica){
        // implementar a lógica para adicionar a música no álbum.
    }

    public void removerMusica(){
        // implementar a lógica para remover a música do álbum.
    }
    
    public void listarMusicas(){
        // implementar a lógica para listar as músicas do álbum.
    }
}
