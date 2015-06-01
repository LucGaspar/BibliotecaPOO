package biblioteca;

public class Usuario implements UsuarioPadrao {
    
    private int MaxLivros;
    private int MaxPrazo;
    private String Nome;
    private String RG;
    private String Email;
    private byte   Tipo;
    private int Estado; // 0 se não tá com atraso, se maior que zero, o valor
                        // é a quantidade de dias
    
    public Usuario(byte Tipo){
        this.Tipo = Tipo; // 1 - Professor | 2 - Aluno | 3 - Comunidade
        Estado = 0;
    }

    /**
     * @return the Nome
     */
    public String getNome() {
        return Nome;
    }

    /**
     * @param Nome the Nome to set
     */
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    /**
     * @return the RG
     */
    public String getRG() {
        return RG;
    }

    /**
     * @param RG the RG to set
     */
    public void setRG(String RG) {
        this.RG = RG;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the Tipo
     */
    public byte getTipo() {
        return Tipo;
    }

    /**
     * @param Tipo the Tipo to set
     */
    public void setTipo(byte Tipo) {
        this.Tipo = Tipo;
    }

    /**
     * @return the Estado
     */
    public int getEstado() {
        return Estado;
    }

    /**
     * @param Estado the Estado to set
     */
    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    /**
     * @return the MaxLivros
     */
    public int getMaxLivros() {
        return MaxLivros;
    }

    /**
     * @param MaxLivros the MaxLivros to set
     */
    public void setMaxLivros(int MaxLivros) {
        this.MaxLivros = MaxLivros;
    }

    /**
     * @return the MaxPrazo
     */
    public int getMaxPrazo() {
        return MaxPrazo;
    }

    /**
     * @param MaxPrazo the MaxPrazo to set
     */
    public void setMaxPrazo(int MaxPrazo) {
        this.MaxPrazo = MaxPrazo;
    }
    
    public String toString(){
        return getNome() + "," + getRG() + "," + getEmail();
    }

}
