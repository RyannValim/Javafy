import java.util.LinkedList;
import java.util.Queue;

public class Player {
    private Queue<Musica> listaMusica;

    // Construtor
    public Player() {
        this.listaMusica = new LinkedList<>();
    }

    // Getter
    public Queue<Musica> getListaMusica() {
        return listaMusica;
    }

    // Tocar uma playlist inteira
    public void tocarPlaylist(Playlist playlist) {
        listaMusica.clear();
        listaMusica.addAll(playlist.getMusicas());
        tocarPlayer();
    }

    // Tocar uma música específica
    public void tocarMusica(Musica musica) {
        listaMusica.clear();
        listaMusica.add(musica);
        tocarPlayer();
    }

    // Executar o player
    public void tocarPlayer() {
        if (listaMusica.isEmpty()) {
            System.out.println("\n🚫 Nenhuma música na fila.");
        } else {
            System.out.println("\n▶️ Iniciando reprodução...");

            for (Musica m : listaMusica) {
                System.out.println("\n🎧 Tocando: " + m.getTituloMusica() + " - " + m.getArtista().getNome());
                System.out.println("Gênero: " + m.getGeneroMusica());
                System.out.println("Duração: " + m.getDuracaoMusica());
            }

            System.out.println("\n✅ Fim da fila de reprodução.");
        }
    }

    // Pausar o player
    public void pausarPlayer() {
        if (listaMusica.isEmpty()) {
            System.out.println("\n🚫 Nenhuma música está tocando para pausar.");
        } else {
            System.out.println("\n⏸️ Música pausada.");
        }
    }
}
