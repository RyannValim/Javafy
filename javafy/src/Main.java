import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        // --- Dados estáticos iniciais ---

        // Usuários
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Lucas", "lucas@javafy.com", "lucas", "C@xinha123"));
        usuarios.add(new Usuario("Christian", "chris@javafy.com", "chris", "Ris@lis456"));
        usuarios.add(new Usuario("Ryann", "ryann@javafy.com", "ryann", "P@odiQueijo789"));

        // Artista
        Artista artista1 = new Artista("Freddie Mercury");

        // Músicas (data como String, conforme sua alteração)
        Musica musica1 = new Musica(artista1, "Bohemian Rhapsody", "Rock", "5:55", "31/10/1975");
        Musica musica2 = new Musica(artista1, "Don't Stop Me Now", "Rock", "3:29", "26/01/1979");

        // Álbuns
        Album album1 = new Album("A Night at the Opera", artista1, "31/10/1975");
        album1.adicionarMusica(musica1);

        Album album2 = new Album("Jazz", artista1, "10/11/1978");
        album2.adicionarMusica(musica2);

        artista1.adicionarAlbum(album1);
        artista1.adicionarAlbum(album2);

        // Playlist

        Playlist playlist1 = new Playlist("Favoritas Rock", usuarios.get(0)); // Lucas como dono
        playlist1.adicionarMusica(musica1);
        playlist1.adicionarMusica(musica2);


        // -----------------------------------

        int choice = -1;

        while (choice != 0) {

            Menu.cabecalho();
            Menu.escolhas();

            System.out.println("Faça sua escolha: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                // Login
                boolean logado = false;
                Integer returno = -1;
                Integer tentativas = 0;

                while (tentativas < 3 && !logado) {
                    Menu.cabecalho();

                    System.out.print("Digite seu usuario: ");
                    String userLogin = sc.nextLine();

                    System.out.print("Digite sua senha: ");
                    String senhaLogin = sc.nextLine();

                    for (Usuario user : usuarios) {
                        if (user.getLogin().equals(userLogin) && user.getSenha().equals(senhaLogin)) {
                            logado = true;
                            Menu.cabecalho();
                            Menu.cabecalhoParteInterna();
                            System.out.println("Login realizado com sucesso!");
                            // Chamar função do aplicativo
                        }
                    }

                    if (!logado) {
                        tentativas++;
                        Menu.cabecalho();
                        Menu.loginErrado();
                        System.out.println("Tentativa " + tentativas + " de 3!");

                        if (tentativas == 3) {
                            System.out.println("Numero maximo de tentativas atingido, retornando ao menu principal!");
                        }
                    }

                    returno = sc.nextInt();
                    if (returno == 0) {
                        break;
                    }
                }

            } else if (choice == 2) {
                // Criar Conta

                Integer retorno = -1;

                while (retorno != 0) {

                    Menu.cabecalho();

                    System.out.print("Digite seu nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Digite o email: ");
                    String email = sc.nextLine();

                    System.out.print("Digito o seu usuario: ");
                    String user = sc.nextLine();

                    System.out.print("Digite a senha: ");
                    String senha = sc.nextLine();

                    if (Validador.validarEmail(email) && Validador.validarSenha(senha)) {
                        usuarios.add(new Usuario(nome, email, user, senha));
                        System.out.print("\nUsuario cadastrado com sucesso! \nDigite 0 para retornar.");
                        retorno = sc.nextInt();
                        if (retorno == 0)
                            break;
                    } else {
                        System.out.println("Email ou Senha nao atingiram os requisitos minimos. Tente novamente!");
                    }
                }

            } else if (choice == 3) {
                // Entrar como convidado

                Menu.cabecalho();
                Menu.cabecalhoParteInterna();
            } else if (choice == 4) {
                // Entrar como administrador / Artista no nosso caso

                Menu.cabecalho();
            } else if (choice == 5) {
                // Sobre o aplicativo

                Menu.cabecalho();
                Menu.cabecalhoSobreAplicativo();
            } else if (choice == 0) {
                Menu.cabecalho();
                Menu.finalizarPrograma();
            } else {
                Menu.cabecalho();
                Menu.escolhaErrada();
            }
        }

        sc.close();

        Player player = new Player();

    // Tocando uma música específica
    System.out.println("\n--- Tocando uma música específica ---");
    player.tocarMusica(musica1);

    // Tocando uma playlist
    System.out.println("\n--- Tocando uma playlist ---");
    player.tocarPlaylist(playlist1);

    // Tocando o que está no player atualmente
    System.out.println("\n--- Tocando novamente o que está no player ---");
    player.tocarPlayer();

    // Pausando o player
    System.out.println("\n--- Pausando o player ---");
    player.pausarPlayer();

    }
}
