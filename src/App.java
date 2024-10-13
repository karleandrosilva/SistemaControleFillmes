import java.util.HashMap;
import java.util.Scanner;

public class App {

    static Scanner teclado = new Scanner(System.in); // entrada de dados (input)
    static HashMap<String, Usuario> usuarios = new HashMap<>(); //  Mapa para armazenar os usuários cadastrados (nome de usuário -> Usuario)

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) { // Loop principal
            telaLogin();

            System.out.println("Deseja continuar usando o programa? [S/N]: ");
            String respostaContinuar = teclado.nextLine();
            if (respostaContinuar.equalsIgnoreCase("N")) {
                continuar = false;
            } else {
                continuar = true;
            }    
        }

        System.out.println("Programa encerrado. Até mais!");
        teclado.close();
        System.exit(0); // Encerra o programa

    }

    static void telaLogin() {
        System.out.print("SEJA BEM VINDO! AO SISTEMA DE CONTROLE DE FILMES");
        System.out.print("\nEscolha uma das opções abaixo:\n"
                    + "[1] - CRIAR CADASTRO\n"
                    + "[2] - FAZER LOGIN\nRESPOSTA: "); 

        int opcao = teclado.nextInt();
        teclado.nextLine();

        while (opcao > 2) { 
            if (opcao == 2 || opcao == 1) {
                break;
            } else {
                System.out.print("OPÇÃO INVALIDA!\n" 
                    + "[1] - CRIAR CADASTRO\n" 
                    + "[2] - FAZER LOGIN\nRESPOSTA: "); 
                opcao = teclado.nextInt();
                teclado.nextLine();
            } 
        }

        processarOpcao(opcao);
    }

    static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                cadastro();
                break;
            case 2:
                login();
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA!");
        }
    }

    public static void cadastro(){
        System.out.println("\n--- CADASTRO DE USUÁRIO ---");
        System.out.print("Informe seu nome de usuário: ");
        String usuario = teclado.nextLine();

        if (usuarios.containsKey(usuario)) {
            System.out.println("\nUsuário já cadastrado! Tente outro nome de usuário.");
            cadastro();
        }

        System.out.print("Informe sua senha: ");
        String senha = teclado.nextLine();

        System.out.print("Você será um administrador? (S/N): ");
        String resposta = teclado.nextLine();

        if (resposta.equalsIgnoreCase("S")) {
            usuarios.put(usuario, new Administrador(usuario, senha));
            System.out.println("Administrador cadastrado com sucesso!");
        } else {
            usuarios.put(usuario, new Usuario(usuario, senha));
            System.out.println("Usuário cadastrado com sucesso!");
        }

        login();
    }

    public static void login(){
        System.out.println("\n--- LOGIN ---");
        System.out.print("Informe seu nome de usuário: ");
        String usuario = teclado.nextLine();

        if (!usuarios.containsKey(usuario)) {
            System.out.println("\nUsuário não encontrado! Faça o cadastro primeiro.");
            cadastro();
        } else {
            System.out.print("Informe sua senha: ");  
        }
        String senha = teclado.nextLine();  
        Usuario usuarioLogado = usuarios.get(usuario);
        
        if (usuarioLogado.getSenha().equals(senha)) {
            System.out.println("Login realizado com sucesso! Bem-vindo, " + usuario + "!");
            if (usuarioLogado instanceof Administrador) {
                menuAdministrador();
            } else {
                menuUsuarioComum(usuarioLogado);
            }
        } else {
            System.out.println("\nSenha incorreta. Tente novamente.");
            login();
        }
    }

    public static void menuAdministrador() {
        System.err.println("ADM");
    }

    public static void menuUsuarioComum(Usuario usuarioLogado) {
        System.err.println("USUARIO COMUM");
    }
}
