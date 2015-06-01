package biblioteca;

public class Geral extends Livro implements LivroPadrao {
    
    private String Editora;
    
    /**
     * Change priority
     */
    public Geral(){
        super((byte) 2);
    }

    /**
     * @return the Editora
     */
    public String getEditora() {
        return Editora;
    }

    /**
     * @param Editora the Editora to set
     */
    public void setEditora(String Editora) {
        this.Editora = Editora;
    }
    
    public String toString(){
        return getID() + "," + getTitulo() + "," + getAutor() + "," + getAno()
                + "," + Editora;
    }
    
}
