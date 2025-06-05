import java.util.ArrayList;
import java.util.Objects;

public class Artista extends Pessoa {
    // Atributos
    private final ArrayList<Album> albuns;

    // Construtor
    public Artista(String nome, String email) {
        super(nome, email);
        this.albuns = new ArrayList<>();
    }

    // Getter/Setter
    public ArrayList<Album> getAlbuns() {
        return albuns;
    }

    // Métodos
    public void adicionarAlbum(Album album) {
        if (album != null && !albuns.contains(album)) {
            albuns.add(album);
            album.setArtista(this);
            System.out.println("Álbum '" + album.getTituloAlbum() + "' adicionado ao artista " + getNome() + ".");
        } else if (album != null) {
            System.out.println("Erro: Álbum '" + album.getTituloAlbum() + "' já existe para o artista " + getNome() + ".");
        } else {
            System.out.println("Erro: Não é possível adicionar um álbum nulo.");
        }
    }

    public void removerAlbum(String tituloAlbum) {
        if (tituloAlbum == null || tituloAlbum.trim().isEmpty()) {
            System.out.println("Erro: O título do álbum para remover não pode ser vazio.");
            return;
        }

        Album albumParaRemover = null;
        for (Album album : albuns) {
            if (album.getTituloAlbum().equalsIgnoreCase(tituloAlbum)) {
                albumParaRemover = album;
                break;
            }
        }

        if (albumParaRemover != null) {
            albuns.remove(albumParaRemover);
            System.out.println("Álbum '" + tituloAlbum + "' removido do artista " + getNome() + ".");
        } else {
            System.out.println("Erro: Álbum '" + tituloAlbum + "' não encontrado para o artista " + getNome() + ".");
        }
    }

    public void listarAlbuns() {
        if (albuns.isEmpty()) {
            System.out.println("O artista " + getNome() + " não possui álbuns cadastrados.");
            return;
        }
        System.out.println("\n--- Álbuns do artista " + getNome() + " ---");
        for (int i = 0; i < albuns.size(); i++) {
            Album album = albuns.get(i);
            System.out.println((i + 1) + ". " + album.getTituloAlbum() + " (lançado em: " + album.getDataLancamentoAlbumFormatada() + ")");
        }
        System.out.println("------------------------------------");
    }

    @Override
    public String toString() {
        return "Artista: " + getNome() +
               " | Email: " + getEmail() +
               " | Total de Álbuns: " + albuns.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        // Chama o equals da superclasse Pessoa
        if (!super.equals(o)) return false;

        Artista artista = (Artista) o;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }
}