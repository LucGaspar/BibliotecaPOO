package biblioteca;

public class Texto extends Livro implements LivroPadrao {
    
        private String Instituicao;
        private String Area;
        
    /**
     * Change priority
     */
    public Texto(){
        super((byte) 1);
    }

    /**
     * @return the Instituicao
     */
    public String getInstituicao() {
        return Instituicao;
    }

    /**
     * @param Instituicao the Instituicao to set
     */
    public void setInstituicao(String Instituicao) {
        this.Instituicao = Instituicao;
    }

    /**
     * @return the Area
     */
    public String getArea() {
        return Area;
    }

    /**
     * @param Area the Area to set
     */
    public void setArea(String Area) {
        this.Area = Area;
    }
    
    public String toString(){
        return getID() + "," + getTitulo() + "," + getAutor() + "," + getAno()
                + "," + getArea() + "," + getInstituicao();
    }
}
