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
public class Comunidade extends Usuario implements UsuarioPadrao {
    
    private String Endereco;
    private String Nascimento;
    private String Telefone;
    
    /**
     * Change priority
     */
    public Comunidade(){
        super((byte) 3);
        super.setMaxLivros(2);
        super.setMaxPrazo(15);
    }

    /**
     * @return the Endereco
     */
    public String getEndereco() {
        return Endereco;
    }

    /**
     * @param Endereco the Endereco to set
     */
    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    /**
     * @return the Nascimento
     */
    public String getNascimento() {
        return Nascimento;
    }

    /**
     * @param Nascimento the Nascimento to set
     */
    public void setNascimento(String Nascimento) {
        this.Nascimento = Nascimento;
    }

    /**
     * @return the Telefone
     */
    public String getTelefone() {
        return Telefone;
    }

    /**
     * @param Telefone the Telefone to set
     */
    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }
    
    public String toString(){
        return getNome() + "," + getRG() + "," + getEndereco() + "," + getEmail()
                + "," + getTelefone() + "," + getNascimento();         
    }
    
}
