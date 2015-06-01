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
public interface UsuarioPadrao {
    void setNome(String Nome);
    String getNome();
    void setRG(String RG);
    String getRG();
    public void setTipo(byte Tipo);
    public byte getTipo();
    public void setEmail(String Email);
    public String getEmail();
    public int getMaxLivros();
    public int getMaxPrazo();
    public int getEstado();
    public void setEstado(int Estado);
}
