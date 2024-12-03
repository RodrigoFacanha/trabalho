import java.util.ArrayList;

public class Assento {
    private int idAssento;
    private TipoAssento tipoAssento;

    public Assento(int idAssento, TipoAssento tipoAssento) {
        this.idAssento = idAssento;
        this.tipoAssento = tipoAssento;
    }

    public int getIdAssento() {
        return idAssento;
    }
    public void setIdAssento(int idAssento) {
        this.idAssento = idAssento;
    }
    public TipoAssento getTipoAssento() {
        return tipoAssento;
    }
    public void setTipoAssento(TipoAssento tipoAssento) {
        this.tipoAssento = tipoAssento;
    }
    @Override 
    public String toString(){
        return "Assento [Lugar =" + idAssento + ", tipo =" + tipoAssento;
    }

    public boolean cadastrar(Assento assento, ArrayList<Assento> assentoList) {
        for (Assento a : assentoList) {
            if (a.getIdAssento() == assento.getIdAssento()) {
                System.out.println("Assento já cadastrado!");
                return false;
            }
        }
        assentoList.add(assento);
        System.out.println("Assento cadastrado com sucesso!");
        return true;
    }

    public boolean editar(Assento assento, ArrayList<Assento> assentoList) {
        for (Assento a : assentoList) {
            if (a.getIdAssento() == assento.getIdAssento()) {
                a.setTipoAssento(assento.getTipoAssento());
                System.out.println("Assento editado com sucesso!");
                return true;
            }
        }
        System.out.println("Assento não encontrado!");
        return false;
    }

    public Assento consultar(Assento assento, ArrayList<Assento> assentoList) {
        for (Assento a : assentoList) {
            if (a.getIdAssento() == assento.getIdAssento()) {
                System.out.println("Assento encontrado: " + a);
                return a;
            }
        }
        System.out.println("Assento não encontrado!");
        return null;
    }

    public ArrayList<Assento> listar(ArrayList<Assento> assentoList) {
        System.out.println("Lista de Assentos:");
        for (Assento a : assentoList) {
            System.out.println("ID: " + a.getIdAssento() + ", Tipo: " + a.getTipoAssento().getDescricao());
        }
        return assentoList;
    }
}
