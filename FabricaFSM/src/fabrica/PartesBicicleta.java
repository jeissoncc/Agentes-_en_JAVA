/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabrica;


import jade.core.Agent;
//import jade.core.behaviours.*;
//import java.lang.*;

/**
 *
 * @author usuarioutp
 */
public class PartesBicicleta extends Agent{
    int marco = 0;
    int llantas = 0;
    int asiento = 0;
    int equipo = 0; 
    int bicicleta = 0;
    
    public int getMarco(){
        return marco;
    }
    
    public void setMarco(int marco) {
        this.marco = marco;
    }
    
    public int getLlantas(){
        return llantas;
    }
    
    public void setLlantas(int llantas) {
        this.llantas = llantas;
    }
    
    public int getAsiento(){
        return asiento;
    }
    
    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }
    
    public int getEquipo(){
        return equipo;
    }
    
    public void setEquipo(int equipo) {
        this.equipo = equipo;
    }
    
    public int getBicicleta(){
        return bicicleta;
    }
    
    public void setBicicleta(int bicicleta) {
        this.bicicleta = bicicleta;
    }
}
