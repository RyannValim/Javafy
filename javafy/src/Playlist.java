import java.time.LocalDateTime;
import java.util.ArrayList;

public class Playlist {
    // Atributos
    private String nomePlaylist;
    private final LocalDateTime dataCriacao;
    private final Usuario dono;
    private final ArrayList<Musica> musicas;

    // Construtor
    public Playlist(String nomePlaylist, Usuario dono){
        this.nomePlaylist = nomePlaylist;
        this.dono = dono;
        this.dataCriacao = LocalDateTime.now();
        this.musicas = new ArrayList<>();
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

    public Usuario getDono(){
        return dono;
    }

    public ArrayList<Musica> getMusicas(){
        return musicas;
    }

    // Métodos
    public void adicionarMusica(Musica musica){
        if (this.musicas.contains(musica)) {
            System.out.println("ERRO: A música '" + musica.getTituloMusica() + "' já existe na playlist '" + this.nomePlaylist + "'.");
        } else {
            this.musicas.add(musica);
            System.out.println("Música '" + musica.getTituloMusica() + "' adicionada à playlist '" + this.nomePlaylist + "'.");
        }
    }

    public void removerMusica(String tituloMusica){
        if (tituloMusica == null || tituloMusica.trim().isEmpty()) {
            System.out.println("Erro: O título da música para remover não pode ser vazio.");
            return;
        }

        Musica musicaParaRemover = null;
        for (Musica musica : this.musicas) {
            if (musica.getTituloMusica().equalsIgnoreCase(tituloMusica)) {
                musicaParaRemover = musica;
                break;
            }
        }

        if (musicaParaRemover != null) {
            this.musicas.remove(musicaParaRemover);
            System.out.println("Música '" + tituloMusica + "' removida da playlist '" + this.nomePlaylist + "'.");
        } else {
            System.out.println("Música '" + tituloMusica + "' não encontrada na playlist '" + this.nomePlaylist + "'.");
        }
    }

    public void listarMusicas(){
        if (this.musicas.isEmpty()) {
            System.out.println("A playlist '" + this.nomePlaylist + "' não possui músicas para serem listadas.");
            return;
        }

        System.out.println("\n--- Músicas na Playlist: " + this.nomePlaylist + " ---");
        for (int i = 0; i < this.musicas.size(); i++) {
            System.out.println((i + 1) + ". " + this.musicas.get(i));
        }
        System.out.println("----------------------------------------");
    }

    @Override
    public String toString() {
        return "Playlist [Nome: " + nomePlaylist +
                ", Criada em: " + dataCriacao.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) +
                ", Dono: " + dono.getNome() +
                ", Músicas: " + musicas.size() + "]";
    }
}
