package br.anhembi;

import java.util.ArrayList;

/**
 * ManageAttendance
 */
public class ManageAttendance {

    private  ArrayList<Client> filaComum = new ArrayList<Client>();

    private  ArrayList<Client> filaPrioritaria = new ArrayList<Client>();
    private  int ordenador = 0;

    public ManageAttendance( int size) {

    }

    public boolean isEmpty() {
        return (this.filaComum.isEmpty() && this.filaPrioritaria.isEmpty());
    }

    public void addClient( Client client) {
        if(client.getAge() >= 60){
            this.filaPrioritaria.add(client);
        }else{
            this.filaComum.add(client);
        }

    }

    public Client showNext() {
        Client temp;
        if(!this.filaComum.isEmpty() && !this.filaPrioritaria.isEmpty()){
            if(this.ordenador <= 2){
                temp = this.filaPrioritaria.get(0);
            }else{
                temp = this.filaComum.get(0);
            }
        }else if(!this.filaComum.isEmpty() && this.filaPrioritaria.isEmpty()){
            temp = this.filaComum.get(0);
        }else{
            temp = this.filaPrioritaria.get(0);
        }
        return temp;        
    }

    public Client getNext() {
        Client temp;
        if(!this.filaComum.isEmpty() && !this.filaPrioritaria.isEmpty()) {
            if(this.ordenador <= 2) {
                this.ordenador++;
                this.filaPrioritaria.remove(0);
                temp = this.filaPrioritaria.get(0);
            } else {
                this.ordenador = 0;
                this.filaComum.remove(0);
                temp = this.filaComum.get(0);
            }
        } else if (!this.filaComum.isEmpty() && this.filaPrioritaria.isEmpty()) {
            this.filaComum.remove(0);
            temp = this.filaComum.get(0);
        } else {
            this.filaPrioritaria.remove(0);
            temp = this.filaPrioritaria.get(0);
           
        }    
             return temp;
    
    }

    public String showQueues() {
       int a = 0, b = 0;
       StringBuilder sb = new StringBuilder();
       sb.append("Idoso:");
       if(this.filaPrioritaria.isEmpty()){
           sb.append("Vazia");
       } else {
           for(Client client: this.filaPrioritaria){
               if(a++ == this.filaPrioritaria.size() - 1){
                   sb.append(client.getName());
               } else {
                     sb.append(client.getName() + "-");			
           }
       }
     }
       sb.append(";");
       sb.append("Normal:");
       if(this.filaComum.isEmpty()){
           sb.append("Vazia");
       } else {
           for(Client client: this.filaComum) {
               if(b++ == this.filaComum.size() - 1) {
                   sb.append(client.getName());
               } else {
                   sb.append(client.getName() + "-");
               }
           }
       } 
         return sb.toString();
    }  
    
    public int numClients() {
        return this.filaComum.size() + this.filaPrioritaria.size();
    }

    public int numElderlyClients() {
        return this.filaPrioritaria.size();
    }
}
