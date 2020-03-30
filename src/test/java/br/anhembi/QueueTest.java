package br.anhembi;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class QueueTest {

    private static final int _queueSize = 3;
    private Queue queue;

    @Before
    public void setup() {
        queue = new Queue(_queueSize);
    }

    @Test
    public void testEmptyStack() {
        boolean vazia = queue.isEmpty();

        assertTrue("Nova fila deve iniciar vazia", vazia);
    }

    @Test
    public void testEnqueue() {
        queue.enqueue(1);
        boolean vazia = queue.isEmpty();

        assertFalse("Fila após inserção não deve estar vazia", vazia);
    }

    @Test
    public void testPeek() {
        queue.enqueue(1);
        queue.enqueue(2);

        int resp = queue.peek();

        assertEquals("O valor no inicio da fila após 2 iserções deve ser 1", 1, resp);
    }

    @Test
    public void testQueueSize() {
        queue.enqueue(1);
        queue.enqueue(2);

        int resp = queue.size();

        assertEquals("Após 2 iserções o tamanho da fila deve ser 2", 2, resp);
    }

    @Test
    public void testIsFull() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        boolean full = queue.isFull();

        assertTrue("A fila com tamanho 3 deve estar cheia após 3 inserções", full);
    }

    @Test
    public void testDequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        
        int value1 = queue.dequeue();
        int value2 = queue.dequeue();
        
        assertEquals("Remover o primeiro elemento deve ser 1", 1, value1);
        assertEquals("Remover o segundo elemento deve ser 2", 2, value2);
        
        boolean vazia = queue.isEmpty();
        assertTrue("Fila deve fica vazia após todas as remoções", vazia);
    }
    
    @Test
    public void testIsertAfterIsFull() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
    
        boolean full = queue.isFull();
        assertTrue("A fila com tamanho 3 deve estar cheia após 3 inserções", full);
    
        int resp = queue.size();
        assertEquals("Não deve permitir inserir além da capacidade", 3, resp);
    }

    @Test
    public void testRemoveBeforeInsert() {
        int value = queue.dequeue();

        boolean empty = queue.isEmpty();
        assertTrue("A fila permanece vazia após dequeue sem elementos", empty);
    
        int size = queue.size();
        assertEquals("A quantidade de elementos não deve ser alterada se está vazia", 0, size);
    }

    @Test
    public void testEnqueueDequeueManyTimes() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        
        queue.dequeue();
        queue.dequeue();

        queue.enqueue(4);

        queue.dequeue();
        
        int first = queue.peek();
        int size = queue.size();

        assertEquals("O primeiro elemento deve ser 4", 4, first);
        assertEquals("O tamanho da fila deve ser 1", 1, size);
        
    }

    @Test
    public void testShow() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        
        String out = queue.show();

        assertEquals("Deve exibir 1-2-3-", "1-2-3-", out);
    }

}
