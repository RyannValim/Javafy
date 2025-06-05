import java.util.LinkedList;
import java.util.Queue;

public class Player {
    private Queue<Musica> listaMusica;

    // Construtor
    public Player() {
        this.listaMusica = new LinkedList<>();
    }

    // Getters
    public Queue<Musica> getListaMusica() {
        return listaMusica;
    }

    // Métodos
    public void tocarPlaylist(Playlist playlist) {
        listaMusica.clear();
        listaMusica.addAll(playlist.getMusicas());
        tocarPlayer();
    }

    public void tocarMusica(Musica musica) {
        listaMusica.clear();
        listaMusica.add(musica);
        tocarPlayer();
    }

    public void tocarPlayer() {
        if (listaMusica.isEmpty()) {
            System.out.println("Nenhuma música na fila.");
        } else {
            System.out.println("Tocando...");
            for (Musica m : listaMusica) {
                System.out.println("♪ " + m.getTituloMusica() + " - " + m.getArtista().getNome());
            }
        }
    }

    public void pausarPlayer() {
        System.out.println("Música pausada.");
    }
}
