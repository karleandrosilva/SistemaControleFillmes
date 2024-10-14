
public class Filme {
    private String titulo;
    private int duracao;
    private int anoLancamento;
    private int genero;
    //private ArrayList atores;
    //private ArrayList diretores;

    public Filme(String titulo, int duracao, int anoLancamento) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
    }

    // public Filme(String titulo, int anoLancamento, int duracao) {
    //     this.anoLancamento = anoLancamento;
    //     this.duracao = duracao;
    //     this.genero = genero;
    //     this.titulo = titulo;
    //     //this.atores = atores;
    //     //this.diretores = diretores;
    // }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    /* public ArrayList getAtores() {
        return atores;
    }

    public void setAtores(ArrayList atores) {
        this.atores = atores;
    }

    public ArrayList getDiretores() {
        return diretores;
    }

    public void setDiretores(ArrayList diretores) {
        this.diretores = diretores;
    } */

}
