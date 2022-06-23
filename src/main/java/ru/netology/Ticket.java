package ru.netology;

import java.util.Objects;

public class Ticket implements Comparable<Ticket> {

    private int id;
    private int cost;
    private String from;
    private String to;
    private int time;   // in minutes

    public Ticket(int id, int cost, String from, String to, int time) {
        this.id = id;
        this.cost = cost;
        this.from = from;
        this.to = to;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public int compareTo(Ticket otherTicket) {
        if (cost < otherTicket.cost) {
            return -1;
        }
        if (cost > otherTicket.cost) {
            return +1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && cost == ticket.cost && time == ticket.time && Objects.equals(from, ticket.from) && Objects.equals(to, ticket.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cost, from, to, time);
    }
}
