import java.util.ArrayList;
import java.util.Scanner;

public class SalaAssento {
    private int idSalaAssento; 
    private Assento assento;
    private Sala sala;


    public SalaAssento(int idSalaAssento, Assento assento, Sala sala) {
        this.idSalaAssento = idSalaAssento;
        this.assento = assento;
        this.sala = sala;
    }

    public int getIdSalaAssento() {
        return idSalaAssento;
    }
    public void setIdSalaAssento(int idSalaAssento) {
        this.idSalaAssento = idSalaAssento;
    }
    public Assento getAssento() {
        return assento;
    }
    public void setAssento(Assento assento) {
        this.assento = assento;
    }
    public Sala getSala() {
        return sala;
    }
    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Override 
    public String toString() {
        return "Sala Assento [idSalaAssento: " + idSalaAssento + ", assento: " + assento + ", sala: " + sala + "]";
    }

    public boolean cadastrar(SalaAssento salaAssento, Scanner scanner, ArrayList<SalaAssento> salaAssentoList) {
        for (SalaAssento sa : salaAssentoList) {
            if (sa.getIdSalaAssento() == salaAssento.getIdSalaAssento()) {
                System.out.println("SalaAssento já cadastrado!");
                return false;
            }
        }
        salaAssentoList.add(salaAssento);
        System.out.println("SalaAssento cadastrado com sucesso!");
        return true;
    }

    public boolean editar(SalaAssento salaAssento, Scanner scanner, ArrayList<SalaAssento> salaAssentoList) {
        for (SalaAssento sa : salaAssentoList) {
            if (sa.getIdSalaAssento() == salaAssento.getIdSalaAssento()) {
                sa.setAssento(salaAssento.getAssento());
                sa.setSala(salaAssento.getSala());
                System.out.println("SalaAssento editado com sucesso!");
                return true;
            }
        }
        System.out.println("SalaAssento não encontrado!");
        return false;
    }

    public SalaAssento consultar(SalaAssento salaAssento, Scanner scanner, ArrayList<SalaAssento> salaAssentoList) {
        for (SalaAssento sa : salaAssentoList) {
            if (sa.getIdSalaAssento() == salaAssento.getIdSalaAssento()) {
                System.out.println("SalaAssento encontrado: " + sa);
                return sa;
            }
        }
        System.out.println("SalaAssento não encontrado!");
        return null;
    }

    public ArrayList<SalaAssento> listar(Scanner scanner, ArrayList<SalaAssento> salaAssentoList) {
        System.out.println("Lista de SalaAssento:");
        for (SalaAssento sa : salaAssentoList) {
            System.out.println("ID: " + sa.getIdSalaAssento() +
                               ", Assento: " + sa.getAssento() +
                               ", Sala: " + sa.getSala());
        }
        return salaAssentoList;
    }
}
