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
        if (playlist == null || playlist.getMusicas().isEmpty()) {
            System.out.println("\nPlaylist vazia ou inválida.");
            return;
        }
        listaMusica.clear(); // Limpa a fila atual
        listaMusica.addAll(playlist.getMusicas()); // Adiciona todas as músicas da playlist
        tocarPlayer();
    }

    // Tocar uma música específica
    public void tocarMusica(Musica musica) {
        if (musica == null) {
            System.out.println("\nNão é possível tocar uma música nula.");
            return;
        }
        listaMusica.clear(); // Limpa a fila atual
        listaMusica.add(musica); // Adiciona apenas esta música
        tocarPlayer();
    }

    // Executar o player
    public void tocarPlayer() {
        if (listaMusica.isEmpty()) {
            System.out.println("\nNenhuma música na fila de reprodução.");
            return;
        }

        System.out.println("\nIniciando reprodução...");
        // Simula a reprodução de cada música na fila
        // Usamos um while para simular a fila real (remove cada música após "tocar")
        while (!listaMusica.isEmpty()) {
            Musica musicaAtual = listaMusica.poll(); // Pega e remove o primeiro elemento da fila
            System.out.println("\nTocando: " + musicaAtual.getTituloMusica() + " - " + musicaAtual.getArtista().getNome());
            System.out.println("Gênero: " + musicaAtual.getGeneroMusica());
            System.out.println("Duração: " + musicaAtual.getDuracaoMusicaEmFormatoMMSS()); // Usando o método formatado
            // Poderia adicionar um Thread.sleep() aqui para simular o tempo real de cada música
        }
        System.out.println("\nFim da fila de reprodução.");
    }

    // Pausar o player (apenas uma mensagem neste exemplo simples)
    // Se fosse um player real, teria estado e lógica para retomar.
    public void pausarPlayer() {
        if (listaMusica.isEmpty()) {
            System.out.println("\nNenhuma música está tocando para pausar.");
        } else {
            System.out.println("\nMúsica pausada (simulação).");
            // Em um player real, você não limparia a fila aqui, apenas mudaria um estado 'isPaused = true'
        }
    }


    // MÉTODO QUE ESTAVA FALTANDO OU COM PROBLEMAS
    // Pular para a próxima música (se houver)
    public void pularMusica() {
        if (listaMusica.isEmpty()) {
            System.out.println("\nNão há músicas na fila para pular.");
            return;
        }
        Musica musicaPulada = listaMusica.poll(); // Remove a música atual
        System.out.println("Pulou: " + musicaPulada.getTituloMusica());
        if (listaMusica.isEmpty()) {
            System.out.println("Fila de reprodução vazia. Nenhuma próxima música.");
        } else {
            System.out.println("Próxima música na fila: " + listaMusica.peek().getTituloMusica());
        }
    }

    // MÉTODO QUE ESTAVA FALTANDO OU COM PROBLEMAS
    // Parar o player e limpar a fila
    public void pararPlayer() {
        if (listaMusica.isEmpty()) {
            System.out.println("\nO player já está parado e a fila vazia.");
        } else {
            listaMusica.clear();
            System.out.println("\nPlayer parado e fila de reprodução limpa.");
        }
    }
}