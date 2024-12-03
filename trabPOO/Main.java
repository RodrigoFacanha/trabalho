import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Genero> generoList = new ArrayList<>();
        ArrayList<Filme> filmeList = new ArrayList<>();
        ArrayList<TipoAssento> tipoAssentoList = new ArrayList<>();
        ArrayList<Assento> assentoList = new ArrayList<>();
        ArrayList<Sala> salaList = new ArrayList<>();
        ArrayList<SalaAssento> salaAssentoList = new ArrayList<>();
        ArrayList<Sessao> sessaoList = new ArrayList<>();
        ArrayList<Ingresso> ingressoList = new ArrayList<>();
        ArrayList<Ator> atorList = new ArrayList<>();
        ArrayList<Funcionario> funcionariosList = new ArrayList<>();
        ArrayList<FilmeAtor> filmeAtorList = new ArrayList<>();
        
        boolean continuar = true;

        while (continuar) {
            System.out.println("Menu de Gestao de Cinema");
            System.out.println("1. Gerenciar Generos");
            System.out.println("2. Gerenciar Filmes");
            System.out.println("3. Gerenciar Tipo de Assentos");
            System.out.println("4. Gerenciar Assentos");
            System.out.println("5. Gerenciar Salas");
            System.out.println("6. Gerenciar Sala Assentos");
            System.out.println("7. Gerenciar Sessões");
            System.out.println("8. Gerenciar Ingressos");
            System.out.println("9. Gerenciar Atores");
            System.out.println("10. Gerenciar Funcionarios");
            System.out.println("11. Gerenciar Filmes Atores");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    gerenciarGenero(scanner, generoList);
                    break;
                case 2:
                    gerenciarFilme(scanner, filmeList);
                    break;
                case 3:
                    gerenciarTipoAssento(scanner, tipoAssentoList);
                    break;
                case 4:
                    gerenciarAssento(scanner, assentoList, tipoAssentoList);
                    break;
                    case 5:
                    gerenciarSala(scanner, salaList);
                    break;
                case 6:
                    gerenciarSalaAssento(scanner, salaAssentoList, filmeList,  salaList, funcionariosList); 
                    break;
                case 7:
                    gerenciarSessao(scanner, sessaoList, filmeList, salaList, funcionariosList);
                    break;
                case 8:
                    gerenciarIngresso(scanner, ingressoList, sessaoList, salaAssentoList);
                    break;
                    case 9:
                    gerenciarAtor(scanner, atorList);
                    break;
                case 10:
                    gerenciarFuncionario(scanner, funcionariosList);
                    break;
                case 11:
                    gerenciarFilmeAtor(scanner, filmeAtorList, filmeList, atorList);
                    break;
                    case 0:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }

        System.out.println("Sistema encerrado.");
        scanner.close();
    }
private static void gerenciarGenero(Scanner scanner, ArrayList<Genero> generoList) {
        System.out.println("\nGerenciar Gêneros:");
        System.out.println("1. Cadastrar Gênero");
        System.out.println("2. Editar Gênero");
        System.out.println("3. Consultar Gênero");
        System.out.println("4. Listar Gêneros");
        System.out.print("Escolha uma opção: ");
        int opcaoGenero = scanner.nextInt();
        scanner.nextLine();

        switch (opcaoGenero) {
            case 1:
                cadastrarGenero(scanner, generoList);
                break;
            case 2:
                editarGenero(scanner, generoList);
                break;
            case 3:
                consultarGenero(scanner, generoList);
                break;
            case 4:
                listarGeneros(generoList);
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }
private static void cadastrarGenero(Scanner scanner, ArrayList<Genero> generoList) {
        System.out.print("Digite o ID do Gênero: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Digite a descrição do Gênero: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite o status do Gênero: ");
        String status = scanner.nextLine();

        Genero genero = new Genero(id, descricao, status);
        genero.cadastrar(genero, generoList);
    }
private static void editarGenero(Scanner scanner, ArrayList<Genero> generoList) {
        System.out.print("Digite o ID do Gênero a ser editado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Digite a nova descrição do Gênero: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite o novo status do Gênero: ");
        String status = scanner.nextLine();

        Genero genero = new Genero(id, descricao, status);
        genero.editar(genero, generoList);
    }
private static void consultarGenero(Scanner scanner, ArrayList<Genero> generoList) {
        System.out.print("Digite o ID do Gênero a ser consultado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        Genero genero = new Genero(id, null, null);
        genero.consultar(genero, generoList);
    }
private static void listarGeneros(ArrayList<Genero> generoList) {
        Genero genero = new Genero(0, null, null);
        genero.listar(generoList);
    }


private static void gerenciarFilme(Scanner scanner, ArrayList<Filme> filmeList) {
        System.out.println("\nGerenciar Filmes:");
        System.out.println("1. Cadastrar Filme");
        System.out.println("2. Editar Filme");
        System.out.println("3. Consultar Filme");
        System.out.println("4. Listar Filmes");
        System.out.print("Escolha uma opção: ");
        int opcaoFilme = scanner.nextInt();
        scanner.nextLine();  

        switch (opcaoFilme) {
            case 1:
                cadastrarFilme(scanner, filmeList);
                break;
            case 2:
                editarFilme(scanner, filmeList);
                break;
            case 3:
                consultarFilme(scanner, filmeList);
                break;
            case 4:
                listarFilmes(filmeList);
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }
private static void cadastrarFilme(Scanner scanner, ArrayList<Filme> filmeList) {
        System.out.print("Digite o ID do Filme: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Digite o título do Filme: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite a classificação do Filme: ");
        int classificacao = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o status do Filme: ");
        String status = scanner.nextLine();

        Genero genero = new Genero(1, "Terror", "Ativo");
        Filme filme = new Filme(id, titulo, classificacao, genero, status);
        filme.cadastrar(filme, filmeList);
    }
private static void editarFilme(Scanner scanner, ArrayList<Filme> filmeList) {
        System.out.print("Digite o ID do Filme a ser editado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Digite o novo título do Filme: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite a nova classificação do Filme: ");
        int classificacao = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Digite o novo status do Filme: ");
        String status = scanner.nextLine();

        Genero genero = new Genero(1, "Gênero Exemplo", "Ativo");
        Filme filme = new Filme(id, titulo, classificacao, genero, status);
        filme.editar(filme, filmeList);
    }
private static void consultarFilme(Scanner scanner, ArrayList<Filme> filmeList) {
        System.out.print("Digite o ID do Filme a ser consultado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        Filme filme = new Filme(id, null, 0, null, null);
        filme.consultar(filme, filmeList);
    }
private static void listarFilmes(ArrayList<Filme> filmeList) {
        Filme filme = new Filme(0, null, 0, null, null);
        filme.listar(filmeList);
    }


private static void gerenciarTipoAssento(Scanner scanner, ArrayList<TipoAssento> tipoAssentoList) {
        System.out.println("\nGerenciar Tipo de Assentos:");
        System.out.println("1. Cadastrar Tipo de Assento");
        System.out.println("2. Editar Tipo de Assento");
        System.out.println("3. Consultar Tipo de Assento");
        System.out.println("4. Listar Tipos de Assento");
        System.out.print("Escolha uma opção: ");
        int opcaoTipoAssento = scanner.nextInt();
        scanner.nextLine();
    
        switch (opcaoTipoAssento) {
            case 1:
                cadastrarTipoAssento(scanner, tipoAssentoList);
                break;
            case 2:
                editarTipoAssento(scanner, tipoAssentoList);
                break;
            case 3:
                consultarTipoAssento(scanner, tipoAssentoList);
                break;
            case 4:
                listarTiposAssento(tipoAssentoList);
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }
private static void cadastrarTipoAssento(Scanner scanner, ArrayList<TipoAssento> tipoAssentoList) {
        System.out.print("Digite o ID do Tipo de Assento: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Digite a descrição do Tipo de Assento: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite o status do Tipo de Assento: ");
        String status = scanner.nextLine();
    
        TipoAssento tipoAssento = new TipoAssento(id, descricao, status);
        tipoAssento.cadastrar(tipoAssento, tipoAssentoList);
    }
private static void editarTipoAssento(Scanner scanner, ArrayList<TipoAssento> tipoAssentoList) {
        System.out.print("Digite o ID do Tipo de Assento a ser editado: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        TipoAssento tipoAssentoEncontrado = null;
        for (TipoAssento tipo : tipoAssentoList) {
            if (tipo.getIdTipoAssento() == id) {
                tipoAssentoEncontrado = tipo;
                break;
            }
        }
        if (tipoAssentoEncontrado == null) {
            System.out.println("Tipo de Assento não encontrado!");
            return;
        }
        System.out.print("Digite a nova descrição do Tipo de Assento: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite o novo status do Tipo de Assento: ");
        String status = scanner.nextLine();
    
        tipoAssentoEncontrado.setDescricao(descricao);
        tipoAssentoEncontrado.setStatus(status);
        System.out.println("Tipo de Assento editado com sucesso!");
    }
private static void consultarTipoAssento(Scanner scanner, ArrayList<TipoAssento> tipoAssentoList) {
        System.out.print("Digite o ID do Tipo de Assento a ser consultado: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        TipoAssento tipoAssento = new TipoAssento(id, null, null);
        tipoAssento.consultar(tipoAssento, tipoAssentoList);
    }
private static void listarTiposAssento(ArrayList<TipoAssento> tipoAssentoList) {
        TipoAssento tipoAssento = new TipoAssento(0, null, null);
        tipoAssento.listar(tipoAssentoList);
    }


private static void gerenciarAssento(Scanner scanner, ArrayList<Assento> assentoList, ArrayList<TipoAssento> tipoAssentoList) {
    System.out.println("\nGerenciar Assentos:");
    System.out.println("1. Cadastrar Assento");
    System.out.println("2. Editar Assento");
    System.out.println("3. Consultar Assento");
    System.out.println("4. Listar Assentos");
    System.out.print("Escolha uma opção: ");
    int opcao = scanner.nextInt();
    scanner.nextLine();

    switch (opcao) {
        case 1:
            cadastrarAssento(scanner, assentoList, tipoAssentoList);
            break;
        case 2:
            editarAssento(scanner, assentoList);
            break;
        case 3:
            consultarAssento(scanner, assentoList);
            break;
        case 4:
            listarAssentos(assentoList);
            break;
        default:
            System.out.println("Opção inválida!");
    }
}
private static void cadastrarAssento(Scanner scanner, ArrayList<Assento> assentoList, ArrayList<TipoAssento> tipoAssentoList) {
    System.out.print("Digite o ID do Assento: ");
    int id = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Escolha um Tipo de Assento:");
    listarTiposAssento(tipoAssentoList);
    System.out.print("Digite o ID do Tipo de Assento: ");
    int idTipo = scanner.nextInt();
    scanner.nextLine();
    TipoAssento tipo = tipoAssentoList.stream()
                                       .filter(t -> t.getIdTipoAssento() == idTipo)
                                       .findFirst()
                                       .orElse(null);
    if (tipo == null) {
        System.out.println("Tipo de Assento inválido!");
        return;
    }
    Assento assento = new Assento(id, tipo);
    assentoList.add(assento);
    System.out.println("Assento cadastrado com sucesso!");
}
private static void editarAssento(Scanner scanner, ArrayList<Assento> assentoList) {
    System.out.print("Digite o ID do Assento a ser editado: ");
    int id = scanner.nextInt();
    scanner.nextLine();
    Assento assento = assentoList.stream().filter(a -> a.getIdAssento() == id).findFirst().orElse(null);
    if (assento == null) {
        System.out.println("Assento não encontrado!");
        return;
    }
}
private static void consultarAssento(Scanner scanner, ArrayList<Assento> assentoList) {
    System.out.print("Digite o ID do Assento a ser consultado: ");
    int idAssento = scanner.nextInt();
    scanner.nextLine();
    Assento assentoEncontrado = null;
    for (Assento assento : assentoList) {
        if (assento.getIdAssento() == idAssento) {
            assentoEncontrado = assento;
            break;
        }
    }
    if (assentoEncontrado != null) {
        System.out.println("Assento encontrado: ID = " + assentoEncontrado.getIdAssento());
    } else {
        System.out.println("Assento com ID " + idAssento + " não encontrado.");
    }
}
private static void listarAssentos(ArrayList<Assento> assentoList) {
        Assento assento = new Assento(0, null);
        assento.listar(assentoList);
    }


private static void gerenciarSala(Scanner scanner, ArrayList<Sala> salaList) {
        System.out.println("\nGerenciar Sala:");
        System.out.println("1. Cadastrar Sala");
        System.out.println("2. Editar Sala");
        System.out.println("3. Consultar Sala");
        System.out.println("4. Listar Salas");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
    
        switch (opcao) {
            case 1:
                cadastrarSala(scanner, salaList);
                break;
            case 2:
                editarSala(scanner, salaList);
                break;
            case 3:
                consultarSala(scanner, salaList);
                break;
            case 4:
                listarSala(scanner, salaList);
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }
private static void cadastrarSala(Scanner scanner, ArrayList<Sala> salaList) {
        System.out.print("Digite o ID da Sala: ");
        int idSala = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Digite a descrição da Sala: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite o status da Sala: ");
        String status = scanner.nextLine();
        System.out.print("Digite a capacidade da Sala: ");
        int capacidadeSala = scanner.nextInt();
        scanner.nextLine();

        Sala sala = new Sala(idSala, capacidadeSala, descricao, status);
        sala.cadastrar(sala, salaList);
    }
private static void editarSala(Scanner scanner, ArrayList<Sala> salaList) {
        System.out.print("Digite o ID da Sala a ser editada: ");
        int idSala = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Digite a nova capacidade da Sala: ");
        int capacidadeSala = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite a nova descrição da Sala: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite o novo status da Sala: ");
        String status = scanner.nextLine();
    
        Sala sala = new Sala(idSala, capacidadeSala, descricao, status);
        sala.editar(sala, salaList);
    }    
private static void consultarSala(Scanner scanner, ArrayList<Sala> salaList) {
        System.out.print("Digite o ID da Sala para consultar: ");
        int idSala = scanner.nextInt();
        scanner.nextLine(); 
        Sala salaEncontrada = null;
        for (Sala sala : salaList) {
            if (sala.getIdSala() == idSala) {
                salaEncontrada = sala;
                break;
            }
        }
        if (salaEncontrada != null) {
            System.out.println("Sala encontrada: ID = " + salaEncontrada.getIdSala() + 
                               ", Capacidade = " + salaEncontrada.getCapacidadeSala() + 
                               ", Descrição = " + salaEncontrada.getDescricao() + 
                               ", Status = " + salaEncontrada.getStatus());
        } else {
            System.out.println("Sala com ID " + idSala + " não encontrada.");
        }
    }
private static void listarSala(Scanner scanner, ArrayList<Sala> salaList){
        System.out.println("Lista de Salas:");
        for (Sala sala : salaList) {
            System.out.println("ID: " + sala.getIdSala() + ", Descrição: " + sala.getDescricao());
        }
    }

private static void gerenciarSalaAssento(Scanner scanner, ArrayList<SalaAssento> salaAssentoList, ArrayList<Filme> filmeList, ArrayList<Sala> salaList, ArrayList<Funcionario> funcionariosList) {
        System.out.println("\nGerenciar Sala Assento:");
        System.out.println("1. Cadastrar Sala Assento");
        System.out.println("2. Editar Sala Assento");
        System.out.println("3. Consultar Sala Assento");
        System.out.println("4. Listar Salas Assento");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
    
        switch (opcao) {
            case 1:
                editarSalaAssento(scanner, salaAssentoList, filmeList, salaList, funcionariosList);
                break;
            case 2:
                consultarSalaAssento(scanner, salaAssentoList, filmeList, salaList, funcionariosList);
                break;
            case 3:
                listarSalaAssento(scanner, salaAssentoList, filmeList, salaList, funcionariosList);
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }
private static void editarSalaAssento(Scanner scanner, ArrayList<SalaAssento> salaAssentoList, ArrayList<Filme> filmeList, ArrayList<Sala> salaList, ArrayList<Funcionario> funcionariosList) {
    System.out.print("Digite o ID da SalaAssento que deseja editar: ");
    int idEditar = scanner.nextInt();
    scanner.nextLine(); 
    SalaAssento salaAssentoEditar = new SalaAssento(idEditar, null, null);
    salaAssentoEditar.editar(salaAssentoEditar, scanner, salaAssentoList);    
}
private static void consultarSalaAssento(Scanner scanner, ArrayList<SalaAssento> salaAssentoList, ArrayList<Filme> filmeList, ArrayList<Sala> salaList, ArrayList<Funcionario> funcionariosList){
    System.out.print("Digite o ID da SalaAssento que deseja consultar: ");
                    int idConsultar = scanner.nextInt();
                    scanner.nextLine();
                    SalaAssento salaAssentoConsultar = new SalaAssento(idConsultar, null, null);
                    salaAssentoConsultar.consultar(salaAssentoConsultar, scanner, salaAssentoList);
}
private static void listarSalaAssento(Scanner scanner, ArrayList<SalaAssento> salaAssentoList, ArrayList<Filme> filmeList, ArrayList<Sala> salaList, ArrayList<Funcionario> funcionariosList) {
SalaAssento salaAssentoListar = new SalaAssento(0, null, null);
salaAssentoListar.listar(scanner, salaAssentoList);
}

private static void gerenciarSessao(Scanner scanner, ArrayList<Sessao> sessaoList, ArrayList<Filme> filmeList, ArrayList<Sala> salaList, ArrayList<Funcionario> funcionarioList) {
    System.out.println("\nGerenciar Sessão:");
    System.out.println("1. Cadastrar Sessão");
    System.out.println("2. Editar Sessão");
    System.out.println("3. Consultar Sessão");
    System.out.println("4. Listar Sessões");
    System.out.print("Escolha uma opção: ");
    int opcao = scanner.nextInt();
    scanner.nextLine();

    switch (opcao) {
        case 1:
            cadastrarSessao(scanner, sessaoList, filmeList, salaList, funcionarioList);
            break;
        case 2:
            editarSessao(scanner, sessaoList, filmeList, salaList, funcionarioList);
            break;
        case 3:
            consultarSessao(scanner, sessaoList);
            break;
        case 4:
            listarSessoes(sessaoList);
            break;
        default:
            System.out.println("Opção inválida!");
    }
}
private static void cadastrarSessao(Scanner scanner,ArrayList<Sessao> sessaoList,ArrayList<Filme> filmeList,ArrayList<Sala> salaList,ArrayList<Funcionario> funcionarioList) {
System.out.println("\n--- Cadastro de Sessão ---");

System.out.print("Digite o ID da Sessão: ");
int idSessao = scanner.nextInt();
scanner.nextLine();

System.out.print("Digite a data e hora da sessão (formato: yyyy-MM-ddTHH:mm): ");
String dataHoraStr = scanner.nextLine();
LocalDateTime dataHoraSessao = LocalDateTime.parse(dataHoraStr);

System.out.println("Escolha um Filme:");
for (Filme filme : filmeList) {
    System.out.println(filme.getIdFilme() + " - " + filme.getTitulo());
}
System.out.print("Digite o ID do Filme: ");
int idFilme = scanner.nextInt();
scanner.nextLine();
Filme filmeSelecionado = filmeList.stream().filter(f -> f.getIdFilme() == idFilme).findFirst().orElse(null);

System.out.println("Escolha uma Sala:");
for (Sala sala : salaList) {
    System.out.println(sala.getIdSala() + " - " + sala.getDescricao());
}
System.out.print("Digite o ID da Sala: ");
int idSala = scanner.nextInt();
scanner.nextLine();
Sala salaSelecionada = salaList.stream().filter(s -> s.getIdSala() == idSala).findFirst().orElse(null);

System.out.println("Escolha um Funcionário:");
for (Funcionario funcionario : funcionarioList) {
    System.out.println(funcionario.getMatricula() + " - " + funcionario.getNome());
}
System.out.print("Digite a matrícula do Funcionário: ");
int matricula = scanner.nextInt();
scanner.nextLine();
Funcionario funcionarioSelecionado = funcionarioList.stream().filter(f -> f.getMatricula() == matricula).findFirst().orElse(null);

System.out.print("Digite o status da Sessão: ");
String status = scanner.nextLine();

Sessao novaSessao = new Sessao(idSessao, dataHoraSessao, filmeSelecionado, salaSelecionada, funcionarioSelecionado, status);

if (novaSessao.cadastrar(novaSessao, sessaoList, filmeList, salaList)) {
    System.out.println("Sessão cadastrada com sucesso!");
}
}
private static void editarSessao(Scanner scanner, ArrayList<Sessao> sessaoList, ArrayList<Filme> filmeList, ArrayList<Sala> salaList, ArrayList<Funcionario> funcionarioList) {
        System.out.print("Digite o ID da Sessão a ser editada: ");
        int idSessao = scanner.nextInt();
        scanner.nextLine();
        Sessao sessaoExistente = sessaoList.stream().filter(s -> s.getIdSessao() == idSessao).findFirst().orElse(null);
        if (sessaoExistente == null) {
            System.out.println("Sessão não encontrada.");
            return;
        }
        System.out.print("Digite a nova data e hora da sessão (YYYY-MM-DDTHH:MM): ");
        String dataHoraStr = scanner.nextLine();
        LocalDateTime novaDataHora = LocalDateTime.parse(dataHoraStr);
        System.out.println("Escolha um novo Filme (ID): ");
        for (Filme filme : filmeList) {
            System.out.println(filme.getIdFilme() + " - " + filme.getTitulo());
        }
        int idFilme = scanner.nextInt();
        scanner.nextLine();
        Filme novoFilme = filmeList.stream().filter(f -> f.getIdFilme() == idFilme).findFirst().orElse(null);
        System.out.println("Escolha uma nova Sala (ID): ");
        for (Sala sala : salaList) {
            System.out.println(sala.getIdSala());
        }
        int idSala = scanner.nextInt();
        scanner.nextLine();
        Sala novaSala = salaList.stream().filter(s -> s.getIdSala() == idSala).findFirst().orElse(null);
        System.out.println("Escolha um novo Funcionário (ID): ");
        for (Funcionario func : funcionarioList) {
            System.out.println(func.getMatricula() + " - " + func.getNome());
        }
        int idFuncionario = scanner.nextInt();
        scanner.nextLine();
        Funcionario novoFuncionario = funcionarioList.stream().filter(f -> f.getMatricula() == idFuncionario).findFirst().orElse(null);
        System.out.print("Digite o novo status da sessão: ");
        String novoStatus = scanner.nextLine();
        Sessao sessaoEditada = new Sessao(idSessao, novaDataHora, novoFilme, novaSala, novoFuncionario, novoStatus);
        if (sessaoExistente.editar(sessaoEditada, sessaoList, filmeList, salaList)) {
            System.out.println("Sessão editada com sucesso!");
        }
    }   
private static void consultarSessao(Scanner scanner, ArrayList<Sessao> sessaoList) {
        System.out.print("Digite o ID da Sessão para consulta: ");
        int idSessao = scanner.nextInt();
        scanner.nextLine();
        Sessao sessaoEncontrada = sessaoList.stream()
                                            .filter(s -> s.getIdSessao() == idSessao)
                                            .findFirst()
                                            .orElse(null);
    
        if (sessaoEncontrada != null) {
            System.out.println("Sessão encontrada: " + sessaoEncontrada);
        } else {
            System.out.println("Sessão não encontrada.");
        }
    }    
private static void listarSessoes(ArrayList<Sessao> sessaoList) {
        for (Sessao s : sessaoList) {
            System.out.println(s);
        }
    }


private static void gerenciarIngresso(Scanner scanner, ArrayList<Ingresso> ingressoList, ArrayList<Sessao> sessaoList, ArrayList<SalaAssento> salaAssentoList) {
        System.out.println("\nGerenciar ingresso:");
        System.out.println("1. Cadastrar ingresso");
        System.out.println("2. Editar ingresso");
        System.out.println("3. Consultar ingresso");
        System.out.println("4. Listar ingressos");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
    
        switch (opcao) {
            case 1:
                consultarIngresso(scanner, ingressoList, sessaoList, salaAssentoList);
                break;
            case 2:
                listarIngresso(scanner, ingressoList, sessaoList, salaAssentoList);
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }
private static void consultarIngresso(Scanner scanner, ArrayList<Ingresso> ingressoList, ArrayList<Sessao> sessaoList, ArrayList<SalaAssento> salaAssentoList) {
    System.out.println("Consulta de Ingresso:");
    System.out.print("Digite o ID do ingresso a ser consultado: ");
    int idIngresso = scanner.nextInt();
    scanner.nextLine(); 

    Ingresso ingressoConsultar = new Ingresso(idIngresso, 0, null, null);
    ingressoConsultar.consultar(ingressoConsultar, ingressoList, sessaoList, salaAssentoList);
}
private static void listarIngresso(Scanner scanner, ArrayList<Ingresso> ingressoList, ArrayList<Sessao> sessaoList, ArrayList<SalaAssento> salaAssentoList){
    Ingresso ingressoListar = new Ingresso(0, 0, null, null);
    ingressoListar.listar(ingressoList, sessaoList, salaAssentoList);    
}


private static void gerenciarAtor(Scanner scanner, ArrayList<Ator> atorList) {
        System.out.println("\nGerenciar Ator:");
        System.out.println("1. Cadastrar Ator");
        System.out.println("2. Editar Ator");
        System.out.println("3. Consultar Ator");
        System.out.println("4. Listar atores");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
    
        switch (opcao) {
            case 1:
                cadastrarAtor(scanner, atorList);
                break;
            case 2:
                editarAtor(scanner, atorList);
                break;
            case 3:
                consultarAtor(scanner, atorList);
                break;
            case 4:
                listarAtor(atorList);
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }
private static void cadastrarAtor(Scanner scanner, ArrayList<Ator> atorList) {
        System.out.print("Digite o nome do ator: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o cpf do ator: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o email do ator: ");
        String email = scanner.nextLine();
        System.out.print("Digite o registro do ator: ");
        int registro = scanner.nextInt();
        scanner.nextLine();

        Ator ator = new Ator(cpf, nome, email, registro);
        ator.cadastrar(ator, atorList);
    }
private static void editarAtor(Scanner scanner, ArrayList<Ator> atorList) {
        System.out.print("Digite o nome do Ator: ");
        String nome = scanner.nextLine(); 
        System.out.print("Digite o cpf do Ator: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o email do Ator: ");
        String email = scanner.nextLine();
        System.out.print("Digite o registro do Ator: ");
        int registro = scanner.nextInt();
        scanner.nextLine();
    
        Ator ator = new Ator(nome, cpf, email, registro);
        ator.editar(ator, atorList);
    }    
private static void consultarAtor(Scanner scanner, ArrayList<Ator> atorList) {
        System.out.println("Consultar Ator: ");
        System.out.print("Digite o registro do ator a ser consultado: ");
        int registro = scanner.nextInt();
        scanner.nextLine();
        Ator atorConsulta = new Ator(null, null, null, registro);
        Ator atorEncontrado = atorConsulta.consultar(atorConsulta, atorList);
        if (atorEncontrado == null) {
            System.out.println("Ator não encontrado.");}
        }
private static void listarAtor(ArrayList<Ator> atorList) {
    Ator.listar(atorList);    
    }

    
private static void gerenciarFuncionario(Scanner scanner, ArrayList<Funcionario> funcionariosList) {
        boolean continuarFuncionario = true;
        while (continuarFuncionario) {
            System.out.println("\nMenu de Funcionários");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Editar Funcionário");
            System.out.println("3. Consultar Funcionário");
            System.out.println("4. Listar Funcionários");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 
            switch (opcao) {
                case 1:
                    cadastrarFuncionario(scanner, funcionariosList);
                    break;
                case 2:
                    editarFuncionario(scanner, funcionariosList);
                    break;
                case 3:
                    consultarFuncionario(scanner, funcionariosList);
                    break;
                case 4:
                    listarFuncionarios(funcionariosList);
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
private static void cadastrarFuncionario(Scanner scanner, ArrayList<Funcionario> funcionariosList) {
        try {
            System.out.print("Digite o CPF: ");
            String cpf = scanner.nextLine();

            System.out.print("Digite o Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o Email: ");
            String email = scanner.nextLine();

            System.out.print("Digite a Matrícula: ");
            int matricula = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Digite o Horário de Trabalho (dd/MM/yyyy HH:mm): ");
            String horarioTrabalho = scanner.nextLine();

            Funcionario funcionario = new Funcionario(cpf, nome, email, matricula, horarioTrabalho);
            if (funcionario.cadastrar(funcionario, funcionariosList)) {
                System.out.println("Funcionário cadastrado com sucesso!");
            }
        } catch (ParseException e) {
            System.out.println("Erro: Formato de data inválido! Use dd/MM/yyyy HH:mm.");
        }
    }
private static void editarFuncionario(Scanner scanner, ArrayList<Funcionario> funcionariosList) {
        System.out.print("Digite a Matrícula do Funcionário a ser editado: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();
        for (Funcionario f : funcionariosList) {
            if (f.getMatricula() == matricula) {
                try {
                    System.out.print("Digite o novo CPF: ");
                    f.setCpf(scanner.nextLine());
                    System.out.print("Digite o novo Nome: ");
                    f.setNome(scanner.nextLine());
                    System.out.print("Digite o novo Email: ");
                    f.setEmail(scanner.nextLine());
                    System.out.print("Digite o novo Horário de Trabalho (dd/MM/yyyy HH:mm): ");
                    String horarioTrabalho = scanner.nextLine();
                    f.setHorarioTrabalho(horarioTrabalho);
                    System.out.println("Funcionário editado com sucesso!");
                    return;
                } catch (Exception e) {
                    System.out.println("Erro: Formato de dados inválido!");
                    return;
                }
            }
        }
        System.out.println("Funcionário não encontrado!");
    }
private static void consultarFuncionario(Scanner scanner, ArrayList<Funcionario> funcionariosList) {
        System.out.print("Digite a Matrícula do Funcionário a ser consultado: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();
        for (Funcionario f : funcionariosList) {
            if (f.getMatricula() == matricula) {
                System.out.println("Funcionário encontrado:");
                System.out.println(f);
                return;
            }
        }
        System.out.println("Funcionário não encontrado!");
    }
private static void listarFuncionarios(ArrayList<Funcionario> funcionariosList) {
        if (funcionariosList.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            System.out.println("\n=== Lista de Funcionários ===");
            for (Funcionario f : funcionariosList) {
                System.out.println(f);
            }
        }
    }


private static void gerenciarFilmeAtor(Scanner scanner, ArrayList<FilmeAtor> filmeAtorList, ArrayList<Filme> filmeList, ArrayList<Ator> atorList) {
        System.out.println("\nGerenciar Filme Ator:");
        System.out.println("1. Cadastrar Filme Ator");
        System.out.println("2. Editar Filme Ator");
        System.out.println("3. Consultar Filme Ator");
        System.out.println("4. Listar Filme Ator");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
    
        switch (opcao) {
            case 1:
                cadastrarFilmeAtor(scanner, filmeAtorList, filmeList, atorList);
                break;
            case 2:
                editarFilmeAtor(scanner, filmeAtorList, filmeList, atorList);
                break;
            case 3:
                consultarFilmeAtor(scanner, filmeAtorList, filmeList, atorList);
                break;
            case 4:
                listarFilmeAtor(scanner, filmeAtorList, filmeList, atorList);
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }
private static void cadastrarFilmeAtor(Scanner scanner, ArrayList<FilmeAtor> filmeAtorList, ArrayList<Filme> filmeList, ArrayList<Ator> atorList) {
    System.out.println("Cadastro de FilmeAtor:");
    System.out.print("Digite o ID do FilmeAtor: ");
    int idFilmeAtor = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Digite o nome do personagem: ");
    String personagem = scanner.nextLine();
    System.out.print("O ator é principal (true/false)? ");
    boolean principal = scanner.nextBoolean();
    System.out.println("Escolha o ator:");
    for (int i = 0; i < atorList.size(); i++) {
        System.out.println((i + 1) + ". " + atorList.get(i).getNome());
    }
    System.out.print("Escolha o número do ator: ");
    int atorIndex = scanner.nextInt() - 1;
    Ator atorSelecionado = atorList.get(atorIndex);

    System.out.println("Escolha o filme:");
    for (int i = 0; i < filmeList.size(); i++) {
        System.out.println((i + 1) + ". " + filmeList.get(i).getTitulo());
    }
    System.out.print("Escolha o número do filme: ");
    int filmeIndex = scanner.nextInt() - 1;
    Filme filmeSelecionado = filmeList.get(filmeIndex);
    FilmeAtor filmeAtor = new FilmeAtor(idFilmeAtor, atorSelecionado, filmeSelecionado, personagem, principal);
    filmeAtor.cadastrar(filmeAtor, filmeAtorList, atorList, filmeList);    
}
private static void editarFilmeAtor(Scanner scanner, ArrayList<FilmeAtor> filmeAtorList, ArrayList<Filme> filmeList, ArrayList<Ator> atorList) {
    System.out.println("Edição de FilmeAtor:");
    System.out.print("Digite o ID do FilmeAtor a ser editado: ");
    int idFilmeAtor = scanner.nextInt();
    scanner.nextLine();

    FilmeAtor filmeAtorEditar = new FilmeAtor(idFilmeAtor, null, null, null, false);
    filmeAtorEditar.editar(filmeAtorEditar, filmeAtorList, atorList, filmeList);
}
private static void consultarFilmeAtor(Scanner scanner, ArrayList<FilmeAtor> filmeAtorList, ArrayList<Filme> filmeList, ArrayList<Ator> atorList) {
    System.out.println("Consulta de FilmeAtor:");
    System.out.print("Digite o ID do FilmeAtor a ser consultado: ");
    int idFilmeAtor = scanner.nextInt();
    scanner.nextLine(); 

    FilmeAtor filmeAtorConsultar = new FilmeAtor(idFilmeAtor, null, null, null, false);
    filmeAtorConsultar.consultar(filmeAtorConsultar, filmeAtorList, atorList, filmeList);
}
private static void listarFilmeAtor(Scanner scanner, ArrayList<FilmeAtor> filmeAtorList, ArrayList<Filme> filmeList, ArrayList<Ator> atorList) {
        FilmeAtor filmeAtorListar = new FilmeAtor(0, null, null, null, false);
        filmeAtorListar.listar(filmeAtorList, atorList, filmeList);
}
}
