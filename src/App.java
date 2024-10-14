import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App {

    static Scanner teclado = new Scanner(System.in); // entrada de dados (input)
    static HashMap<String, Usuario> usuarios = new HashMap<>(); //  Mapa para armazenar os usuários cadastrados (nome de usuário -> Usuario)
    static ArrayList<Filme> filmes = new ArrayList<>();
    static ArrayList<Ator> atores = new ArrayList<>();
    static ArrayList<Diretor> diretores = new ArrayList<>();

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
            System.out.println("\nLogin realizado com sucesso! Bem-vindo, " + usuario + "!");
            if (usuarioLogado instanceof Administrador) {
                Administrador adminLogado = (Administrador) usuarioLogado;
                menuAdministrador(adminLogado); // Passando a instância correta
            } else {
                menuUsuarioComum(usuarioLogado);
            }
        } else {
            System.out.println("\nSenha incorreta. Tente novamente.");
            login();
        }
    }

    public static void menuAdministrador(Administrador adminLogado) {
        System.out.println("\n--- MENU ADMINISTRADOR ---");
        System.out.print("[1] - Cadastrar Filme\n"
                + "[2] - Cadastrar Ator\n"
                + "[3] - Cadastrar Diretor\n"
                + "[4] - Listar Filmes\n"
                + "[5] - Listar Atores\n"
                + "[6] - Listar Diretores\n"
                + "[7] - Remover Filme\n"
                + "[8] - Remover Ator\n"
                + "[9] - Remover Diretor\n"
                + "[10] - Sair\nRESPOSTA: ");

        int opcao = teclado.nextInt();
        teclado.nextLine();

        switch (opcao) {
            case 1:
                adminLogado.cadastrarFilme(filmes);
                break;
            case 2:
                adminLogado.cadastrarAtor(atores);
                break;
            case 3:
                adminLogado.cadastrarDiretor(diretores);
                break;
            case 4:
                adminLogado.listarFilmes(filmes);
                break;
            case 5:
                adminLogado.listarAtores(atores);
                break;
            case 6:
                adminLogado.listarDiretores(diretores);
                break;
            case 7:
                adminLogado.removerFilme(filmes);
                break;
            case 8:
                adminLogado.removerAtor(atores);
                break;
            case 9:
                adminLogado.removerDiretor(diretores);
                break;
            case 10:
                telaLogin();
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA!");
        }

    }

    public static void menuUsuarioComum(Usuario usuarioLogado) {
        System.err.println("USUARIO COMUM");
    }
}
