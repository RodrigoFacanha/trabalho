import java.util.ArrayList;

public class Ator extends Pessoa {
    private int registro;

    public Ator(String cpf, String nome, String email, int registro) {
        super(cpf, nome, email);
        this.registro = registro;
    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }


    public boolean cadastrar(Ator ator,  ArrayList<Ator> atorList) {
        for (Ator a : atorList) {
            if (a.getRegistro() == ator.getRegistro()) {
                System.out.println("Registro já existe!");
                return false;
            }
        }
        atorList.add(ator);
        System.out.println("Ator cadastrado com sucesso!");
        return true;
    }


       public boolean editar(Ator ator,  ArrayList<Ator> atorList) {
        for (Ator a : atorList) {
            if (a.getRegistro() == ator.getRegistro()) {
                a.setNome(ator.getNome());
                a.setCpf(ator.getCpf());
                a.setEmail(ator.getEmail());
                System.out.println("Ator editado com sucesso!");
                return true;
            }
        }
        System.out.println("Registro não encontrado!");
        return false;
    }


    public Ator consultar(Ator ator,  ArrayList<Ator> atorList) {
        for (Ator a : atorList) {
            if (a.getRegistro() == ator.getRegistro()) {
                System.out.println("Ator encontrado: " + a.getNome());
                return a;
            }
        }
        System.out.println("Registro não encontrado!");
        return null;
    }

    
    public static ArrayList<Ator> listar(ArrayList<Ator> atorList) {
        System.out.println("Listando todos os atores:");
        for (Ator ator : atorList) {
            System.out.println(ator);
        }
        return atorList;
    }

    @Override 
    public String toString(){
        return "Ator [Nome :" + getNome() + ", Registro: " + registro + ", CPF: " + getCpf() + ", Email: " + getEmail() + "]";
    }
}