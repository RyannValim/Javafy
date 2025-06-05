import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void realizarLogin(List<Usuario> usuarios, Scanner sc) throws InterruptedException{
        boolean logado = false;
        int tentativas = 0;
        Usuario usuarioLogado = null;

        while (tentativas < 3 && !logado) {
            Menu.cabecalho();
            System.out.print("Digite seu usuário: ");
            String userLogin = sc.nextLine();
            System.out.print("Digite sua senha: ");
            String senhaLogin = sc.nextLine();

            for (Usuario user : usuarios) {
                if (user.getLogin().equals(userLogin) && user.getSenha().equals(senhaLogin)) {
                    logado = true;
                    usuarioLogado = user;
                    break;
                }
            }

            if (!logado) {
                tentativas++;
                Menu.loginErrado();
                System.out.println("Tentativa " + tentativas + " de 3!");
                if (tentativas == 3) {
                    System.out.println("Número máximo de tentativas atingido.");
                    return;
                }
            }
        }

        if (logado) {
            Menu.cabecalhoParteInterna();
            System.out.println("Login realizado com sucesso!");
            menuUsuario(usuarioLogado, sc);
        }
    }

    public static void menuUsuario(Usuario usuario, Scanner sc) {
        int escolha = -1;

        while (escolha != 0) {
            System.out.println("\n--- Menu do Usuário ---");
            System.out.println("1. Criar Playlist");
            System.out.println("2. Adicionar Música à Playlist");
            System.out.println("3. Listar Playlists");
            System.out.println("4. Tocar Playlist");
            System.out.println("5. Remover Música de Playlist");
            System.out.println("6. Excluir Playlist");
            System.out.println("0. Sair");

            System.out.print("Escolha: ");
            escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Nome da nova Playlist: ");
                    String nome = sc.nextLine();
                    usuario.criarPlaylist(nome);
                    break;

                case 2:
                    System.out.print("Digite o nome da Playlist: ");
                    String nomePlaylist = sc.nextLine();
                    Playlist playlist = usuario.getPlaylist(nomePlaylist);
                    
                    if (playlist == null) {
                        System.out.println("Playlist não encontrada.");
                    } else {
                        Main.listarMusicasDisponiveis();
                        System.out.print("Escolha o número da música para adicionar: ");
                        int numMusica = sc.nextInt();
                        sc.nextLine();

                        Musica musicaSelecionada = null;
                        switch (numMusica) {
                            case 1: musicaSelecionada = Main.bohemianRhapsody; break;
                            case 2: musicaSelecionada = Main.thriller; break;
                            default: 
                                System.out.println("Opção inválida.");
                                break;
                        }

                        if (musicaSelecionada != null) {
                            playlist.adicionarMusica(musicaSelecionada);
                        }
                    }
                    break;

                case 3:
                    usuario.listarPlaylists();
                    break;

                case 4:
                    System.out.print("Nome da Playlist: ");
                    String nomePlay = sc.nextLine();
                    Playlist play = usuario.getPlaylist(nomePlay);

                    if (play != null) {
                        System.out.println("Tocando playlist: " + play.getNomePlaylist());
                        play.listarMusicas();
                    } else {
                        System.out.println("Playlist não encontrada.");
                    }
                    break;

                case 5:
                    System.out.print("Nome da Playlist: ");
                    String nomePl = sc.nextLine();
                    Playlist pl = usuario.getPlaylist(nomePl);

                    if (pl != null) {
                        System.out.print("Título da música para remover: ");
                        String tituloRemover = sc.nextLine();

                        pl.removerMusica(tituloRemover);
                    } else {
                        System.out.println("Playlist não encontrada.");
                    }
                    break;

                case 6:
                    System.out.print("Nome da Playlist para excluir: ");
                    String nomeExcluir = sc.nextLine();
                    usuario.excluirPlaylist(nomeExcluir);
                    break;

                case 0:
                    System.out.println("Saindo do menu do usuário...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }


    public static void menuArtista(List<Artista> artistas, Scanner sc) {
        System.out.print("Digite o nome do artista: ");
        String nome = sc.nextLine();
        System.out.print("Digite o email do artista: ");
        String email = sc.nextLine();

        Artista artista = new Artista(nome, email);
        artistas.add(artista);

        int escolha = -1;

        while (escolha != 0) {
            System.out.println("\n--- Menu do Artista ---");
            System.out.println("1. Criar Álbum");
            System.out.println("2. Adicionar Música ao Álbum");
            System.out.println("3. Listar Álbuns");
            System.out.println("4. Remover Álbum");
            System.out.println("0. Sair");

            System.out.print("Escolha: ");
            escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case 1:
                    // Criar Álbum
                    break;
                case 2:
                    // Adicionar Música
                    break;
                case 3:
                    artista.listarAlbuns();
                    break;
                case 4:
                    System.out.print("Nome do álbum para remover: ");
                    String nomeAlbum = sc.nextLine();
                    artista.removerAlbum(nomeAlbum);
                    break;
                case 0:
                    System.out.println("Saindo do menu do artista...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static void menuConvidado(Scanner sc) {
        System.out.println("\nBem-vindo, convidado!");
        System.out.println("Você pode navegar e ouvir prévias de músicas!");
        System.out.println("Pressione Enter para voltar.");
        sc.nextLine();
    }


    public static void criarConta(List<Usuario> usuarios, Scanner sc) throws InterruptedException{
        Menu.cabecalho();
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();

        Integer a = 0;

        while(a != 1){
            System.out.print("Digite o email: ");
            String email = sc.nextLine();

            System.out.print("Digite seu usuário: ");
            String user = sc.nextLine();

            System.out.print("Digite a senha: ");
            String senha = sc.nextLine();

            if (Validador.validarEmail(email) && Validador.validarSenha(senha)) {
                usuarios.add(new Usuario(nome, email, user, senha));
                System.out.println("\nUsuário cadastrado com sucesso!");
                a = 1;
            } else {
                System.out.println("Email ou Senha não atingiram os requisitos mínimos. Tente novamente!");
            }
        }
    }

    public static Artista queen = new Artista("Queen", "queen@email.com");
    public static Artista michaelJackson = new Artista("Michael Jackson", "mj@email.com");

    public static Musica bohemianRhapsody = new Musica(queen, "Bohemian Rhapsody", "Rock", 355, LocalDate.of(1975, 10, 31));
    public static Musica thriller = new Musica(michaelJackson, "Thriller", "Pop", 357, LocalDate.of(1982, 11, 30));

    public static void listarMusicasDisponiveis() {
        System.out.println("Músicas disponíveis:");
        System.out.println("1. " + bohemianRhapsody);
        System.out.println("2. " + thriller);
    }
    public static void main(String[] args) throws InterruptedException{
        Scanner sc = new Scanner(System.in);

        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<Artista> artistas = new ArrayList<>();
        ArrayList<Musica> musicas = new ArrayList<>();
        ArrayList<Album> albuns = new ArrayList<>();

        // --- Dados Estáticos ---
        Artista queen = new Artista("Queen", "queen@email.com");
        Artista michaelJackson = new Artista("Michael Jackson", "mj@email.com");
        artistas.add(queen);
        artistas.add(michaelJackson);

        Musica bohemianRhapsody = new Musica(queen, "Bohemian Rhapsody", "Rock", 355, LocalDate.of(1975, 10, 31));
        Musica thriller = new Musica(michaelJackson, "Thriller", "Pop", 357, LocalDate.of(1982, 11, 30));
        musicas.add(bohemianRhapsody);
        musicas.add(thriller);

        // etc... outros dados

        Usuario exemploUser = new Usuario("Alice", "alice@javafy.com", "alice.s", "123");
        usuarios.add(exemploUser);

        // --- Loop principal ---
        int choice = -1;

        while (choice != 0) {
            Menu.cabecalho();
            Menu.escolhas();

            System.out.print("Faça sua escolha: ");
            choice = sc.nextInt();
            sc.nextLine(); // Limpar o buffer

            switch (choice) {
                case 1:
                    // Login
                    realizarLogin(usuarios, sc);
                    break;
                case 2:
                    // Criar Conta
                    criarConta(usuarios, sc);
                    break;
                case 3:
                    // Entrar como convidado
                    Menu.cabecalhoParteInterna();
                    menuConvidado(sc);
                    break;
                case 4:
                    // Entrar como Artista
                    menuArtista(artistas, sc);
                    break;
                case 5:
                    // Sobre o aplicativo
                    Menu.cabecalhoSobreAplicativo();
                    break;
                case 0:
                    Menu.finalizarPrograma();
                    break;
                default:
                    Menu.escolhaErrada();
            }
        }


        sc.close();
    }
}