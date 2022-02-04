
package agente;

import jade.core.Agent;
import jade.core.behaviours.*;


public class ComportamientoCiclico extends Agente {
     class Comportamiento2 extends CyclicBehaviour{
         
         int limite = 100;
         public void action()
         {
             limite++;
             System.out.println("Limite es " + limite);
         }
     }
     
     protected void setup(){
         System.out.println("Hola soy un agente ciclico");
         Comportamiento2 c2= new Comportamiento2();
         addBehaviour(c2);
         System.out.println("Ya se introdujo el comportamiento");
     }
          
    
}


