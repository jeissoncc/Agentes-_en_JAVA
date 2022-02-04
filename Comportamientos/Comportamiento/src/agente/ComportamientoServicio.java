
package agente;
import jade.core.Agent;
import jade.domain.FIPAException;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAAgentManagement.DFAgentDescription;



public class ComportamientoServicio extends Agente {
    
    public String servicio;
    
    protected void setup(){
        Object [] arg2 = getArguments();
        servicio =(String) arg2[0];
        System.out.println("El nombre de este agente es: " + this.getLocalName() + "Yo doy el servicio: " + servicio);
        registrerService();
        }
    private void registrerService(){
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(this.getAID());
        
        ServiceDescription sd = new ServiceDescription();
        sd.setType(servicio);
        sd.setName(servicio);
        
        dfd.addServices(sd);
        try{
            DFService.register(this,dfd);
            }
        catch(FIPAException ex){
            System.out.println("El agente: " + getLocalName()+ "No ha podido registrar el servicio: " + ex.getMessage());
            doDelete();
        }
        
    }
}
