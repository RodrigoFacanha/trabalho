import java.util.ArrayList;

public class Filme {
    private int idFilme;
    private String titulo;
    private int classificacao;
    private Genero genero;
    private String status;

public Filme(int idFilme, String titulo, int classificacao, Genero genero, String status) {
    this.idFilme = idFilme;
    this.titulo = titulo;
    this.classificacao = classificacao;
    this.genero = genero;
    this.status = status;
}

    public int getIdFilme() {
        return idFilme;
    }
    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getClassificacao() {
        return classificacao;
    }
    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }
    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero){
        this.genero = genero;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Override 
    public String toString() {
        return "Filme{ Id do Filme: " +idFilme + ", titulo: " + titulo + ", classificacao: " + classificacao + ", genero: " + genero + ", status" + status + "}";
    }

    public boolean cadastrar(Filme filme, ArrayList<Filme> filmeList) {
        for (Filme f : filmeList) {
            if (f.getIdFilme() == filme.getIdFilme()) {
                System.out.println("Filme já cadastrado!");
                return false;
            }
        }
        filmeList.add(filme);
        System.out.println("Filme cadastrado com sucesso!");
        return true;
    }

    public boolean editar(Filme filme, ArrayList<Filme> filmeList) {
        for (Filme f : filmeList) {
            if (f.getIdFilme() == filme.getIdFilme()) {
                f.setTitulo(filme.getTitulo());
                f.setClassificacao(filme.getClassificacao());
                f.setGenero(filme.getGenero());
                f.setStatus(filme.getStatus());
                System.out.println("Filme editado com sucesso!");
                return true;
            }
        }
        System.out.println("Filme não encontrado!");
        return false;
    }

    public Filme consultar(Filme filme, ArrayList<Filme> filmeList) {
        for (Filme f : filmeList) {
            if (f.getIdFilme() == filme.getIdFilme()) {
                System.out.println("Filme encontrado: " + f);
                return f;
            }
        }
        System.out.println("Filme não encontrado!");
        return null;
    }

    public ArrayList<Filme> listar(ArrayList<Filme> filmeList) {
        System.out.println("Lista de Filmes:");
        for (Filme filme : filmeList) {
            System.out.println("ID: " + filme.getIdFilme() +
                               ", Título: " + filme.getTitulo() +
                               ", Classificação: " + filme.getClassificacao() +
                               ", Gênero: " + filme.getGenero() +
                               ", Status: " + filme.getStatus());
        }
        return filmeList;
    }
}
