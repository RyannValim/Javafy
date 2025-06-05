import java.util.ArrayList;

public class Album {
    // Atributos
    private String tituloAlbum;
    private Artista artista;
    private String dataLancamentoAlbum;
    private ArrayList<Musica> musicas = new ArrayList<>();
    private TipoAlbum tipo; // SINGLE ou ALBUM

    // Construtor
    public Album(String tituloAlbum, Artista artista, String dataLancamentoAlbum) {
        this.tituloAlbum = tituloAlbum;
        this.artista = artista;
        this.dataLancamentoAlbum = dataLancamentoAlbum;
        this.tipo = TipoAlbum.SINGLE; // Padrão
    }

    // Getters e Setters
    public String getTituloAlbum() {
        return tituloAlbum;
    }

    public void setTituloAlbum(String tituloAlbum) {
        this.tituloAlbum = tituloAlbum;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public String getDataLancamentoAlbum() {
        return dataLancamentoAlbum;
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(ArrayList<Musica> musicas) {
        this.musicas = musicas;
        atualizarTipo();
    }

    public TipoAlbum getTipo() {
        return tipo;
    }

    public void setTipo(TipoAlbum tipo) {
        this.tipo = tipo;
    }

    // 🔥 Método para atualizar o tipo (SINGLE ou ALBUM)
    private void atualizarTipo() {
        if (musicas.size() <= 1) {
            this.tipo = TipoAlbum.SINGLE;
        } else {
            this.tipo = TipoAlbum.ALBUM;
        }
    }

    // 🔥 Adicionar música no álbum
    public void adicionarMusica(Musica musica) {
        if (!musicas.contains(musica)) {
            musicas.add(musica);
            atualizarTipo();
            System.out.println("✅ Música '" + musica.getTituloMusica() + "' adicionada ao álbum '" + tituloAlbum + "'.");
        } else {
            System.out.println("⚠️ A música '" + musica.getTituloMusica() + "' já está no álbum.");
        }
    }

    // 🔥 Remover música pelo título
    public void removerMusica(String tituloMusica) {
        boolean removida = false;
        for (int i = 0; i < musicas.size(); i++) {
            if (musicas.get(i).getTituloMusica().equalsIgnoreCase(tituloMusica)) {
                musicas.remove(i);
                atualizarTipo();
                System.out.println("🗑️ Música '" + tituloMusica + "' removida do álbum '" + tituloAlbum + "'.");
                removida = true;
                break;
            }
        }
        if (!removida) {
            System.out.println("❌ Música '" + tituloMusica + "' não encontrada no álbum.");
        }
    }

    // 🔥 Listar músicas do álbum
    public void listarMusicas() {
        System.out.println("\n🎧 Álbum: " + tituloAlbum + " | Artista: " + artista.getNome() + " | Tipo: " + tipo);
        if (musicas.isEmpty()) {
            System.out.println("🚫 Este álbum não possui músicas.");
        } else {
            System.out.println("Músicas:");
            int i = 1;
            for (Musica musica : musicas) {
                System.out.println(i + ". " + musica.getTituloMusica() + " (" + musica.getDuracaoMusica() + ")");
                i++;
            }
        }
    }
}
