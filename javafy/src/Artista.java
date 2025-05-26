import java.util.ArrayList;

public class Artista extends Pessoa {
    // Atributos
    private ArrayList<Album> albuns;

    // Construtor
    public Artista(String nome, String email){
        super(nome, email);
        this.albuns = new ArrayList<>();
    }

    // Getters/Setters
    public ArrayList<Album> getAlbuns(){
        return albuns;
    }
    public void setAlbuns(ArrayList<Album> albuns){
        this.albuns = albuns;
    }

    // Métodos
    public void adicionarAlbum(Album album){
        // implementar a lógica que permite o artista adicionar um álbum em seu perfil musical.
    }

    public void listarAlbuns(){
        // implementar a lógica para listar todos os álbuns do artista.
    }
}
