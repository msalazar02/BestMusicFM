package Datos;

public class DCanciones {

    private int _idCancion;
    private String _Nombre;
    private int _FK_album;
    private String _Fecha_publicacion;
    private int _fk_genero;
    private String _descripcion;
    private String _sello;
    private String _duracion;

    public DCanciones(int _idCancion, String _Nombre, int _FK_album, String _Fecha_publicacion, int _fk_genero, String _descripcion, String _sello, String _duracion) {
        this._idCancion = _idCancion;
        this._Nombre = _Nombre;
        this._FK_album = _FK_album;
        this._Fecha_publicacion = _Fecha_publicacion;
        this._fk_genero = _fk_genero;
        this._descripcion = _descripcion;
        this._sello = _sello;
        this._duracion = _duracion;
    }

    public DCanciones(int _idCancion, String _Nombre) {
        this._idCancion = _idCancion;
        this._Nombre = _Nombre;
    }

    public DCanciones() {
    }

    public int getIdCancion() {
        return _idCancion;
    }

    public void setIdCancion(int _idCancion) {
        this._idCancion = _idCancion;
    }

    public String getNombre() {
        return _Nombre;
    }

    public void setNombre(String _Nombre) {
        this._Nombre = _Nombre;
    }

    public int getFK_album() {
        return _FK_album;
    }

    public void setFK_album(int _FK_album) {
        this._FK_album = _FK_album;
    }

    public String getFecha_publicacion() {
        return _Fecha_publicacion;
    }

    public void setFecha_publicacion(String _Fecha_publicacion) {
        this._Fecha_publicacion = _Fecha_publicacion;
    }

    public int getFk_genero() {
        return _fk_genero;
    }

    public void setFk_genero(int _fk_genero) {
        this._fk_genero = _fk_genero;
    }

    public String getDescripcion() {
        return _descripcion;
    }

    public void setDescripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public String getSello() {
        return _sello;
    }

    public void setSello(String _sello) {
        this._sello = _sello;
    }

    public String getDuracion() {
        return _duracion;
    }

    public void setDuracion(String _duracion) {
        this._duracion = _duracion;
    }

    
}
