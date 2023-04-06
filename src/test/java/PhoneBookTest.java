import org.example.PhoneBook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class PhoneBookTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void addOneContact(){
        PhoneBook phoneBook = new PhoneBook();

        int actual = phoneBook.add("Alex", "139024932");
        int expect = 1;

        Assertions.assertEquals(expect, actual);
    }

    @Test
    void addSameContacts(){
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alex", "12345");

        int actual = phoneBook.add("Alex", "79563");
        int expect = 1;

        Assertions.assertEquals(expect, actual);
    }

    @Test
    void addALotContacts(){
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Ilya", "90234");
        phoneBook.add("Sasha", "30924");
        phoneBook.add("Dariya", "0293482");
        phoneBook.add("Arseniy", "123283");
        phoneBook.add("Mariya", "942482");
        phoneBook.add("Mariya", "432524");

        int actual = phoneBook.add("Vadim", "354924");
        int expect = 6;

        Assertions.assertEquals(expect, actual);
    }

    @Test
    void findByExistNumber(){
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alex", "31235");
        phoneBook.add("Dada", "234");

        String actual = phoneBook.findByNumber("31235");
        String expect = "Alex";

        Assertions.assertEquals(expect, actual);
    }

    @Test
    void findByNumberDublicate(){
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alex", "154312");
        phoneBook.add("Alex", "22343");

        String actual = phoneBook.findByNumber("154312");
        String expect = "Alex";

        Assertions.assertEquals(expect, actual);
    }

    @Test
    void findByNameDublicate(){
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alex", "1234");
        phoneBook.add("Alex", "4321");

        String actual = phoneBook.findByName("Alex");
        String expect = "1234";

        Assertions.assertEquals(expect, actual);
    }

    @Test
    void findByNameExist(){
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Higo", "2314");

        String actual = phoneBook.findByName("Higo");
        String expect = "2314";

        Assertions.assertEquals(expect, actual);
    }

    @Test
    void printAllNamesSorted(){
        setUpStreams();

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Ilya", "90234");
        phoneBook.add("Sasha", "30924");
        phoneBook.add("Dariya", "0293482");
        phoneBook.add("Arseniy", "123283");
        phoneBook.add("Mariya", "942482");

        phoneBook.printAllNames();

        String[] actual = outContent.toString().split("\r\n");
        String[] expected = {"Arseniy", "Dariya", "Ilya", "Mariya", "Sasha"};

        Assertions.assertEquals(expected.length, actual.length);
        for(int i = 0; i < actual.length; i++){
            Assertions.assertEquals(expected[i], actual[i]);
        }

        restoreStreams();
    }
}
