import java.util.ArrayList;

public class Genero {
    private int id;
    private String descricao;
    private String status;

    public Genero(int id, String descricao, String status){
        this.id = id;
        this.descricao = descricao;
        this.status = status;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

 @Override
        public String toString(){
            return "id: " + id + ", descricao: " + descricao;
        }

        public boolean cadastrar(Genero genero, ArrayList<Genero> generoList) {
            for (Genero g : generoList) {
                if (g.getId() == genero.getId()) {
                    System.out.println("Genero já cadastrado!");
                    return false;
                }
            }
            generoList.add(genero);
            System.out.println("Gênero cadastrado com sucesso!");
            return true;
        }

    public boolean editar(Genero genero, ArrayList<Genero> generoList) {
        for (Genero g : generoList) {
            if (g.getId() == genero.getId()) {
                g.setDescricao(genero.getDescricao());
                g.setStatus(genero.getStatus());
                System.out.println("Gênero editado com sucesso!");
                return true;
            }
        }
        System.out.println("Gênero não encontrado!");
        return false;
    }
    public Genero consultar(Genero genero, ArrayList<Genero> generoList) {
        for (Genero g : generoList) {
            if (g.getId() == genero.getId()) {
                System.out.println("Genero encontrado: " + g);
                return g;
            }
        }
        System.out.println("Genero não encontrado!");
        return null;
    }

    public ArrayList<Genero> listar(ArrayList<Genero> generoList) {
        System.out.println("Lista dos Generos:");
        for (Genero g : generoList) {
            System.out.println("ID: " + g.getId() +
                               ", Descrição: " + g.getDescricao() +
                               ", Status: " + g.getStatus());
        }
        return generoList;
    }
}
