/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author Rodrigo Moreno S
 */
public class DAlbumes {

    //-----------------------Declaración de variables---------------------------//
    private int _idAlbum;
    private String _Nombre;
    private String _Descripcion;
    private int _fk_artista;
    private String _fechaLancimiento;
    private String _nombreArtista;

    //-----------------------Declaración de constructores---------------------------//
    public DAlbumes() {
    }

    public DAlbumes(int _idAlbum, String _Nombre, String _Descripcion, int _fk_artista, String _fechaLancimiento) {
        this._idAlbum = _idAlbum;
        this._Nombre = _Nombre;
        this._Descripcion = _Descripcion;
        this._fk_artista = _fk_artista;
        this._fechaLancimiento = _fechaLancimiento;
    }

    public DAlbumes(int _idAlbum, String _Nombre, String _Descripcion, String _fechaLancimiento, String _nombreArtista) {
        this._idAlbum = _idAlbum;
        this._Nombre = _Nombre;
        this._Descripcion = _Descripcion;
        this._fechaLancimiento = _fechaLancimiento;
        this._nombreArtista = _nombreArtista;
    }

    public String getNombreArtista() {
        return _nombreArtista;
    }

    public void setNombreArtista(String _nombreArtista) {
        this._nombreArtista = _nombreArtista;
    }

    public String getFechaLancimiento() {
        return _fechaLancimiento;
    }

    public void setFechaLancimiento(String _fechaLancimiento) {
        this._fechaLancimiento = _fechaLancimiento;
    }

    public int getIdAlbum() {
        return _idAlbum;
    }

    public void setIdAlbum(int _idAlbum) {
        this._idAlbum = _idAlbum;
    }

    public String getNombre() {
        return _Nombre;
    }

    public void setNombre(String _Nombre) {
        this._Nombre = _Nombre;
    }

    public String getDescripcion() {
        return _Descripcion;
    }

    public void setDescripcion(String _Descripcion) {
        this._Descripcion = _Descripcion;
    }

    public int getFk_artista() {
        return _fk_artista;
    }

    public void setFk_artista(int _fk_artista) {
        this._fk_artista = _fk_artista;
    }

}
