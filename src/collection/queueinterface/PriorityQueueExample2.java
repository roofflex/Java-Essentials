package collection.queueinterface;

import java.util.LinkedList;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample2 {
    public static void main(String[] args) {
        PriorityQueue<Ticket> tickets = new PriorityQueue<>();
        Ticket tk1 = new Ticket(2);
        Ticket tk2 = new Ticket(3);
        Ticket tk3 = new Ticket(1);
        Ticket tk4 = new Ticket(3);
        Ticket tk5 = new Ticket(3);
        Ticket tk6 = new Ticket(2);
        Ticket tk7 = new Ticket(1);

        tickets.add(tk1);
        tickets.add(tk2);
        tickets.add(tk3);
        tickets.add(tk4);
        tickets.add(tk5);
        tickets.add(tk6);
        tickets.add(tk7);

        System.out.println(Ticket.currentTicketNumber);

        System.out.println(tickets);

        System.out.println(tickets.poll());
        System.out.println(tickets.peek());



    }
}

class Ticket implements Comparable<Ticket>{
    int priority;
    static int currentTicketNumber = 1;
    int ticketNumber;

    public Ticket(int priority) {
        this.priority = priority;
        this.ticketNumber = currentTicketNumber;
        currentTicketNumber++;
    }

    @Override
    public int compareTo(Ticket o) {
        if (priority != o.priority){
            return priority - o.priority;
        }
        return ticketNumber - o.ticketNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return priority == ticket.priority &&
            ticketNumber == ticket.ticketNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(priority, ticketNumber);
    }

    @Override
    public String toString() {
        return "Ticket{" +
            "priority=" + priority +
            ", ticketNumber=" + ticketNumber +
            '}';
    }
}