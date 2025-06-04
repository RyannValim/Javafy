import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) throws InterruptedException{

        Scanner sc = new Scanner(System.in);

        ArrayList<Usuario> usuarios = new ArrayList<>();

        int choice = -1;


        while(choice != 0){

            Menu.cabecalho();
            Menu.escolhas();

            System.out.println("Faça sua escolha: ");
            choice = sc.nextInt();
            sc.nextLine();

            if(choice == 1){
                // Login
                boolean logado = false;
                Integer returna = -1;
                Integer tentativas = 0;

                while(tentativas < 3 && !logado){
                    Menu.cabecalho();

                    System.out.print("Digite seu usuario: ");
                    String userLogin = sc.nextLine();

                    System.out.print("Digite sua senha: ");
                    String senhaLogin = sc.nextLine();

                    
                    
                    for(Usuario user : usuarios) {
                        if (user.getLogin().equals(userLogin) && user.getSenha().equals(senhaLogin)){
                            logado = true;
                            Menu.cabecalho();
                            Menu.cabecalhoParteInterna();
                            System.out.println("Login realizado com sucesso!");
                            //Chamar função do aplcativo
                        }
                    }

                    if (!logado){
                        tentativas++;
                        Menu.cabecalho();
                        Menu.loginErrado();
                        System.out.println("Tentativa" + tentativas + " de 3!");

                        if(tentativas == 3){
                            System.out.println("Numero maximo de tentativas atingido, retornando ao menu principal!");
                        }
                    }

                    returna = sc.nextInt();
                    if(returna == 0){break;}
                }


            }
            else if(choice == 2){
                // Criar Conta

                Integer retorno = -1;

                while (retorno != 0){

                    Menu.cabecalho();

                    System.out.print("Digite seu nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Digite o email: ");
                    String email = sc.nextLine();

                    System.out.print("Digito o seu usuario: ");
                    String user = sc.nextLine();

                    System.out.print("Digite a senha: ");
                    String senha = sc.nextLine();

                    if(Validador.validarEmail(email) && Validador.validarSenha(senha)){
                        usuarios.add(new Usuario(nome, email, user, senha));
                        System.out.print("\nUsuario cadastrado com sucesso! \nDigite 0 para retornar.");
                        retorno = sc.nextInt();
                        if(retorno == 0) break;
                    } else {
                        System.out.println("Email ou Senha nao atingiram os requisitos minimos. Tente novamente!");
                    }
                }

            }
            else if (choice == 3){
                // Entrar como convidado

                Menu.cabecalho();
                Menu.cabecalhoParteInterna();
            }
            else if (choice == 4){
                // Entrar como administrador / Artista no nosso caso

                Menu.cabecalho();
            }
            else if (choice == 5){
                // Sobre o aplicativo

                Menu.cabecalho();
                Menu.cabecalhoSobreAplicativo();
            }
            else if(choice == 0){
                Menu.cabecalho();
                Menu.finalizarPrograma();
            }
            else {
                Menu.cabecalho();
                Menu.escolhaErrada();
            }
        }

        sc.close();
        
    }
}