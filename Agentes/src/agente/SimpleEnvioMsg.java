
package agente;

import jade.core.*;
import jade.core.behaviours.*;
import jade.lang.acl.*;

public class SimpleEnvioMsg extends Agente {
    
class comportEnvia extends SimpleBehaviour {
    String nameAgent;
    
    public comportEnvia (String n) {nameAgent = n;}
    public void action(){
        
        doWait(20000);
        ACLMessage acl = new ACLMessage(ACLMessage.REQUEST);
        AID agrec = new AID(nameAgent, AID.ISLOCALNAME);
        acl.addReceiver(agrec);
        acl.setContent("Mensaje1");
        send (acl);      
    }
    
    public boolean done(){
        return true;
    }
}

protected void setup(){
    
    Object[] listaparametros = getArguments();
    String nameAgenteR = (String) listaparametros[0];
    
    System.out.println("Hola soy el primer Agente " + getLocalName());
    
    comportEnvia ce = new comportEnvia(nameAgenteR);
    addBehaviour(ce);
}
}
