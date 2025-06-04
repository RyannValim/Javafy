public class Menu {


    public static void cabecalho() throws InterruptedException{
        limparTela();
        System.out.println("======================================================================================================");
        System.out.println("|                                                                                                    |");
        System.out.println("|                                                                                 !                  |");
        System.out.println("|                                                                                 |    |~/           |");
        System.out.println("|                                                                                 |   _|~            |");
        System.out.println("|           _                  ______                               .============.|  (_|   |~/       |");
        System.out.println("|          | |                |  ____|                             .-;____________;|.      _|~       |");
        System.out.println("|          | | __ _ _   ____ _| |__ _   _                         | [_________I__] |     (_|         |");
        System.out.println("|      _   | |/ _` | | / / _` |  __| | | |                        |  ''''' (_) (_) |                 |");
        System.out.println("|     | |__| | (_| || V / (_| | |  | |_| |                        | .=====..=====. |                 |");
        System.out.println("|     |______/___,_| |_/|___,_|_|  |___, |                        | |:::::||:::::| |                 |");
        System.out.println("|                                    __/ |                        | '=====''=====' |                 |");
        System.out.println("|                                   |___/                         '----------------'                 |");
        System.out.println("|                                                                                                    |");
        System.out.println("======================================================================================================");
        Thread.sleep(200);

        
    }

    // Parte interna
    public static void cabecalhoParteInterna() throws InterruptedException {
        cabecalho();
        System.out.println("|                                                                                                    |");
        System.out.println("|              Esta seria a parte interna do aplicativo, com a interface para tocar musicas          |");
        System.out.println("|                                                                                                    |");
        System.out.println("|             Aqui, a partir de uma biblioteca o usuario poderia escolher musicas e faze-las         |");
        System.out.println("|              tocar, tipo um player. Pretendemos expandir o projeto mais para frente, pois          |");
        System.out.println("|                  achar um jeito de fazer a musica tocar conforme a playlist do usuario             |");
        System.out.println("|                                   nao foi tao facil quanto pensamos.                               |");
        System.out.println("|                                                                                                    |");
        System.out.println("|                                   Aperte '0' para voltar para o menu                               |");
        System.out.println("|                                                                                                    |");
        System.out.println("======================================================================================================");
    }

    // Menu escolhas
    public static void escolhas() {
        System.out.println("|                                                                                                    |");
        System.out.println("|              [1] Login                                                                             |");
        System.out.println("|              [2] Criar Conta                                                                       |");
        System.out.println("|              [3] Entrar como convidado                                                             |");
        System.out.println("|              [4] Entrar como administrador                                                         |");
        System.out.println("|              [5] Sobre o aplicativo                                                                |");
        System.out.println("|                                                                                                    |");
        System.out.println("|              [0] Sair                                                                              |");
        System.out.println("|                                                                                                    |");
        System.out.println("======================================================================================================");
    }

    // Escolha errada
    public static void escolhaErrada() throws InterruptedException {
        limparTela();
        cabecalho();
        System.out.println("|                                                                                                    |");
        System.out.println("|                    Voce selecionou uma opcao errada. Por favor, tente novamente!                   |");
        escolhas();
    }

    // Nenhuma conta
    public static void loginErrado() throws InterruptedException {
        limparTela();
        cabecalho();
        System.out.println("|                                                                                                    |");
        System.out.println("|                Usuario ou senha não conferem! Tente novamente.                                     |");
    }

    // Finalizar programa
    public static void finalizarPrograma() throws InterruptedException {
        cabecalho();
        System.out.println("|                                                                                                    |");
        System.out.println("|                                 Muito obrigado e ate uma proxima vez!                              |");
        System.out.println("|                                                                                                    |");
        System.out.println("======================================================================================================");
        Thread.sleep(500);
        System.exit(0);
    }

    // Info cadastro
    public static void infoCadastro() throws InterruptedException {
        cabecalho();
        System.out.println("|                                                                                                    |");
        System.out.println("|                     Digite o numero '0' no campo 'E-mail' para voltar ao menu.                     |");
        System.out.println("|                                                                                                    |");
        System.out.println("======================================================================================================");
    }

    // Sobre o aplicativo
    public static void cabecalhoSobreAplicativo() throws InterruptedException {
        cabecalho();
        System.out.println("|                                                                                                    |");
        System.out.println("|               Bem-vindo ao nosso aplicativo Javafy, um Music Player inteiro em Java!               |");
        System.out.println("|                                                                                                    |");
        System.out.println("|       Somos um grupo de tres estudantes do 3o periodo de Ciencia da Computacao na UP:              |");
        System.out.println("|                    Lucas Haboski, Ryann Valim e Christian Andrade.                                 |");
        System.out.println("|                                                                                                    |");
        System.out.println("|        Nosso app permite que voce cadastre usuarios, crie playlists e curta suas musicas!          |");
        System.out.println("|                                                                                                    |");
        System.out.println("|                                                                                                    |");
        System.out.println("|                             Aperte (0) para voltar para o Menu                                     |");
        System.out.println("|                                                                                                    |");
        System.out.println("======================================================================================================");
    }

    // Convidado
    public static void acessarConvidado() throws InterruptedException {
        cabecalho();
        System.out.println("|                                                                                                    |");
        System.out.println("|                Seja vem vindo convidado! Voce sera redirecionado em instantes.                     |");
        System.out.println("|                                                                                                    |");
        System.out.println("======================================================================================================");
        Thread.sleep(3000);
    }

    // Admin escolhas
    public static void escolhasAdmin() throws InterruptedException {
        limparTela();
        cabecalho();
        System.out.println("|                                                                                                    |");
        System.out.println("|              [1] Listar usuarios                                                                   |");
        System.out.println("|              [2] Excluir uma conta                                                                 |");
        System.out.println("|              [3] Desativar uma conta                                                               |");
        System.out.println("|              [4] Procurar por um usuario                                                           |");
        System.out.println("|                                                                                                    |");
        System.out.println("|              [0] Sair                                                                              |");
        System.out.println("|                                                                                                    |");
        System.out.println("======================================================================================================");
    }

    // Admin escolha errada
    public static void escolhasAdminErrada() throws InterruptedException {
        limparTela();
        cabecalho();
        System.out.println("|                                                                                                    |");
        System.out.println("|                    Voce selecionou uma opcao errada. Por favor, tente novamente!                   |");
        escolhasAdmin();
    }

    private static void limparTela() {
        for (int i = 0; i < 50; ++i) System.out.println();
    }

    /*  */
}
