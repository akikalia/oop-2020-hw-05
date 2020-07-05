package manager;

import java.util.HashMap;
import java.util.Map;

public class AccountManager {
    private Map<String, String> db;

    public AccountManager(){
        db = new HashMap<>();
        db.put("Patrick", "1234");
        db.put("Molly", "FloPup");
    }

    public boolean accountExists(String username){
        return db.containsKey(username);
    }
    public synchronized void addAccount(String username, String password){
        if (!accountExists(username))
            db.put(username, password);
    }
    public boolean accountCorrect(String username, String password){
        return db.get(username).equals(password);
    }


}
