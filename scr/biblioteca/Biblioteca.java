/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author Lucas
 */
public class Biblioteca {
    
    static List<UsuarioPadrao> Usuarios = new ArrayList<>();
    static List<LivroPadrao> Livros = new ArrayList<>();
    static List<Emprestimo> Emprestimos = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    static Biblioteca biblioteca;
    Sistema sistemaDeData = new Sistema();
    static String Delimitador = ",";
    static String csvProfessor;
    static String csvAluno;
    static String csvComunidade;
    static String csvTexto;
    static String csvGeral;

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //System.out.println(sistemaDeData.compareDate("03/06/2015"));
        biblioteca = new Biblioteca();
        try{
            csvProfessor = args[0];
            csvAluno     = args[1];
            csvComunidade= args[2];
            csvTexto     = args[3];
            csvGeral     = args[4];
        }catch(Exception e){
            csvProfessor = "Professor.csv";
            csvAluno     = "Aluno.csv";
            csvComunidade= "Comunidade.csv";
            csvTexto     = "Texto.csv";
            csvGeral     = "Geral.csv";
        }

        biblioteca.carregaCSV(csvProfessor, csvAluno, csvComunidade, csvTexto, csvGeral);
        biblioteca.menuPrincipal();
    }
    
    public void carregaCSV(String csvProfessores, String csvAlunos,
            String csvComunidade, String csvTexto, String csvGeral) throws IOException {
        BufferedReader in;
        String csv;
        
        try {
            in = new BufferedReader(new FileReader("Emprestimo.csv"));
            if (in != null)
                while((csv = in.readLine()) != null){
                    Emprestimo emprestimo  = new Emprestimo();
                    String[] values = csv.split(Delimitador);
                    emprestimo.setLivro(values[0]);
                    emprestimo.setUsuario(values[1]);
                    emprestimo.setDataEmprestimo(values[2]);
                    emprestimo.setDataDevolucao(values[3]);
                    Emprestimos.add(emprestimo);
                }
        } catch (FileNotFoundException ex){
            in = null;
        }
        
        try {
            in = new BufferedReader(new FileReader(csvProfessores));
        } catch (FileNotFoundException ex) {
            in = null;
        }
       
        if (in != null)
            while((csv = in.readLine()) != null){
                Professor professor  = new Professor();
                String[] values = csv.split(Delimitador);
                professor.setNome(values[0]);
                professor.setRG(values[1]);
                professor.setNumeroUSP(values[2]);
                professor.setEmail(values[3]);
                professor.setDepartamento(values[4]);
                Usuarios.add(professor);
            }
        
        try {
            in = new BufferedReader(new FileReader(csvAlunos));
        } catch (FileNotFoundException ex) {
            in = null;
        }
        if (in != null)
            while((csv = in.readLine()) != null){
                Aluno aluno  = new Aluno();
                String[] values = csv.split(Delimitador);
                aluno.setNome(values[0]);
                aluno.setRG(values[1]);
                aluno.setNumeroUSP(values[2]);
                aluno.setEmail(values[3]);
                aluno.setCurso(values[4]);
                aluno.setAnoDeIngresso(values[5]);
                Usuarios.add(aluno);
            }
        
        try {
            in = new BufferedReader(new FileReader(csvComunidade));
        } catch (FileNotFoundException ex) {
            in = null;
        }
        if (in != null)
            while((csv = in.readLine()) != null){
                Comunidade comunidade  = new Comunidade();
                String[] values = csv.split(Delimitador);
                comunidade.setNome(values[0]);
                comunidade.setRG(values[1]);
                comunidade.setEndereco(values[2]);
                comunidade.setEmail(values[3]);
                comunidade.setTelefone(values[4]);
                comunidade.setNascimento(values[5]);
                Usuarios.add(comunidade);
            }
        
        try {
            in = new BufferedReader(new FileReader(csvTexto));
        } catch (FileNotFoundException ex) {
            in = null;
        }
        if (in != null)
            while((csv = in.readLine()) != null){
                Texto texto  = new Texto();
                String[] values = csv.split(Delimitador);
                texto.setID(Integer.parseInt(values[0]));
                texto.setTitulo(values[1]);
                texto.setAutor(values[2]);
                texto.setAno(Short.parseShort(values[3]));
                texto.setArea(values[4]);
                texto.setInstituicao(values[5]);
                Livros.add(texto);
            }
        
        try {
            in = new BufferedReader(new FileReader(csvGeral));
        } catch (FileNotFoundException ex) {
            in = null;
        }
        if (in != null)
            while((csv = in.readLine()) != null){
                Geral geral  = new Geral();
                String[] values = csv.split(Delimitador);
                geral.setID(Integer.parseInt(values[0]));
                geral.setTitulo(values[1]);
                geral.setAutor(values[2]);
                geral.setAno(Short.parseShort(values[3]));
                geral.setEditora(values[4]);
                Livros.add(geral);
            }
        
    }
    
    public void menuPrincipal() throws IOException{
        System.out.print("1 - Cadastrar Usuario\n2 - Cadastrar Livro\n"
                + "3 - Emprestimo\n4 - Devolucao\n5 - Checar Suspensão\n"
                + "6 - Listar\n7 - Data\n8 - Sair\n Opcao: ");
        int option = Integer.parseInt(scanner.nextLine());
        switch( option ){
            case 1: biblioteca.menuCadastroUsuario(); break;
            case 2: biblioteca.menuCadastroLivro(); break;
            case 3: biblioteca.menuEmprestimo(); break;
            case 4: biblioteca.menuDevolucao(); break;
            case 5: biblioteca.menuSuspensao(); break;
            case 6: biblioteca.menuListagem(); break;
            case 7: biblioteca.menuData(); break;
            case 8: biblioteca.sair(); break;
            
        }
    }

    private void menuCadastroUsuario() throws IOException {
        System.out.print("\nQual o tipo de usuario a cadastrar?\n"
                + "1 - Professor\n2 - Aluno\n3 - Comunidade\nOpcao: ");
        int option = Integer.parseInt(scanner.nextLine());
        String Nome;
        String RG;
        String Email;
        System.out.println("\nInsira as informacoes");
        System.out.print("Nome: ");
        Nome = scanner.nextLine();
        System.out.print("RG: ");
        RG   = scanner.nextLine();
        System.out.print("Email: ");
        Email= scanner.nextLine();
        BufferedWriter fileWriter = null;
        switch (option){
            // Professor
            case 1: {
                System.out.print("NumeroUSP: ");
                String NumeroUSP = scanner.nextLine();
                System.out.print("Departamento: ");
                String Departamento = scanner.nextLine();
                Professor Usuario = new Professor();
                Usuario.setDepartamento(Departamento);
                Usuario.setEmail(Email);
                Usuario.setNome(Nome);
                Usuario.setNumeroUSP(NumeroUSP);
                Usuario.setRG(RG);
                Usuarios.add(Usuario);
                fileWriter = new BufferedWriter(new FileWriter(csvProfessor, true));
                break;
            }
            // Professor
            case 2: {
                System.out.print("NumeroUSP: ");
                String NumeroUSP = scanner.nextLine();
                System.out.print("Curso: ");
                String Curso = scanner.nextLine();
                System.out.print("Ano de Ingresso: ");
                String AnoDeIngresso = scanner.nextLine();
                Aluno Usuario = new Aluno();
                Usuario.setAnoDeIngresso(AnoDeIngresso);
                Usuario.setCurso(Curso);
                Usuario.setEmail(Email);
                Usuario.setNome(Nome);
                Usuario.setNumeroUSP(NumeroUSP);
                Usuario.setRG(RG);
                Usuarios.add(Usuario);
                fileWriter = new BufferedWriter(new FileWriter(csvAluno, true));
                break;
            } 
            // Comunidade
            case 3: {
                System.out.print("Endereco: ");
                String Endereco = scanner.nextLine();
                System.out.print("Nascimento: ");
                String Nascimento = scanner.nextLine();
                System.out.print("Telefone: ");
                String Telefone   = scanner.nextLine();
                Comunidade Usuario = new Comunidade();
                Usuario.setEmail(Email);
                Usuario.setEndereco(Endereco);
                Usuario.setNascimento(Nascimento);
                Usuario.setNome(Nome);
                Usuario.setRG(RG);
                Usuario.setTelefone(Telefone);
                Usuarios.add(Usuario);
                fileWriter = new BufferedWriter(new FileWriter(csvComunidade, true));
                break;
            }
        }    
        clearConsole();
        System.out.println("\nUsuario cadastrado com sucesso!");
        fileWriter.append(Usuarios.get(Usuarios.size() - 1).toString() + "\n");
        fileWriter.flush();
        fileWriter.close();
        biblioteca.menuPrincipal();
    }

    private void menuCadastroLivro() throws IOException {
        System.out.print("\nQual o tipo de livro a cadastrar?\n"
                + "1 - Texto\n2 - Geral\nOpcao: ");
        int option = Integer.parseInt(scanner.nextLine());
        String Titulo;
        String Autor;
        short  Ano;
        int    ID;
        System.out.println("\nInsira as informacoes");
        System.out.print("Titulo: ");
        Titulo = scanner.nextLine();
        System.out.print("Autor: ");
        Autor   = scanner.nextLine();
        System.out.print("Ano: ");
        Ano     = Short.parseShort(scanner.nextLine());
        System.out.print("Numero de Identificacao: ");
        ID      = Integer.parseInt(scanner.nextLine());
        BufferedWriter fileWriter = null;
        switch (option){
            // Texto
            case 1: {
                System.out.print("Instituicao: ");
                String Instituicao = scanner.nextLine();
                System.out.print("Area: ");
                String Area = scanner.nextLine();
                Texto Livro = new Texto();
                Livro.setAno(Ano);
                Livro.setArea(Area);
                Livro.setAutor(Autor);
                Livro.setInstituicao(Instituicao);
                Livro.setTitulo(Titulo);
                Livro.setID(ID);
                Livros.add(Livro);
                fileWriter = new BufferedWriter(new FileWriter(csvTexto, true));
                break;
            }
            // Geral
            case 2: {
                System.out.print("Editora: ");
                String Editora = scanner.nextLine();
                Geral Livro = new Geral();
                Livro.setAno(Ano);
                Livro.setEditora(Editora);
                Livro.setAutor(Autor);
                Livro.setTitulo(Titulo);
                Livro.setID(ID);
                Livros.add(Livro);
                fileWriter = new BufferedWriter(new FileWriter(csvGeral, true));
                break;
            } 
        }    
        clearConsole();
        System.out.println("Livro cadastrado com sucesso!");
         
        fileWriter.append(Livros.get(Livros.size() - 1).toString() + "\n");
        fileWriter.flush();
        fileWriter.close();
        try {
            biblioteca.menuPrincipal();
        } catch (IOException ex) {
            Logger.getLogger(Biblioteca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void menuEmprestimo() throws IOException {
        System.out.print("\nTitulo: ");
        String Nome = scanner.nextLine();

        System.out.print("RG do Usuário: ");
        String RG = scanner.nextLine();
        
        // Pesquisa Usuário
        List<UsuarioPadrao> Usuario =
                Usuarios
                    .stream()
                    .filter(s -> s.getRG().equals(RG))
                    .collect(Collectors.toList());
        
        if (Usuario.isEmpty()){
            clearConsole();
            System.out.println("\nUsuário não encontrado\n");
            biblioteca.menuPrincipal();
            return;
        }
        
        // Checa se o usuário não está suspenso
        if (Usuario.get(0).getEstado() > 0){
            clearConsole();
            System.out.println("O usuário está suspenso.\n");
            biblioteca.menuPrincipal();
            return;
        }
        
        // Pesquisa o Usuário em todos os empréstimos
        List<Emprestimo> emprestimos =
                Emprestimos
                    .stream()
                    .filter(s -> s.getUsuario().equals(Usuario.get(0).getRG()))
                    .collect(Collectors.toList());
        
        // Checa se o usuário não está com livros atrasados
        for (Emprestimo emprestimo : emprestimos) {
            if (sistemaDeData.compareDate(emprestimo.getDataDevolucao()) > 0){
                clearConsole();
                System.out.println("O usuário está com livros em atraso" + 
                        sistemaDeData.compareDate(emprestimo.getDataDevolucao()));
                biblioteca.menuPrincipal();
                return;
            }
        }
        
        if (emprestimos.size() == Usuario.get(0).getMaxLivros()){
            clearConsole();
            System.out.println("Usuário já pegou o limite de livros");
            biblioteca.menuPrincipal();
            return;
        }
        
        final String Nome_ = Nome;   
        List<LivroPadrao> Livro;
        // Pesquisa Livro pelo Título
        Livro = 
            Livros
                .stream()
                .filter(s -> s.getTitulo().equals(Nome_))
                .collect(Collectors.toList());

        
        // Se não encontrou o livro
        if (Livro.isEmpty()){
            clearConsole();
            System.out.println("\nLivro não encontrado\n");
            biblioteca.menuPrincipal();
            return;
        }
        
        // Verifica se o livro já não está emprestado
        List<Emprestimo> emprestimoss =
                Emprestimos
                    .stream()
                    .filter(s -> s.getLivro().equals(Livro.get(0).getTitulo()))
                    .collect(Collectors.toList());
        
        // Livro já está emprestado
        if (emprestimoss.isEmpty() != true){
            clearConsole();
            System.out.println("Livro já está emprestado\n");
            biblioteca.menuPrincipal();
            return;
        }
        
        // Cria empréstimo
        Emprestimo emp = new Emprestimo();
        emp.setLivro(Livro.get(0).getTitulo());
        emp.setUsuario(Usuario.get(0).getRG());
        emp.setDataEmprestimo(sistemaDeData.getDataString());
        sistemaDeData.incrementDays(Usuario.get(0).getMaxPrazo());
        emp.setDataDevolucao(sistemaDeData.getDataString());
        sistemaDeData.incrementDays(-1 * Usuario.get(0).getMaxPrazo());
        Emprestimos.add(emp);
        clearConsole();
        System.out.println("Emprestimo feito com sucesso!");
        biblioteca.writeEmprestimoCSV();
        biblioteca.menuPrincipal();
    }
    
    private void writeEmprestimoCSV() throws IOException{
        FileWriter fileWriter = new FileWriter("Emprestimo.csv");
        fileWriter.write("");
        for (Emprestimo emprestimo : Emprestimos)
            fileWriter.append(emprestimo.toString() + "\n");
        
        fileWriter.flush();
        fileWriter.close();
    }

    private void menuDevolucao() throws IOException {
        System.out.print("\nTitulo do Livro: ");
        String Titulo = scanner.nextLine();
        
        List<Emprestimo> emprestimos =
                Emprestimos
                    .stream()
                    .filter(s -> s.getLivro().equals(Titulo))
                    .collect(Collectors.toList());
        
        if (emprestimos.isEmpty()){
            clearConsole();
            System.out.println("Livro não foi emprestado!");
            biblioteca.menuPrincipal();
            return;
        }
        
        List<UsuarioPadrao> usuarios =
                Usuarios
                    .stream()
                    .filter(s -> s.getRG().equals(emprestimos.get(0).getUsuario()))
                    .collect(Collectors.toList());
        
        long atraso = sistemaDeData.compareDate(emprestimos.get(0).getDataDevolucao());
        
        if (atraso > 0)
            usuarios.get(0).setEstado((int) (usuarios.get(0).getEstado() + atraso));
        
        Emprestimos.remove(emprestimos.get(0));
        clearConsole();
        System.out.println("Devolução feita com sucesso!");
        biblioteca.writeEmprestimoCSV();
        biblioteca.menuPrincipal();
    }

    private void menuSuspensao() throws IOException {
        System.out.print("\nRG do Usuário: ");
        String RG = scanner.nextLine();
        
        List<UsuarioPadrao> usuario =
                Usuarios
                    .stream()
                    .filter(s -> s.getRG().equals(RG))
                    .collect(Collectors.toList());
        
        if (usuario.isEmpty()){
            clearConsole();
            System.out.println("Usuário não encontrado!");
            biblioteca.menuPrincipal();
            return;
        }
        
        if (usuario.get(0).getEstado() > 0){
            clearConsole();
            System.out.println("Usuário suspenso por " + usuario.get(0).getEstado() +
                    " dias");
        }
        else{
            List<Emprestimo> emprestimos =
                    Emprestimos
                        .stream()
                        .filter(s -> s.getUsuario().equals(usuario.get(0).getRG()))
                        .collect(Collectors.toList());
            
            for (Emprestimo emprestimo : emprestimos)
                if (sistemaDeData.compareDate(emprestimo.getDataDevolucao()) > 0){
                    clearConsole();
                    System.out.println("Usuário esta com livros em atraso");
                    biblioteca.menuPrincipal();
                    return;
                }
                
            clearConsole();
            System.out.println("Usuário não está suspenso");
        }
        
        
        biblioteca.menuPrincipal();
    }

    private void menuListagem() throws IOException {
        int i;
        System.out.println("\n\nEscolha o que quer listar\n1 - Usuários\n"
                + "2 - Livros\n3 - Empréstimos");
        System.out.print("Opcao: ");
        int option = Integer.parseInt(scanner.nextLine());
        
        switch (option){
            case 1: {
                if (Usuarios.size() == 0){
                    biblioteca.clearConsole();
                    System.out.println("\nSem usuários cadastrados");
                }
                System.out.println("\n\n");
                for (i = 0; i < Usuarios.size(); i++)
                    System.out.println(Usuarios.get(i).toString());
                System.out.println("\n\n");
                break;
            }
            case 2: {
                if (Livros.isEmpty()){
                    biblioteca.clearConsole();
                    System.out.println("\nSem livros cadastrados");
                }
                
                System.out.println("\n\n");
                for (i = 0; i < Livros.size(); i++)
                    System.out.println(Livros.get(i).toString());
                System.out.println("\n\n");
                break;
            }
            case 3: {
                if (Emprestimos.isEmpty()){
                    biblioteca.clearConsole();
                    System.out.println("\nSem empréstimos feitos");
                }
                System.out.println("\n\n");
                for (i = 0; i < Emprestimos.size(); i++)
                    System.out.println(Emprestimos.get(i).toString());
                System.out.println("\n\n");
                break;
            }
        }
        biblioteca.menuPrincipal();
    }
    
    public final static void clearConsole(){
        char c = '\n';
        int length = 25;
        char[] chars = new char[length];
        Arrays.fill(chars, c);
        System.out.print(String.valueOf(chars));
}

    private void sair() {

    }

    private void menuData() throws IOException {
        System.out.println("\nData atual: " + sistemaDeData.getDataString());
        System.out.print("\n1 - Alterar\n2 - Voltar\nOpcao: ");
        int option = Integer.parseInt(scanner.nextLine());
        switch(option){
            case 1: {
                System.out.print("\nDias a avançar: ");
                int Data = Integer.parseInt(scanner.nextLine());
                biblioteca.updateSuspensao(Data);
                sistemaDeData.incrementDays(Data);
                this.menuData();
                break;
            }
            case 2: {
                clearConsole();
                biblioteca.menuPrincipal();
                break;
            }
        }
    }

    private void updateSuspensao(long Diferenca) {
        // Só muda Estado se não há outros livros atrasados
        for (UsuarioPadrao usuario : Usuarios){
                List<Emprestimo> emprestimos =
                        Emprestimos
                            .stream()
                            .filter(s -> s.getUsuario().equals(usuario.getRG()))
                            .collect(Collectors.toList());
                boolean flag = true;
                for (Emprestimo emprestimo : emprestimos) {
                    if (sistemaDeData.compareDate(emprestimo.getDataDevolucao()) > 0){
                        flag = false;
                        return;
                    }
                }
                if (flag){
                    usuario.setEstado((int) (usuario.getEstado() - Diferenca));
                    if (usuario.getEstado() < 0)
                        usuario.setEstado(0);
                }
        }

    }
    
}