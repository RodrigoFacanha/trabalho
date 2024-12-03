import java.time.LocalDateTime;
import java.util.ArrayList;

public class Sessao {
    private int idSessao; 
    private LocalDateTime dataHoraSessao;
    private Filme filme;
    private Sala sala;
    private Funcionario funcionario;
    private String status;

    public Sessao(int idSessao, LocalDateTime dataHoraSessao, Filme filme, Sala sala, Funcionario funcionario, String status) {
        this.idSessao = idSessao;
        this.dataHoraSessao = dataHoraSessao;
        this.filme = filme;
        this.sala = sala;
        this.funcionario = funcionario;
        this.status = status;
    }

    public int getIdSessao() {
        return idSessao;
    }
    public void setIdSessao(int idSessao) {
        this.idSessao = idSessao;
    }
    public LocalDateTime getDataHoraSessao() {
        return dataHoraSessao;
    }
    public void setDataHoraSessao(LocalDateTime dataHoraSessao) {
        this.dataHoraSessao = dataHoraSessao;
    }
    public Filme getFilme() {
        return filme;
    }
    public void setFilme(Filme filme) {
        this.filme = filme;
    }
    public Sala getSala() {
        return sala;
    }
    public void setSala(Sala sala) {
        this.sala = sala;
    }
    public Funcionario getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Override 
        public String toString() {
            return "Sessao [idSessao=" + idSessao + ", data= " + dataHoraSessao + ", filme=" + filme + ", sala=" + sala;
        }

        public boolean cadastrar(Sessao sessao, ArrayList<Sessao> sessaoList, ArrayList<Filme> filmeList, ArrayList<Sala> salaList) {
            for (Sessao s : sessaoList) {
                if (s.getIdSessao() == sessao.getIdSessao()) {
                    System.out.println("Sessão já cadastrada!");
                    return false;
                }
            }
            sessaoList.add(sessao);
            System.out.println("Sessão cadastrada com sucesso!");
            return true;
        }
    
        public boolean editar(Sessao sessao, ArrayList<Sessao> sessaoList, ArrayList<Filme> filmeList, ArrayList<Sala> salaList) {
            for (Sessao s : sessaoList) {
                if (s.getIdSessao() == sessao.getIdSessao()) {
                    s.setDataHoraSessao(sessao.getDataHoraSessao());
                    s.setFilme(sessao.getFilme());
                    s.setSala(sessao.getSala());
                    s.setFuncionario(sessao.getFuncionario());
                    s.setStatus(sessao.getStatus());
                    System.out.println("Sessão editada com sucesso!");
                    return true;
                }
            }
            System.out.println("Sessão não encontrada!");
            return false;
        }

 public Sessao consultar(Sessao sessao, ArrayList<Sessao> sessaoList, ArrayList<Filme> filmeList, ArrayList<Sala> salaList) {
        for (Sessao s : sessaoList) {
            if (s.getIdSessao() == sessao.getIdSessao()) {
                System.out.println("Sessão encontrada: " + s);
                return s;
            }
        }
        System.out.println("Sessão não encontrada!");
        return null;
    }

    public ArrayList<Sessao> listar(ArrayList<Sessao> sessaoList, ArrayList<Filme> filmeList, ArrayList<Sala> salaList) {
        System.out.println("Lista de sessões:");
        for (Sessao s : sessaoList) {
            System.out.println("Sessão [ID: " + s.getIdSessao() +
                    ", Data/Hora: " + s.getDataHoraSessao() +
                    ", Filme: " + s.getFilme().getTitulo() +
                    ", Sala: " + s.getSala() +
                    ", Funcionário: " + s.getFuncionario().getNome() +
                    ", Status: " + s.getStatus() + "]");
        }
        return sessaoList;
    }
 }
