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
public class Livro implements LivroPadrao {

    private int ID;
    private String Titulo;
    private String Autor;
    private byte   Tipo;
    private short  Ano;
    
    public Livro(byte Tipo){
        this.Tipo = Tipo;
    }

    /**
     * @return the Titulo
     */
    public String getTitulo() {
        return Titulo;
    }

    /**
     * @param Titulo the Titulo to set
     */
    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    /**
     * @return the Autor
     */
    public String getAutor() {
        return Autor;
    }

    /**
     * @param Autor the Autor to set
     */
    public void setAutor(String Autor) {
        this.Autor = Autor;
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
     * @return the Ano
     */
    public short getAno() {
        return Ano;
    }

    /**
     * @param Ano the Ano to set
     */
    public void setAno(short Ano) {
        this.Ano = Ano;
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }
    
    public String toString(){
        return getID() + "," + getTitulo() + "," + getAutor() + "," + getAno();
    }
    
}
