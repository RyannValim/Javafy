import java.time.LocalDateTime;
import java.util.ArrayList;

public class Playlist {
    //Atributos
    private String nomePlaylist;
    private LocalDateTime dataCriacao;
    private ArrayList<Musica> musicas = new ArrayList<>();

    // Construtor
    public Playlist(String nomePlaylist, LocalDateTime dataCriacao){
        this.nomePlaylist = nomePlaylist;
        this.dataCriacao = dataCriacao;
    }

    // Getters/Setters
    public String getNomePlaylist(){
        return nomePlaylist;
    }
    public void setNomePlaylist(String nomePlaylist){
        this.nomePlaylist = nomePlaylist;
    }

    public LocalDateTime getDataCriacao(){
        return dataCriacao;
    }
    public void setDataCriacao(LocalDateTime dataCriacao){
        this.dataCriacao = dataCriacao;
    }

    public ArrayList<Musica> getMusicas(){
        return musicas;
    }
    public void setMusicas(ArrayList<Musica> musicas){
        this.musicas = musicas;
    }    

    // Métodos
    public void adicionarMusica(Musica musica){
        // implementar a lógica para adicionar a música na playlist.
    }

    public void removerMusica(String tituloMusica){
        // implementar a lógica para procurar a música pelo título e remover, se existir.
    }

    public void listarMusicas(){
        // implementar a lógica para percorrer a lista e imprimir as informações das músicas.
    }
}
