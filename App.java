package br.anhembi;

import java.util.Scanner;

public class App {
    
    public static ManageAttendance manage = new ManageAttendance(10);

    public static Scanner scanner = new Scanner (System.in);

    public static void main(final String[] args) throws Exception {
        int op = 0;

        do{
            System.out.println(".......... S e j a  B e m  -  V i n d o .......... ");
            System.out.println("Escolha uma das opções abaixo:");
            System.out.println("1 - Chegada do cliente na agencia");
            System.out.println("2 - Verificar quem é o próximo a ser atendido");
            System.out.println("3 - Atender um cliente");
            System.out.println("4 - Exibir filas");
            System.out.println("5 - Finalizar o programa\n ");

            try{
                op = scanner.nextInt();
            } catch (Exception e){
                System.out.println("Apenas os numeros acima.");
            }
        scanner.nextLine();
            switch (op) {
                case 1:
                    System.out.println("Chegada de um cliente!");
                    newClient();
                    break;
                
                case 2:
                    System.out.println("Proximo cliente:\n");
                    if(manage.showNext() != null){
                        System.out.println(manage.showNext());
                    } else {
                        System.out.println("Não ha um proximo cliente.");
                    }
                    break;
                
                case 3:
                    if(!manage.isEmpty()){
                        if(manage.showNext() != null){
                            System.out.println("Chamando o proximo cliente");
                            System.out.println(manage.getNext());
                            System.out.println("Cliente foi atendido. Chamando o próximo.");                
                        } else {
                            System.out.println("Não há ninguém na fila.");                           
                        }
                        break;
                    }
                
                case 4:
                    if(manage.showQueues() != null){
                        System.out.println(manage.showQueues());
                    } else {
                        System.out.println("Não há ninguem no momento.");
                    }
                    break;
                
                case 5:
                if(!manage.isEmpty()) {
                    System.out.println("Ainda ha cliente na fila, impossivel finalizar o programa.");
                } else {
                    System.out.println("Programa encerrado.");
                    op = 6;
                }
                    break;
                
                default: System.out.println("Opção invalida. Selecione os numeros mostrados na tela.");
                    break;
            }  
             
        } while (op != 6);  
    }

    public static void newClient() throws Exception {
        String name = "";
        int age = 0;

        try{
            System.out.println("Nome do cliente:");
            name = scanner.next();
            scanner.nextLine();
            System.out.println("Idade do cliente:");
            age = scanner.nextInt();            
        } catch(java.util.InputMismatchException e){
            System.out.println("Inserir apenas letras e numeros.");
        }
        
        Client client = new Client(name, age);
        manage.addClient(client);
    }
}
