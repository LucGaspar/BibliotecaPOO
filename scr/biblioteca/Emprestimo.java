package biblioteca;

public class Emprestimo {
    
    private String DataEmprestimo;
    private String DataDevolucao;
    private String Livro; // Título
    private String Usuario; // RG

    /**
     * @return the DataEmprestimo
     */
    public String getDataEmprestimo() {
        return DataEmprestimo;
    }

    /**
     * @param DataEmprestimo the DataEmprestimo to set
     */
    public void setDataEmprestimo(String DataEmprestimo) {
        this.DataEmprestimo = DataEmprestimo;
    }

    /**
     * @return the DataDevolucao
     */
    public String getDataDevolucao() {
        return DataDevolucao;
    }

    /**
     * @param DataDevolucao the DataDevolucao to set
     */
    public void setDataDevolucao(String DataDevolucao) {
        this.DataDevolucao = DataDevolucao;
    }

    /**
     * @return the Livro
     */
    public String getLivro() {
        return Livro;
    }

    /**
     * @param Livro the Livro to set
     */
    public void setLivro(String Livro) {
        this.Livro = Livro;
    }

    /**
     * @return the Usuario
     */
    public String getUsuario() {
        return Usuario;
    }

    /**
     * @param Usuario the Usuario to set
     */
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }
    
    public String toString(){
        return getLivro() + "," + getUsuario() + "," + getDataEmprestimo() +
                "," + getDataDevolucao();
    }
    
}
