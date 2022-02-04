package fabrica;

import jade.core.*;
import jade.core.behaviours.*;
import jade.lang.acl.*;

public class Cliente extends Agent {
    
class solicitarEnsamble extends SimpleBehaviour {
    String nameAgent;
    
    public solicitarEnsamble (String n) {nameAgent = n;}
    public void action(){
        
        doWait(20000);
        ACLMessage acl = new ACLMessage(ACLMessage.REQUEST);
        AID agrec = new AID(nameAgent, AID.ISLOCALNAME);
        acl.addReceiver(agrec);
        acl.setContent("Iniciar Fabricacion");
        send (acl);      
    }
    
    public boolean done(){
        return true;
    }
}

protected void setup(){
    
    Object[] listaparametros = getArguments();
    String nameAgenteR = (String) listaparametros[0];
    
    System.out.println("Iniciar Fabricacion ");
    
    solicitarEnsamble se = new solicitarEnsamble(nameAgenteR);
    addBehaviour(se);
}
}