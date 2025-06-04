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

                Menu.cabecalho();

                System.out.print("Digite seu uuario: ");
                String userLogin = sc.nextLine();

                System.out.print("Digite sua senha: ");
                String senhaLogin = sc.nextLine();

                boolean existe = false;
                Integer returna = -1;
                
                for(Usuario user : usuarios) {
                    if (user.getLogin().equals(userLogin) && user.getSenha().equals(senhaLogin)){
                        existe = true;
                        Menu.cabecalho();
                        Menu.cabecalhoParteInterna();
                        System.out.println("Login realizado com sucesso!");
                    }
                }

                returna = sc.nextInt();


            }
            else if(choice == 2){
                // Criar Conta

                Integer retorno = -1;

                Menu.cabecalho();

                System.out.print("Digite seu nome: ");
                String nome = sc.nextLine();

                System.out.print("Digite o email: ");
                String email = sc.nextLine();

                System.out.print("Digito o seu usuario: ");
                String user = sc.nextLine();

                System.out.print("Digite a senha: ");
                String senha = sc.nextLine();

                usuarios.add(new Usuario(nome, email, user, senha));

                System.out.print("\nUsuario cadastrado com sucesso! \nDigite 0 para retornar.");
                retorno = sc.nextInt();

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