package Datos;

public class DFans {

//--------------------------Variables-------------------------------------------
    private int _idFan;
    private int _idGenero;

//--------------------------Constructores---------------------------------------
    //insertar
    public DFans(int _idFan, int _idGenero) {
        this._idFan = _idFan;
        this._idGenero = _idGenero;
    }

    public DFans() {
    }

//--------------------------Getters y Setters-----------------------------------
    public int getIdFan() {
        return _idFan;
    }

    public void setIdFan(int _idFan) {
        this._idFan = _idFan;
    }

    public int getIdGenero() {
        return _idGenero;
    }

    public void setIdGenero(int _idGenero) {
        this._idGenero = _idGenero;
    }

}
