package biblioteca;

public class Aluno extends Usuario implements UsuarioPadrao {
    
    private String NumeroUSP;
    private String Curso;
    private String AnoDeIngresso;
   
     /**
     * Change priority
     */
    public Aluno(){
        super((byte) 2);
        super.setMaxLivros(4);
        super.setMaxPrazo(15);
    }

    /**
     * @return the NumeroUSP
     */
    public String getNumeroUSP() {
        return NumeroUSP;
    }

    /**
     * @param NumeroUSP the NumeroUSP to set
     */
    public void setNumeroUSP(String NumeroUSP) {
        this.NumeroUSP = NumeroUSP;
    }

    /**
     * @return the Curso
     */
    public String getCurso() {
        return Curso;
    }

    /**
     * @param Curso the Curso to set
     */
    public void setCurso(String Curso) {
        this.Curso = Curso;
    }

    /**
     * @return the AnoDeIngresso
     */
    public String getAnoDeIngresso() {
        return AnoDeIngresso;
    }

    /**
     * @param AnoDeIngresso the AnoDeIngresso to set
     */
    public void setAnoDeIngresso(String AnoDeIngresso) {
        this.AnoDeIngresso = AnoDeIngresso;
    }
    
    public String toString(){
        return getNome() + "," + getRG() + "," + getNumeroUSP() + "," + getEmail()
                + "," + getCurso() + "," + getAnoDeIngresso();
    }
       
}
