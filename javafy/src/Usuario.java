import java.util.ArrayList;

public class Usuario extends Pessoa {
    // Atributos
    private String login;
    private String senha;
    private ArrayList<Playlist> playlists = new ArrayList<>();

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

    // Métodos
    public void criarPlaylist(Playlist playlist){
        // implementar a lógica para possibilitar ao usuário a criação de uma nova playlist.
    }

    public void excluirPlaylist(String nomePlaylist){
        // implementar a lógica para procurar a playlist pelo nome e excluir.
            // Acho interessante fazer um prompt de confirmação para exclusão...
    }

    public void listarPlaylists(){
        // implementar a lógica para retornar uma lista das playlists do usuário.
    }
}
