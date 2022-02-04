package agente;
import jade.core.Agent;

public class Agente extends Agent{
       protected void setup(){
           Object [] listaparametros= getArguments();
           String primerArgumento = (String) listaparametros[0];
           System.out.println("Hola Mundo soy el primer agente"+ getLocalName()+"Argumento" + primerArgumento);
           }              
}