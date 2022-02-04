package fabrica;

import jade.core.*;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;

public class Ensamble extends Agent {

    private PartesBicicleta bicicleta;
    private static final String inicio = "inicio";
    private static final String marco = "marco";
    private static final String llantas = "llantas";
    private static final String asiento = "silla";
    private static final String equipo = "equipo";
    private static final String fin = "fin";
    private final int UNO = 1;
    private final int DOS = 2;
    private final int TRES = 3;
    private final int CERO = 0;
    private String entrada = "";

    public void setup() {
        entrada = "231231231";
        addBehaviour(new Recibirsolicitud());
    }
    
    

    class Recibirsolicitud extends CyclicBehaviour {       
        private boolean fin = false;

        public void action() {            
            System.out.println(" Preparandose para recibir");

            //Obtiene el primer mensaje de la cola de mensajes
            ACLMessage mensaje = receive();

            if (mensaje != null) {
                System.out.println(getLocalName() + ": acaba de recibir el siguiente mensaje: ");
                System.out.println(mensaje.toString());
                //innsta
                bicicleta=new PartesBicicleta();
                MiFSMBehaviour b = new MiFSMBehaviour(this.myAgent, entrada);
                    addBehaviour(b);
                //mandarla a ensam
                fin = true;
            }
        }

        //public boolean done() {
          //  return fin;
        //}
    }


    private class MiFSMBehaviour extends FSMBehaviour {

        private int transicion = 0;
        private String entrada = "";

        public MiFSMBehaviour(Agent _agente, String ent) {
            super(_agente);
            entrada = ent;
        }

        public void onStart() {
            registerFirstState(new OneBehaviour(), inicio);
            registerState(new TwoBehaviour(), marco);
            registerState(new ThreeBehaviour(), llantas);
            registerState(new FourBehaviour(), asiento);
            registerState(new FiveBehaviour(), equipo);
            registerLastState(new FinBehaviour(), fin);
            registerTransition(inicio, marco, CERO);
            registerTransition(marco, llantas, CERO);
            registerTransition(marco, asiento, UNO);
            registerTransition(llantas, asiento, CERO);
            registerTransition(llantas, equipo, UNO);
            registerTransition(asiento, llantas, UNO);
            registerTransition(asiento, equipo, CERO);
            registerTransition(equipo, asiento, UNO);
            registerTransition(equipo, llantas, CERO);
            registerTransition(equipo, fin, DOS);

        }

        protected boolean checkTermination(boolean currentDone, int currentResult) {
            System.out.println("Terminado " + currentName);
            return super.checkTermination(currentDone, currentResult);
        }


        private class OneBehaviour extends OneShotBehaviour {

            public void action() {
                System.out.println(" iniciando ensamblaje");
            }

            public int onEnd() {
                return CERO;
            }
        }

        private class TwoBehaviour extends OneShotBehaviour {

            public void action() {
                System.out.println("Instalando marco");
                bicicleta.setMarco(1);
            }

            public int onEnd() {
                if(bicicleta.getLlantas()==0){
                    return CERO;
                }
                else{
                return UNO;}
            }
        }

        private class ThreeBehaviour extends OneShotBehaviour {

            public void action() {
                System.out.println("Instalando llantas");
                bicicleta.setLlantas(1);
            }

            public int onEnd() {
                if(bicicleta.getAsiento()==0){
                    return CERO;
                }
                else{
                return UNO;}
            }
        }

        private class FourBehaviour extends OneShotBehaviour {

            public void action() {
                System.out.println("Instalando asiento");
                bicicleta.setAsiento(1);
            }

            public int onEnd() {
                if(bicicleta.getLlantas()==0){
                    return UNO;
                }
                else{
                return CERO;}
            }
        }

        private class FiveBehaviour extends OneShotBehaviour {

            public void action() {
                System.out.println("Instalando equipo");
                bicicleta.setEquipo(1);
            }

            public int onEnd() {
                if(bicicleta.getLlantas()==0){
                    return CERO;
                }
                else{ if(bicicleta.getAsiento()==0){
                            return UNO;
                        }
                        else{
                        return DOS;}               
            }
            }
        }

        private class FinBehaviour extends OneShotBehaviour {

            public void action() {
                System.out.println("Bicicleta terminada");
            }
        }
    }

}