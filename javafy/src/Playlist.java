import java.time.LocalDateTime;
import java.util.ArrayList;

public class Playlist {
    // Atributos
    private String nomePlaylist;
    private LocalDateTime dataCriacao;
    private Usuario dono; // Associação com Usuario
    private ArrayList<Musica> musicas; // Agregação com Musica

    // Construtor
    public Playlist(String nomePlaylist, Usuario dono){
        this.nomePlaylist = nomePlaylist;
        this.dono = dono;
        this.dataCriacao = LocalDateTime.now(); // Definida já no momento da criação.
        this.musicas = new ArrayList<>();  // Inicializa a lista de músicas.
    }

    // Getters/Setters
    public String getNomePlaylist(){
        return nomePlaylist;
    }
    public void setNomePlaylist(String nomePlaylist){
        this.nomePlaylist = nomePlaylist;
    }

    // Somente Getter, pois a data da criaçao da Playlist é automatica pelo código.
    public LocalDateTime getDataCriacao(){
        return dataCriacao;
    }

    // Somente Getter, pois não faz sentido alterar o dono da Playlist após a criação.
    public Usuario getDono(){
        return dono;
    }

    // Somente Getter, um setter aqui seria mexer com o ArrayList inteiro de Musica, não faz muito sentido.
    public ArrayList<Musica> getMusicas(){
        return musicas;
    }

    // Métodos
    @Override
    public String toString() { // toString para facilitar o debug.
        return "Playlist [Nome: " + nomePlaylist +
               ", Criada em: " + dataCriacao.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) +
               ", Dono: " + dono.getNome() + // CHECHAR: Pessoa.getNome() deve estar implementado!
               ", Músicas: " + musicas.size() + "]";
    }

    public void adicionarMusica(Musica musica){
        // Verifica se a música já existe na playlist para evitar duplicatas
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
        // Percorre a lista para encontrar a música pelo título (ignorando caixa)
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
            Musica musica = this.musicas.get(i);
            System.out.println((i + 1) + ". Título: " + musica.getTituloMusica() +
                               " | Artista: " + musica.getArtista().getNome() + // CHECHAR:  Artista.getNome() deve estar implementado!
                               " | Gênero: " + musica.getGeneroMusica() +
                               " | Duração: " + musica.getDuracaoMusica() + "s");
        }
        System.out.println("----------------------------------------");
    }
}