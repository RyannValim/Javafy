import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

public class Album {
    // Atributos
    private String tituloAlbum;
    private Artista artista;
    private final LocalDate dataLancamentoAlbum; 
    private final ArrayList<Musica> musicas;
    private TipoAlbum tipo;

    // Construtor
    public Album(String tituloAlbum, Artista artista, LocalDate dataLancamentoAlbum){
        this.tituloAlbum = tituloAlbum;
        this.artista = artista;
        this.dataLancamentoAlbum = dataLancamentoAlbum; 
        this.musicas = new ArrayList<>();
        this.tipo = TipoAlbum.SINGLE;
    }

    // Getters e Setters
    public String getTituloAlbum(){
        return tituloAlbum;
    }
    public void setTituloAlbum(String tituloAlbum){
        if (tituloAlbum == null || tituloAlbum.trim().isEmpty()) {
            System.out.println("Erro: O título do álbum não pode ser vazio.");
            return;
        }
        this.tituloAlbum = tituloAlbum;
    }

    public Artista getArtista(){
        return artista;
    }
    public void setArtista(Artista artista){
        if (artista == null) {
            System.out.println("Erro: O artista do álbum não pode ser nulo.");
            return;
        }
        this.artista = artista;
    }

    public String getDataLancamentoAlbumFormatada(){
        return dataLancamentoAlbum.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    
    public LocalDate getLocalDateLancamentoAlbum() {
        return dataLancamentoAlbum;
    }

    public ArrayList<Musica> getMusicas(){
        return musicas;
    }

    public TipoAlbum getTipo(){
        return tipo;
    }
    public void setTipo(TipoAlbum tipo){
        this.tipo = tipo;
    }

    // Métodos
    private void atualizarTipo(){
        if(musicas.size() <= 1){
            this.tipo = TipoAlbum.SINGLE;
        } else{
            this.tipo = TipoAlbum.ALBUM;
        }
    }

    public void adicionarMusica(Musica musica){
        if (musica == null) {
            System.out.println("Erro: Não é possível adicionar uma música nula ao álbum.");
            return;
        }
        if(!musicas.contains(musica)){
            musicas.add(musica);
            atualizarTipo();
            System.out.println("Música '" + musica.getTituloMusica() + "' adicionada ao álbum '" + tituloAlbum + "'.");
        } else{
            System.out.println("A música '" + musica.getTituloMusica() + "' já está no álbum.");
        }
    }

    public void removerMusica(String tituloMusica){
        if (tituloMusica == null || tituloMusica.trim().isEmpty()) {
            System.out.println("Erro: O título da música para remover não pode ser vazio.");
            return;
        }

        Musica musicaParaRemover = null;
        for(Musica m : musicas){
            if(m.getTituloMusica().equalsIgnoreCase(tituloMusica)){
                musicaParaRemover = m;
                break;
            }
        }
        
        if(musicaParaRemover != null){
            musicas.remove(musicaParaRemover);
            atualizarTipo();
            System.out.println("Música '" + tituloMusica + "' removida do álbum '" + tituloAlbum + "'.");
        } else{
            System.out.println("Música '" + tituloMusica + "' não encontrada no álbum.");
        }
    }

    public void listarMusicas(){
        System.out.println("\n🎧 Álbum: " + tituloAlbum + " | Artista: " + artista.getNome() + " | Tipo: " + tipo);
        if(musicas.isEmpty()){
            System.out.println("Este álbum não possui músicas.");
        } else{
            System.out.println("Músicas:");
            int i = 1;
            for(Musica musica : musicas){
                System.out.println(i + ". " + musica.getTituloMusica() + " (" + musica.getDuracaoMusicaEmFormatoMMSS() + ")");
                i++;
            }
        }
        System.out.println("-----------------------------");
    }

    @Override
    public String toString() {
        return "Álbum: " + tituloAlbum + ", Artista: " + artista.getNome() +
               ", Lançamento: " + getDataLancamentoAlbumFormatada() + ", Tipo: " + tipo +
               ", Músicas: " + musicas.size();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(tituloAlbum, album.tituloAlbum) &&
               Objects.equals(artista, album.artista);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tituloAlbum, artista);
    }
}