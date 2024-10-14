import java.util.ArrayList;

public class Usuario {

    private String nomeUsuario;
    private String senha;
    private ArrayList<Filme> filmesFavoritos = new ArrayList<>();
    private ArrayList<Ator> atoresFavoritos = new ArrayList<>();
    private ArrayList<Diretor> diretoresFavoritos = new ArrayList<>();

    public Usuario(String nomeUsuario, String senha) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void adicionarFilmeFavorito(Filme filme) {
        filmesFavoritos.add(filme);
    }

    public void adicionarAtorFavorito(Ator ator) {
        atoresFavoritos.add(ator);
    }

    public void adicionarDiretorFavorito(Diretor diretor) {
        diretoresFavoritos.add(diretor);
    }

    public void verFavoritos() {
        System.out.println("\n--- SEUS FAVORITOS ---");
        System.out.println("Filmes:");
        for (Filme filme : filmesFavoritos) {
            System.out.println("- " + filme.getTitulo());
        }
        System.out.println("Atores:");
        for (Ator ator : atoresFavoritos) {
            System.out.println("- " + ator.getNome());
        }
        System.out.println("Diretores:");
        for (Diretor diretor : diretoresFavoritos) {
            System.out.println("- " + diretor.getNome());
        }
    }
}