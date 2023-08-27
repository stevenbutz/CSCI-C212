package problem2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void mailCheck() {
        Account account = new Account("Jon","1 Lane",23,1);
        account.mailCheck();
//        Account account1 = new Account(null,"1 Lane",23,1);
//        account1.mailCheck();
        assertThrows(IllegalArgumentException.class, () -> account.setNumber(-1));
        assertThrows(IllegalArgumentException.class, () -> account.setName(null));
        assertThrows(IllegalArgumentException.class, () -> account.setAddress(null));
        assertThrows(IllegalArgumentException.class, () -> account.setAccountNumber(-1));
        assertThrows(IllegalArgumentException.class, () -> new Account(null, null,-1,-1));
    }
}