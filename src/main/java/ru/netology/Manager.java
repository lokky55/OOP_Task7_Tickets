package ru.netology;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.Comparator;

public class Manager {
    private Repository repo;
    private Ticket[] tickets = new Ticket[0];

    public Manager(Repository repo) {
        this.repo = repo;
    }

    public Ticket[] findAllByCost(String from, String to) {
        Ticket[] ans = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (ticket.getFrom() == from && ticket.getTo() == to) {
                Ticket[] tmp = new Ticket[ans.length + 1];
                for (int i = 0; i < ans.length; i++) {
                    tmp[i] = ans[i];
                }
                tmp[tmp.length - 1] = ticket;
                ans = tmp;
            }
        }
        Arrays.sort(ans);  // sort by cost
        return ans;
    }

    public Ticket[] findAllByTime(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] ans = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (ticket.getFrom() == from && ticket.getTo() == to) {
                Ticket[] tmp = new Ticket[ans.length + 1];
                for (int i = 0; i < ans.length; i++) {
                    tmp[i] = ans[i];
                }
                tmp[tmp.length - 1] = ticket;
                ans = tmp;
            }
        }
        Arrays.sort(ans, comparator);  // sort by time
        return ans;
    }

}
