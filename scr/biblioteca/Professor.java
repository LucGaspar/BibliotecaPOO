/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

/**
 *
 * @author Lucas
 */
public class Professor extends Usuario implements UsuarioPadrao {
    
    private String NumeroUSP;
    private String Departamento;
    
     /**
     * Change priority
     */
    public Professor(){
        super((byte) 1);
        super.setMaxLivros(6);
        super.setMaxPrazo(60);
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
     * @return the Departamento
     */
    public String getDepartamento() {
        return Departamento;
    }

    /**
     * @param Departamento the Departamento to set
     */
    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }
    
    public String toString(){
        return getNome() + "," + getRG() + "," + getNumeroUSP() + "," + getEmail()
                + "," + getDepartamento();
    }
    
}
