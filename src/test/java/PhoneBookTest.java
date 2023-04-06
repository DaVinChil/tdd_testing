import org.example.PhoneBook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class PhoneBookTest {

    @Test
    void addOneContact(){
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
}
