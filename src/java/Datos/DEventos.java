package Datos;

public class DEventos {

    //-----------------------Declaración de variables---------------------------//
    private int Pk_idEventos;
    private int Fk_idTipoEvento;
    private String Titulo;
    private String Fecha_de_evento;
    private String Ubicacion;
    private String Contenido;
    private int fk_usuario;
    private String TipoEvento;

    //--------------------Declaración de variables para combo eventos------------------------//
    private int idEvento;
    private String Nombre;

    //-----------------------Declaración de constructores---------------------------//
    public DEventos(int Pk_idEventos, int Fk_idTipoEvento, String Titulo, String Fecha_de_evento, String Ubicacion, String Contenido, int fk_usuario) {
        this.Pk_idEventos = Pk_idEventos;
        this.Fk_idTipoEvento = Fk_idTipoEvento;
        this.Titulo = Titulo;
        this.Fecha_de_evento = Fecha_de_evento;
        this.Ubicacion = Ubicacion;
        this.Contenido = Contenido;
        this.fk_usuario = fk_usuario;
    }

    public DEventos(int Pk_idEventos, int Fk_idTipoEvento, String Titulo, String Fecha_de_evento, String Ubicacion, String Contenido) {
        this.Pk_idEventos = Pk_idEventos;
        this.Fk_idTipoEvento = Fk_idTipoEvento;
        this.Titulo = Titulo;
        this.Fecha_de_evento = Fecha_de_evento;
        this.Ubicacion = Ubicacion;
        this.Contenido = Contenido;

    }

    public DEventos(int Pk_idEventos, String Titulo, String Fecha_de_evento, String Ubicacion, String Contenido, String TipoEvento) {
        this.Pk_idEventos = Pk_idEventos;
        this.Titulo = Titulo;
        this.Fecha_de_evento = Fecha_de_evento;
        this.Ubicacion = Ubicacion;
        this.Contenido = Contenido;
        this.TipoEvento = TipoEvento;
    }

    public DEventos(int idEvento, String Nombre) {
        this.idEvento = idEvento;
        this.Nombre = Nombre;
    }

    public DEventos() {
    }

    //-----------------------Declaración de getters y setters---------------------------//
    public int getPk_idEventos() {
        return Pk_idEventos;
    }

    public void setPk_idEventos(int Pk_idEventos) {
        this.Pk_idEventos = Pk_idEventos;
    }

    public int getFk_idTipoEvento() {
        return Fk_idTipoEvento;
    }

    public void setFk_idTipoEvento(int Fk_idTipoEvento) {
        this.Fk_idTipoEvento = Fk_idTipoEvento;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getFecha_de_evento() {
        return Fecha_de_evento;
    }

    public void setFecha_de_evento(String Fecha_de_evento) {
        this.Fecha_de_evento = Fecha_de_evento;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    public String getContenido() {
        return Contenido;
    }

    public void setContenido(String Contenido) {
        this.Contenido = Contenido;
    }

    public int getFk_usuario() {
        return fk_usuario;
    }

    public void setFk_usuario(int fk_usuario) {
        this.fk_usuario = fk_usuario;
    }

    public String getTipoEvento() {
        return TipoEvento;
    }

    public void setTipoEvento(String TipoEvento) {
        this.TipoEvento = TipoEvento;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

}
