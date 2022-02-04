
package agente;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;


public class ComportamientoSimple extends Agente {
    
    class TareaSimple extends SimpleBehaviour {
        public void action(){
            for (int i=0;i<10;i++)
                System.out.println("Ciclo "+ i);
        }
        
        public boolean done(){
            return true;
        }
    }
    
    protected void setup(){
        System.out.println("Primer Agente con comportamiento JADE");
        TareaSimple cl = new TareaSimple();
        addBehaviour(cl);
    }   
}
