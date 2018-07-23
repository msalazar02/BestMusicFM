/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Otros;

/**
 *
 * @author Rodrigo Moreno S
 */
public class DGeneros {

    private int _idGenero;
    private String _Nombre;
    private String _Descripcion;

    public DGeneros(int _idGenero, String _Nombre, String _Descripcion) {
        this._idGenero = _idGenero;
        this._Nombre = _Nombre;
        this._Descripcion = _Descripcion;
    }

    public DGeneros() {
    }

    public int getIdGenero() {
        return _idGenero;
    }

    public void setIdGenero(int _idGenero) {
        this._idGenero = _idGenero;
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
   

}
