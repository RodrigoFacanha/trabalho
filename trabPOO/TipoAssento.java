import java.util.ArrayList;

public class TipoAssento {
    private int idTipoAssento;
    private String descricao;
    private String status;

    public TipoAssento(int idTipoAssento, String descricao, String status) {
        this.idTipoAssento = idTipoAssento;
        this.descricao = descricao;
        this.status = status;
    }

    public int getIdTipoAssento() {
        return idTipoAssento;
     }
    public void setIdTipoAssento(int idTipoAssento) {
        this.idTipoAssento = idTipoAssento;
     }
        public String getDescricao() {
            return descricao;
     }
        public void setDescricao(String descricao){
            this.descricao = descricao;
    }
        public String getStatus() {
            return status;
    }
        public void setStatus(String status) {
            this.status = status;
    }

    @Override 
     public String toString() {
        return "TipoAssento [idTipoAssento=" + idTipoAssento + ", descricao" + descricao + ", status=" + status + "]";
     }

     public boolean cadastrar(TipoAssento tipoAssento, ArrayList<TipoAssento> tipoAssentoList) {
        for (TipoAssento ta : tipoAssentoList) {
            if (ta.getIdTipoAssento() == tipoAssento.getIdTipoAssento()) {
                System.out.println("Tipo de assento já cadastrado!");
                return false;
            }
        }
        tipoAssentoList.add(tipoAssento);
        System.out.println("Tipo de assento cadastrado com sucesso!");
        return true;
    }

    public boolean editar(TipoAssento tipoAssento, ArrayList<TipoAssento> tipoAssentoList) {
        for (TipoAssento ta : tipoAssentoList) {
            if (ta.getIdTipoAssento() == tipoAssento.getIdTipoAssento()) {
                ta.setDescricao(tipoAssento.getDescricao());
                ta.setStatus(tipoAssento.getStatus());
                System.out.println("Tipo de assento editado com sucesso!");
                return true;
            }
        }
        System.out.println("Tipo de assento não encontrado!");
        return false;
    }

    public TipoAssento consultar(TipoAssento tipoAssento, ArrayList<TipoAssento> tipoAssentoList) {
        for (TipoAssento ta : tipoAssentoList) {
            if (ta.getIdTipoAssento() == tipoAssento.getIdTipoAssento()) {
                System.out.println("Tipo de assento encontrado: " + ta);
                return ta;
            }
        }
        System.out.println("Tipo de assento não encontrado!");
        return null;
    }

    public ArrayList<TipoAssento> listar(ArrayList<TipoAssento> tipoAssentoList) {
        System.out.println("Lista de Tipos de Assento:");
        for (TipoAssento ta : tipoAssentoList) {
            System.out.println("ID: " + ta.getIdTipoAssento() +
                               ", Descrição: " + ta.getDescricao() +
                               ", Status: " + ta.getStatus());
        }
        return tipoAssentoList;
    }
}
