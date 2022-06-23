package ru.netology;

import java.security.PublicKey;
import java.util.Arrays;

public class Manager {
    private Repository repo;
    private Ticket[] tickets = new Ticket[0];

    public Manager(Repository repo) {
        this.repo = repo;
    }

    public Ticket[] findAllByFromTo(String from, String to) {
        Ticket[] ans = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (ticket.getFrom() == from && ticket.getTo() == to) {
                Ticket[] tmp = new Ticket[ans.length + 1];
                for (int i = 0; i < tickets.length; i++) {
                    tmp[i] = ans[i];
                }
                tmp[tmp.length - 1] = ticket;
                ans = tmp;
            }
        }
        Arrays.sort(ans);
        return ans;
    }
}
