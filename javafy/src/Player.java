import java.util.LinkedList;
import java.util.Queue;

public class Player {
    // Atributos
    private Queue<Musica> listaMusica;

    // Construtor
    public Player() {
        this.listaMusica = new LinkedList<>();
    }

    // Getters/Setters
    public Queue<Musica> getListaMusica() {
        return listaMusica;
    }

    // Métodos
    public void tocarPlaylist(Playlist playlist) {
        if (playlist == null || playlist.getMusicas().isEmpty()) {
            System.out.println("\nPlaylist vazia ou inválida.");
            return;
        }

        listaMusica.clear();
        listaMusica.addAll(playlist.getMusicas());

        tocarPlayer();
    }

    public void tocarMusica(Musica musica) {
        if (musica == null) {
            System.out.println("\nNão é possível tocar uma música nula.");
            return;
        }

        listaMusica.clear();
        listaMusica.add(musica);
        tocarPlayer();
    }

    public void tocarPlayer() {
        if (listaMusica.isEmpty()) {
            System.out.println("\nNenhuma música na fila de reprodução.");
            return;
        }

        System.out.println("\nIniciando reprodução...");

        while (!listaMusica.isEmpty()) {
            Musica musicaAtual = listaMusica.poll();
            System.out.println("\nTocando: " + musicaAtual.getTituloMusica() + " - " + musicaAtual.getArtista().getNome());
            System.out.println("Gênero: " + musicaAtual.getGeneroMusica());
            System.out.println("Duração: " + musicaAtual.getDuracaoMusicaEmFormatoMMSS());
        }

        System.out.println("\nFim da fila de reprodução.");
    }

    public void pausarPlayer() {
        if (listaMusica.isEmpty()) {
            System.out.println("\nNenhuma música está tocando para pausar.");
        } else {
            System.out.println("\nMúsica pausada (simulação).");
        }
    }

    public void pularMusica() {
        if (listaMusica.isEmpty()) {
            System.out.println("\nNão há músicas na fila para pular.");
            return;
        }

        Musica musicaPulada = listaMusica.poll();
        System.out.println("Pulou: " + musicaPulada.getTituloMusica());

        if (listaMusica.isEmpty()) {
            System.out.println("Fila de reprodução vazia. Nenhuma próxima música.");
        } else {
            System.out.println("Próxima música na fila: " + listaMusica.peek().getTituloMusica());
        }
    }

    public void pararPlayer() {
        if (listaMusica.isEmpty()) {
            System.out.println("\nO player já está parado e a fila vazia.");
        } else {
            listaMusica.clear();
            System.out.println("\nPlayer parado e fila de reprodução limpa.");
        }
    }
}
