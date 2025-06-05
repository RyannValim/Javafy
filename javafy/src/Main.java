import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Início do Teste do Javafy ===");

        // 1. Criando Artistas
        Artista queen = new Artista("Queen", "queen@email.com"); // Adicionei email para consistência com Pessoa
        Artista michaelJackson = new Artista("Michael Jackson", "mj@email.com");
        System.out.println("\n--- Artistas Criados ---");
        System.out.println(queen);
        System.out.println(michaelJackson);
        
        // 2. Criando Músicas (Duração agora é int em segundos)
        Musica bohemianRhapsody = new Musica(queen, "Bohemian Rhapsody", "Rock", 355, LocalDate.of(1975, 10, 31)); // 5 minutos e 55 segundos
        Musica dontStopMeNow = new Musica(queen, "Don't Stop Me Now", "Rock", 209, LocalDate.of(1979, 1, 26)); // 3 minutos e 29 segundos
        Musica thriller = new Musica(michaelJackson, "Thriller", "Pop", 357, LocalDate.of(1982, 11, 30)); // 5 minutos e 57 segundos
        Musica billieJean = new Musica(michaelJackson, "Billie Jean", "Pop", 294, LocalDate.of(1982, 11, 30)); // 4 minutos e 54 segundos

        System.out.println("\n--- Músicas Criadas ---");
        bohemianRhapsody.exibirInfo();
        dontStopMeNow.exibirInfo();
        thriller.exibirInfo();
        billieJean.exibirInfo();

        // 3. Criando Álbuns
        Album singleBohemian = new Album("Bohemian Rhapsody (Single)", queen, LocalDate.of(1975, 10, 31));
        singleBohemian.adicionarMusica(bohemianRhapsody);
        System.out.println("\n--- Teste de Single ---");
        singleBohemian.listarMusicas();
        System.out.println("Tipo do single: " + singleBohemian.getTipo()); // Deve ser SINGLE

        Album aNightAtTheOpera = new Album("A Night at the Opera", queen, LocalDate.of(1975, 11, 21));
        aNightAtTheOpera.adicionarMusica(bohemianRhapsody);
        aNightAtTheOpera.adicionarMusica(new Musica(queen, "Love of My Life", "Rock", 218, LocalDate.of(1975, 11, 21)));
        aNightAtTheOpera.adicionarMusica(new Musica(queen, "Prophet's Song", "Rock", 481, LocalDate.of(1975, 11, 21)));
        System.out.println("\n--- Teste de Álbum Completo ---");
        aNightAtTheOpera.listarMusicas();
        System.out.println("Tipo do álbum: " + aNightAtTheOpera.getTipo()); // Deve ser ALBUM

        Album thrillerAlbum = new Album("Thriller", michaelJackson, LocalDate.of(1982, 11, 30));
        thrillerAlbum.adicionarMusica(thriller);
        thrillerAlbum.adicionarMusica(billieJean);
        System.out.println("\n--- Teste de Álbum Thriller ---");
        thrillerAlbum.listarMusicas();

        // 4. Testando métodos do Artista
        queen.adicionarAlbum(aNightAtTheOpera);
        queen.adicionarAlbum(singleBohemian);
        queen.listarAlbuns();

        michaelJackson.adicionarAlbum(thrillerAlbum);
        michaelJackson.listarAlbuns();

        System.out.println("\n--- Removendo álbum do Artista ---");
        queen.removerAlbum("Bohemian Rhapsody (Single)");
        queen.listarAlbuns();

        // 5. Criando Usuários
        Usuario user1 = new Usuario("Alice Silva", "alice@javafy.com", "alice.s", "senha123");
        Usuario user2 = new Usuario("Bob Santos", "bob@javafy.com", "bob.s", "outrasenha");

        System.out.println("\n--- Usuários Criados ---");
        System.out.println(user1);
        System.out.println(user2);

        // 6. Testando Playlists do Usuário
        System.out.println("\n--- Gerenciamento de Playlists do Alice ---");
        user1.criarPlaylist("Minhas Favoritas");
        user1.criarPlaylist("Rock Clássico");
        user1.criarPlaylist("Rock Clássico"); // Tentando criar duplicata
        user1.listarPlaylists();

        // Adicionando músicas às playlists
        System.out.println("\n--- Adicionando músicas à playlist 'Rock Clássico' ---");
        Playlist rockClassico = null;
        for (Playlist p : user1.getPlaylists()) {
            if (p.getNomePlaylist().equals("Rock Clássico")) {
                rockClassico = p;
                break;
            }
        }

        if (rockClassico != null) {
            rockClassico.adicionarMusica(bohemianRhapsody);
            rockClassico.adicionarMusica(dontStopMeNow);
            rockClassico.adicionarMusica(bohemianRhapsody); // Tentando adicionar duplicata
            rockClassico.listarMusicas();
        }

        System.out.println("\n--- Removendo música da playlist 'Rock Clássico' ---");
        if (rockClassico != null) {
            rockClassico.removerMusica("Don't Stop Me Now");
            rockClassico.listarMusicas();
            rockClassico.removerMusica("Música Inexistente"); // Tentando remover inexistente
        }

        System.out.println("\n--- Adicionando músicas à playlist 'Minhas Favoritas' ---");
        Playlist minhasFavoritas = null;
        for (Playlist p : user1.getPlaylists()) {
            if (p.getNomePlaylist().equals("Minhas Favoritas")) {
                minhasFavoritas = p;
                break;
            }
        }
        if (minhasFavoritas != null) {
            minhasFavoritas.adicionarMusica(thriller);
            minhasFavoritas.adicionarMusica(billieJean);
            minhasFavoritas.listarMusicas();
        }

        System.out.println("\n--- Excluindo playlist do Alice ---");
        user1.excluirPlaylist("Minhas Favoritas");
        user1.excluirPlaylist("Playlist Inexistente");
        user1.listarPlaylists();

        // 7. Testando o Player
        Player player = new Player();

        System.out.println("\n--- Testando Player com Playlist ---");
        if (rockClassico != null) {
            player.tocarPlaylist(rockClassico);
        } else {
            System.out.println("Playlist 'Rock Clássico' não encontrada para tocar.");
        }
        
        System.out.println("\n--- Testando Player com Música Única ---");
        player.tocarMusica(billieJean);
        
        System.out.println("\n--- Testando Pausar Player ---");
        player.pausarPlayer();
        
        System.out.println("\n--- Testando Pular Música ---");
        player.tocarMusica(bohemianRhapsody); // Coloca uma música na fila
        player.pularMusica(); // Pula a música
        player.pularMusica(); // Tenta pular sem música na fila
        
        System.out.println("\n--- Testando Parar Player ---");
        player.tocarMusica(thriller); // Coloca uma música
        player.pararPlayer(); // Para e limpa

        System.out.println("\n=== Fim do Teste do Javafy ===");
    }
}

        // -----------------------------------

        /*int choice = -1;

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
*/