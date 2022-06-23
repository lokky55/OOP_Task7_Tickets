package ru.netology;

import java.util.Comparator;

public class TicketByTimeAscComparator implements Comparator<Ticket> {  // ASC сортирует от низких значений к высоким

    public int compare(Ticket ticket1, Ticket ticket2) {
        return ticket1.getTime() - ticket2.getTime();
    }
}
