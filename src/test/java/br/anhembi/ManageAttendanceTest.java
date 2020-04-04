package br.anhembi;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * ManageAttendanceTest
 */

public class ManageAttendanceTest {

    private static final int _managerQueueSize = 3;
    private ManageAttendance manager;
    private Client cli1Normal;
    private Client cli2Idoso;
    private Client cli3Normal;
    private final int idadeCliente1 = 25;
    private final int idadeCliente2 = 65;
    private final int idadeCliente3 = 35;
    private final String nomeCliente1 = "Cliente1";
    private final String nomeCliente2 = "Cliente2";
    private final String nomeCliente3 = "Cliente3";

    @Before
    public void setup() {
        manager = new ManageAttendance(_managerQueueSize);
        cli1Normal = new Client(nomeCliente1, idadeCliente1);
        cli2Idoso = new Client(nomeCliente2, idadeCliente2);
        cli3Normal = new Client(nomeCliente3, idadeCliente3);
    }

    @Test
    public void testEmptyQueueOnManager() {
        boolean vazia = manager.isEmpty();

        assertTrue("Não há clientes para atender no início", vazia);
    }

    @Test
    public void testEnqueueClient() {
        manager.addClient(cli1Normal);
        boolean vazia = manager.isEmpty();

        assertFalse("Fila chegada de cliente não deve estar vazia", vazia);
    }

    @Test
    public void testDequeueClient() {
        manager.addClient(cli1Normal);

        Client cli = manager.showNext();
        boolean vazia = manager.isEmpty();

        assertFalse("methodo show não deve remover da fila", vazia);
        assertEquals("Cliente que chegou deve ser o cliente 1", cli, cli1Normal);
    }

    @Test
    public void testNextClient() {
        manager.addClient(cli1Normal);

        Client cli = manager.getNext();

        assertEquals("Cliente que chegou deve ser o cliente 1", cli, cli1Normal);
    }

    @Test
    public void testNextElderlyClient() {
        manager.addClient(cli1Normal);
        manager.addClient(cli2Idoso);
        manager.addClient(cli3Normal);

        Client cli = manager.getNext();

        assertEquals("Próximo cliente a ser atendido deve ser idoso", cli, cli2Idoso);
    }

    @Test
    public void testNumClients() {
        manager.addClient(cli1Normal);
        manager.addClient(cli2Idoso);
        manager.addClient(cli3Normal);

        int numClientes = manager.numClients();
        int numElderlyClientes = manager.numElderlyClients();

        assertEquals("Número de clientes aguardando atendimento", 3, numClientes);
        assertEquals("Número de clientes Idosos aguardando atendimento", 1, numElderlyClientes);
    }

    @Test
    public void testShowEmptyElderlyClients() {
        manager.addClient(cli1Normal);
        manager.addClient(cli3Normal);

        String saidaEsperada = "idoso:vazia;normal:cliente1-cliente3";
        String fila = manager.showQueues();

        assertEquals("Filas de clientes sem idodo aguradando", saidaEsperada, fila);
    }

    @Test
    public void testShowClients() {
        manager.addClient(cli1Normal);
        manager.addClient(cli2Idoso);
        manager.addClient(cli3Normal);

        String saidaEsperada = "idoso:cliente2;normal:cliente1-cliente3";
        String fila = manager.showQueues();

        assertEquals("Filas de clientes aguradando", saidaEsperada, fila);
    }

}
