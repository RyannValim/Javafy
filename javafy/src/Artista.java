import java.util.ArrayList;

public class Artista extends Pessoa {
    private ArrayList<Album> albuns;

    public Artista(String nome) {
        super(nome);
        this.albuns = new ArrayList<>();
    }

    public ArrayList<Album> getAlbuns() {
        return albuns;
    }

    public void setAlbuns(ArrayList<Album> albuns) {
        this.albuns = albuns;
    }

    // Adiciona um álbum ao artista e define este artista no álbum
    public void adicionarAlbum(Album album) {
        if (album != null && !albuns.contains(album)) {
            albuns.add(album);
            album.setArtista(this);
        }
    }

    // Remove o álbum com o título fornecido da lista de álbuns do artista
    public void removerAlbum(String tituloAlbum) {
        if (tituloAlbum == null || tituloAlbum.isEmpty()) {
            return;
        }
        albuns.removeIf(album -> album.getTituloAlbum().equalsIgnoreCase(tituloAlbum));
    }

    // Lista todos os álbuns do artista no console
    public void listarAlbuns() {
        if (albuns.isEmpty()) {
            System.out.println("O artista " + getNome() + " não possui álbuns cadastrados.");
            return;
        }
        System.out.println("Álbuns do artista " + getNome() + ":");
        for (Album album : albuns) {
            System.out.println("- " + album.getTituloAlbum() + " (lançado em: " + album.getDataLancamentoAlbum() + ")");
        }
    }
}
