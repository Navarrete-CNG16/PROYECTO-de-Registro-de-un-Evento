//pagina 2 .-.
//mis get 


package Tabla;

public class ProductoVO {

    public float getCostoT() {
        return costoT;
    }

/*Todo los atributos*/
    public void setCostoT(float costoT) {
        this.costoT = costoT;
    }

    int clave;
    float costo,costoT;
    String nombreConferencista, nombreConferencia,nombreTaller,Fechaa,Horaa,FechaT,HoraT;

    public String getFechaT() {
        return FechaT;
    }

    public void setFechaT(String FechaT) {
        this.FechaT = FechaT;
    }

    public String getHoraT() {
        return HoraT;
    }

    public void setHoraT(String HoraT) {
        this.HoraT = HoraT;
    }
    private byte[] foto;

    public String getNombreTaller() {
        return nombreTaller;
    }

    public void setNombreTaller(String nombreTaller) {
        this.nombreTaller = nombreTaller;
    }

    
   

public ProductoVO(){}

/*Todo los codigos get*/
public int getclave(){
        return clave;
    }
    public float getCosto() {
        return costo;
    }
     public String getNombreConferencista() {
        return nombreConferencista;
    }
      public String getNombreConferencia() {
        return nombreConferencia;
    }
     public String getFechaa() {
        return Fechaa;
    }
    public String getHoraa() {
        return Horaa;
    }

/*Todo los codigos set*/
    public void setCosto(float costo) {
        this.costo = costo;
    }
     public void setNombreConferencista(String nombreConferencista) {
        this.nombreConferencista = nombreConferencista;
    }
    public void setNombreConferencia(String nombreConferencia) {
        this.nombreConferencia = nombreConferencia;
    }
     public void setFechaa(String Fechaa) {
        this.Fechaa = Fechaa;
    }
    public void setHoraa(String Horaa) {
        this.Horaa = Horaa;
    }
    public void setClave(int clave) {
        this.clave = clave;
    }

    /**
     * @return the foto
     */
    public byte[] getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

}
