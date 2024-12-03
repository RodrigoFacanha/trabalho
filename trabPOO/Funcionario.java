import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Funcionario extends Pessoa {
    private int matricula;
    private Date horarioTrabalho;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public Funcionario(String cpf, String nome, String email, int matricula, String horarioTrabalho) throws ParseException {
        super(cpf, nome, email);
        this.matricula = matricula;
        this.horarioTrabalho = dateFormat.parse(horarioTrabalho);
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public Date getHorarioTrabalho() {
        return horarioTrabalho;
    }

    public void setHorarioTrabalho(String horarioTrabalho) throws ParseException {
        this.horarioTrabalho = dateFormat.parse(horarioTrabalho);
    }

    @Override
    public String toString() {
        return "Funcionario [Cpf: " + getCpf() + 
               ", Nome: " + getNome() + 
               ", Email: " + getEmail() + 
               ", Matricula: " + matricula + 
               ", Horário de Trabalho: " + dateFormat.format(horarioTrabalho) + "]";
    }

    public boolean cadastrar(Funcionario funcionario, ArrayList<Funcionario> funcionariosList) {
        for (Funcionario f : funcionariosList) {
            if (f.getMatricula() == funcionario.getMatricula()) {
                System.out.println("Funcionário já cadastrado!");
                return false;
            }
        }
        funcionariosList.add(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
        return true;
    }

    public boolean editar(Funcionario funcionario, ArrayList<Funcionario> funcionariosList) {
        for (Funcionario f : funcionariosList) {
            if (f.getMatricula() == funcionario.getMatricula()) {
                f.setNome(funcionario.getNome());
                try {
                    f.setHorarioTrabalho(dateFormat.format(funcionario.getHorarioTrabalho()));
                } catch (ParseException e) {
                    System.out.println("Erro ao definir horário de trabalho!");
                }
                f.setCpf(funcionario.getCpf());
                f.setEmail(funcionario.getEmail());
                System.out.println("Funcionário editado com sucesso!");
                return true;
            }
        }
        System.out.println("Funcionário não encontrado!");
        return false;
    }

    public Funcionario consultar(Funcionario funcionario, ArrayList<Funcionario> funcionariosList) {
        for (Funcionario f : funcionariosList) {
            if (f.getMatricula() == funcionario.getMatricula()) {
                System.out.println("Funcionário encontrado: " + f);
                return f;
            }
        }
        System.out.println("Funcionário não encontrado!");
        return null;
    }

    public ArrayList<Funcionario> listar(ArrayList<Funcionario> funcionariosList) {
        System.out.println("\nLista de Funcionários:");
        for (Funcionario f : funcionariosList) {
            System.out.println(f);
        }
        return funcionariosList;
    }
}