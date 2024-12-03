import java.util.ArrayList;

public class Ingresso {
    private int idIngresso;
    private double valorPago;
    private SalaAssento salaAssento;
    private Sessao sessao;

    public Ingresso(int idIngresso, double valorPago, SalaAssento salaAssento, Sessao sessao) {
        this.idIngresso = idIngresso;
        this.valorPago = valorPago;
        this.salaAssento = salaAssento;
        this.sessao = sessao;
    }
    public int getIdIngresso() {
        return idIngresso;
    }
    public void setIdIngresso(int idIngresso) {
        this.idIngresso = idIngresso;
    }
    public double getValorPago() {
        return valorPago;
    }
    public void setValorPago(double valorPago){
        this.valorPago = valorPago;
    }    
    public SalaAssento getSalaAssento() {
        return salaAssento;
    }
    public void setSalaAssento(SalaAssento salaAssento) {
        this.salaAssento = salaAssento;
    }
    public Sessao getSessao() {
        return sessao;
    }
    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    @Override
    public String toString() {
        return "Ingresso{ Valor: " + valorPago + ", Sala: " + salaAssento + ", Sessão: " + sessao + "}";
    }
    
    public boolean cadastrar(Ingresso ingresso,  ArrayList<Ingresso> ingressoList, ArrayList<Sessao> sessaoList, ArrayList<SalaAssento> salaAssentoList) {
        for (Ingresso i : ingressoList) {
            if (i.getIdIngresso() == ingresso.getIdIngresso()) {
                System.out.println("Ingresso já cadastrado!");
                return false;
            }
        }
        ingressoList.add(ingresso);
        System.out.println("Ingresso cadastrado com sucesso!");
        return true;
    }

    public boolean editar(Ingresso ingresso,  ArrayList<Ingresso> ingressoList, ArrayList<Sessao> sessaoList, ArrayList<SalaAssento> salaAssentoList) {
        for (Ingresso i : ingressoList) {
            if (i.getIdIngresso() == ingresso.getIdIngresso()) {
                i.setValorPago(ingresso.getValorPago());
                i.setSalaAssento(ingresso.getSalaAssento());
                i.setSessao(ingresso.getSessao());
                System.out.println("Ingresso editado com sucesso!");
                return true;
            }
        }
        System.out.println("Ingresso não encontrado!");
        return false;
    }

    public Ingresso consultar(Ingresso ingresso,  ArrayList<Ingresso> ingressoList, ArrayList<Sessao> sessaoList, ArrayList<SalaAssento> salaAssentoList) {
        for (Ingresso i : ingressoList) {
            if (i.getIdIngresso() == ingresso.getIdIngresso()) {
                System.out.println("Ingresso encontrado: " + i);
                return i;
            }
        }
        System.out.println("Ingresso não encontrado!");
        return null;
    }

    public ArrayList<Ingresso> listar( ArrayList<Ingresso> ingressoList, ArrayList<Sessao> sessaoList, ArrayList<SalaAssento> salaAssentoList) {
        System.out.println("Lista de Ingressos:");
        for (Ingresso i : ingressoList) {
            System.out.println("ID: " + i.getIdIngresso() +
                               ", Valor Pago: " + i.getValorPago() +
                               ", Sala/Assento: " + i.getSalaAssento() +
                               ", Sessão: " + i.getSessao());
        }
        return ingressoList;
    }
}
