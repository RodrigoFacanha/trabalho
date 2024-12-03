import java.util.ArrayList;

public class Sala {
    private int idSala;
    private int capacidadeSala;
    private String descricao;
    private String status;
    
    public Sala(int idSala, int capacidadeSala, String descricao, String status) {
        this.idSala = idSala;
        this.capacidadeSala = capacidadeSala;
        this.descricao = descricao;
        this.status = status;
    }

    public int getIdSala() {
        return idSala;
    }
    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }
    public int getCapacidadeSala() {
        return capacidadeSala;
    }
    public void setCapacidadeSala(int capacidadeSala) {
        this.capacidadeSala = capacidadeSala;
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
    public void setStatus(String status){
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "Sala [idSala=" + idSala + ", capacidadeSala" + capacidadeSala + ", descricao=" + descricao + ", status=" + status + "]";
    }

    public boolean cadastrar(Sala sala, ArrayList<Sala> salaList) {
        for (Sala s : salaList) {
            if (s.getIdSala() == sala.getIdSala()) {
                System.out.println("Sala já cadastrada!");
                return false;
            }
        }
        salaList.add(sala);
        System.out.println("Sala cadastrada com sucesso!");
        return true;
    }

    public boolean editar(Sala sala, ArrayList<Sala> salaList) {
        for (Sala s : salaList) {
            if (s.getIdSala() == sala.getIdSala()) {
                s.setCapacidadeSala(sala.getCapacidadeSala());
                s.setDescricao(sala.getDescricao());
                s.setStatus(sala.getStatus());
                System.out.println("Sala editada com sucesso!");
                return true;
            }
        }
        System.out.println("Sala não encontrada!");
        return false;
    }
    public Sala consultar(Sala sala, ArrayList<Sala> salaList) {
        for (Sala s : salaList) {
            if (s.getIdSala() == sala.getIdSala()) {
                System.out.println("Sala encontrada: " + s);
                return s;
            }
        }
        System.out.println("Sala não encontrada!");
        return null;
    }

    public ArrayList<Sala> listar(ArrayList<Sala> salaList) {
        System.out.println("Lista de Salas:");
        for (Sala s : salaList) {
            System.out.println("ID: " + s.getIdSala() +
                               ", Capacidade: " + s.getCapacidadeSala() +
                               ", Descrição: " + s.getDescricao() +
                               ", Status: " + s.getStatus());
        }
        return salaList;
    }
}
