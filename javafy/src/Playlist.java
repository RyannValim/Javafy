import java.time.LocalDateTime;
import java.util.ArrayList;

public class Playlist {
    // Atributos
    private String nomePlaylist;
    private LocalDateTime dataCriacao;
    private Usuario dono;
    private ArrayList<Musica> musicas = new ArrayList<>();

    // Construtor
    public Playlist(String nomePlaylist, LocalDateTime dataCriacao, Usuario dono){
        this.nomePlaylist = nomePlaylist;
        this.dataCriacao = dataCriacao;
        this.dono = dono;
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

    public Usuario getDono(){
        return dono;
    }
    public void setDono(Usuario dono){
        this.dono = dono;
    }

    public ArrayList<Musica> getMusicas(){
        return musicas;
    }
    public void setMusicas(ArrayList<Musica> musicas){
        this.musicas = musicas;
    }    

    // Métodos
    @Override
    public String toString() {
        return "Playlist: " + nomePlaylist + " | Criada em: " + dataCriacao;
        // Para facilitar o debug
    }

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
