import java.util.ArrayList;
import java.util.Scanner;

public class Usuario extends Pessoa{
    // Atributos
    private String login;
    private String senha;
    private ArrayList<Playlist> playlists;

    // Construtor
    public Usuario(String nome, String email, String login, String senha){
        super(nome, email); // Chamando o construtor da superclasse Pessoa.
        this.login = login;
        this.senha = senha;
        this.playlists = new ArrayList<>(); // Inicializando playlists no construtor.
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
    @Override
    public String toString(){
        // Aproveita o toString da superclasse Pessoa
        return "Usuário: " + getNome() +
               " | Email: " + getEmail() +
               " | Login: " + login +
               " | Playlists: " + playlists.size();
    }

    public void criarPlaylist(String nomePlaylist){
        if(nomePlaylist == null || nomePlaylist.trim().isEmpty()){
            System.out.println("Erro: O nome da playlist não pode ser vazio.");
            return;
        }

        // Verifica se já existe uma playlist com o mesmo nome para este usuário
        for(Playlist p : this.playlists){
            if(p.getNomePlaylist().equalsIgnoreCase(nomePlaylist)){
                System.out.println("Erro: Já existe uma playlist com o nome '" + nomePlaylist + "'.");
                return;
            }
        }

        // Cria a nova playlist e a adiciona à lista do usuário
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

        if (playlistParaExcluir != null) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Tem certeza que deseja excluir a playlist '" + nomePlaylist + "'? (s/n): ");
            String confirmacao = scan.nextLine();
            if (confirmacao.equalsIgnoreCase("s")) {
                this.playlists.remove(playlistParaExcluir);
                System.out.println("Playlist '" + nomePlaylist + "' excluída com sucesso.");
            } else {
               System.out.println("Exclusão cancelada.");
            }
            scan.close();
        } else {
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
}