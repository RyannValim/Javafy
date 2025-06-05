import java.util.ArrayList;

public class Usuario extends Pessoa{
    // Atributos
    private String login;
    private String senha;
    private final ArrayList<Playlist> playlists;

    // Construtor
    public Usuario(String nome, String email, String login, String senha){
        super(nome, email);
        this.login = login;
        this.senha = senha;
        this.playlists = new ArrayList<>();
    }

    // Getters/Setters
    public String getLogin(){
        return login;
    }
    public void setLogin(String login){
        this.login = login;
    }

    public String getSenha(){
        return senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }

    public ArrayList<Playlist> getPlaylists(){
        return playlists;
    }
    
    // Métodos
    public void criarPlaylist(String nomePlaylist){
        if(nomePlaylist == null || nomePlaylist.trim().isEmpty()){
            System.out.println("Erro: O nome da playlist não pode ser vazio.");
            return;
        }

        for(Playlist p : this.playlists){
            if(p.getNomePlaylist().equalsIgnoreCase(nomePlaylist)){
                System.out.println("Erro: Já existe uma playlist com o nome '" + nomePlaylist + "'.");
                return;
            }
        }

        Playlist novaPlaylist = new Playlist(nomePlaylist, this);
        this.playlists.add(novaPlaylist);
        System.out.println("Playlist '" + nomePlaylist + "' criada com sucesso para o usuário " + this.getNome() + ".");
    }

    public void excluirPlaylist(String nomePlaylist){
        Playlist playlistParaExcluir = null;

        for (Playlist p : this.playlists) {
            if (p.getNomePlaylist().equalsIgnoreCase(nomePlaylist)) {
                playlistParaExcluir = p;
                break;
            }
        }

        if(playlistParaExcluir != null){
            this.playlists.remove(playlistParaExcluir);
            System.out.println("Playlist '" + nomePlaylist + "' excluída com sucesso.");
        } else{
            System.out.println("Erro: Playlist '" + nomePlaylist + "' não encontrada para o usuário " + this.getNome() + ".");
        }
    }

    public void listarPlaylists(){
        if (this.playlists.isEmpty()) {
            System.out.println("O usuário " + this.getNome() + " não possui playlists.");
            return;
        }

        System.out.println("\n--- Playlists de " + this.getNome() + " ---");
        for (int i = 0; i < this.playlists.size(); i++) {
            Playlist playlist = this.playlists.get(i);
            System.out.println((i + 1) + ". " + playlist.toString());
        }
        System.out.println("------------------------------------");
    }

    @Override
    public String toString() {
        return "Usuário: " + getNome() + " | Login: " + login + " | Playlists: " + playlists.size();
    }
}