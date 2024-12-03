import java.util.ArrayList;

public class FilmeAtor {
    private int idFilmeAtor;
    private Ator ator;
    private Filme filme;
    private String personagem;
    private boolean principal;


    public FilmeAtor(int idFilmeAtor, Ator ator, Filme filme, String personagem, boolean principal) {
        this.idFilmeAtor = idFilmeAtor;
        this.ator = ator;
        this.filme = filme;
        this.personagem = personagem;
        this.principal = principal;
}

public int getIdFilmeAtor() {
    return idFilmeAtor;
}
public void setIdFilmeAtor(int idFilmeAtor) {
    this.idFilmeAtor = idFilmeAtor;
}
public Ator getAtor() {
    return ator;
}
public void setAtor(Ator ator) {
    this.ator = ator;
}
public Filme getFilme() {
    return filme;
}
public void setFilme(Filme filme) {
    this.filme = filme;
}
public String getPersonagem() {
    return personagem;
}
public void setPersonagem(String personagem) {
    this.personagem = personagem;
}
public boolean isPrincipal(){
    return principal;
}
public void setPrincipal(boolean principal) {
    this.principal = principal;
}

@Override 
        public String toString() {
            return "FilmeAtor [Ator= " + ator + "Filme= " + filme + "Personagem= " + personagem +"]";
        }
        
        public boolean cadastrar(FilmeAtor filmeAtor, ArrayList<FilmeAtor> filmeAtorList, ArrayList<Ator> atorList, ArrayList<Filme> filmeList) {
            for (FilmeAtor fa : filmeAtorList) {
                if (fa.getIdFilmeAtor() == filmeAtor.getIdFilmeAtor()) {
                    System.out.println("FilmeAtor já cadastrada!");
                    return false;
                }
            }
            filmeAtorList.add(filmeAtor);
            System.out.println("FilmeAtor cadastrada com sucesso!");
            return true;
        }


    public boolean editar(FilmeAtor filmeAtor, ArrayList<FilmeAtor> filmeAtorList, ArrayList<Ator> atorList, ArrayList<Filme> filmeList) {
        for (FilmeAtor fa : filmeAtorList) {
            if (fa.getIdFilmeAtor() == filmeAtor.getIdFilmeAtor()) {
                fa.setAtor(filmeAtor.getAtor());
                fa.setFilme(filmeAtor.getFilme());
                fa.setPersonagem(filmeAtor.getPersonagem());
                fa.setPrincipal(filmeAtor.isPrincipal());
                System.out.println("FilmeAtor editada com sucesso!");
                return true;
            }
        }
        System.out.println("FilmeAtor não encontrada!");
        return false;
    }

    public FilmeAtor consultar(FilmeAtor filmeAtor, ArrayList<FilmeAtor> filmeAtorList, ArrayList<Ator> atorList, ArrayList<Filme> filmeList) {
        for (FilmeAtor fa : filmeAtorList) {
            if (fa.getIdFilmeAtor() == filmeAtor.getIdFilmeAtor()) {
                System.out.println("FilmeAtor encontrada: " + fa);
                return fa;
            }
        }
        System.out.println("FilmeAtor não encontrada!");
        return null;
    }

    public ArrayList<FilmeAtor> listar(ArrayList<FilmeAtor> filmeAtorList, ArrayList<Ator> atorList, ArrayList<Filme> filmeList) {
        System.out.println("Lista de atores nos filmes");
        for (FilmeAtor fa : filmeAtorList) {
            System.out.println("Filme: " + fa.getFilme().getTitulo() +
                    ", Ator: " + fa.getAtor().getNome() +
                    ", Personagem: " + fa.getPersonagem() +
                    ", Principal: " + (fa.isPrincipal() ? "Sim" : "Não"));
        }
        return filmeAtorList;
    }
}
