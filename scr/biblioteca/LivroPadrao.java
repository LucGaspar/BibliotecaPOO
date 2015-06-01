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
public interface LivroPadrao {
    
    public void setID(int ID);
    public int  getID();
    public void setTitulo(String Titulo);
    public String getTitulo();
    public void setAutor(String Autor);
    public String getAutor();
    public void setTipo(byte Tipo);
    public byte getTipo();
    public void setAno(short Ano);
    public short getAno();
    
}
