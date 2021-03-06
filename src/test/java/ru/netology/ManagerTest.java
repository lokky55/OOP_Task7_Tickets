package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagerTest {
    private Repository repo = new Repository();
    private Manager manager = new Manager(repo);

    private Ticket ticket1 = new Ticket(1, 2500, "DME", "NBC", 120);
    private Ticket ticket2 = new Ticket(2, 1700, "VKO", "KLG", 50);
    private Ticket ticket3 = new Ticket(3, 7000, "SVO", "SEN", 300);
    private Ticket ticket4 = new Ticket(4, 1500, "VKO", "KLG", 45);
    private Ticket ticket5 = new Ticket(5, 2300, "NBC", "VKO", 140);
    private Ticket ticket6 = new Ticket(6, 8000, "SEN", "DME", 260);

    @BeforeEach
    public void setUp() {
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
    }

    @Test
    public void shouldAdd() {
        repo.add(ticket6);
        Ticket[] actual = repo.findAll();
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repo.removeById(1);
        repo.removeById(2);
        Ticket[] actual = repo.findAll();
        Ticket[] expected = {ticket3, ticket4, ticket5};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByFromAndTo() {
        Ticket[] actual = manager.findAllByFromTo("SVO", "SEN");
        Ticket[] expected = {ticket3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNoAnyIfFirstIncorrect() {
        Ticket[] actual = manager.findAllByFromTo("O", "KLG");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNoAnyIfSecondIncorrect () {
        Ticket[] actual = manager.findAllByFromTo("SVO","G");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTwoAndSortByCost() {
        Ticket[] actual = manager.findAllByFromTo("VKO", "KLG");
        Ticket[] expected = {ticket4, ticket2};
        Assertions.assertArrayEquals(expected, actual);
    }
}
