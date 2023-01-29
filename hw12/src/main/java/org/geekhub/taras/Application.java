package org.geekhub.taras;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.geekhub.taras.object.Cat;
import org.geekhub.taras.object.User;
import org.geekhub.taras.storage.Storage;
import org.geekhub.taras.storage.db.DatabaseStorage;

import javax.sql.DataSource;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {
        Environment env = new Environment("application.properties");

        DataSource dataSource = createDataSource(env);

        Storage storage = new DatabaseStorage(dataSource);

        List<Cat> cats = storage.list(Cat.class);

        for (Cat cat : cats) {
            storage.delete(cat);
        }

        cats = storage.list(Cat.class);
        if (!cats.isEmpty()) throw new Exception("Cats should not be in database!");

        for (int i = 1; i <= 20; i++) {
            Cat cat = new Cat();
            cat.setName("cat" + i);
            cat.setAge(i);
            storage.save(cat);
        }

        cats = storage.list(Cat.class);
        if (cats.size() != 20) throw new Exception("Number of cats in storage should be 20!");

        User user = new User();
        user.setAdmin(true);
        user.setAge(23);
        user.setName("Victor");
        user.setBalance(22.23);
        storage.save(user);

        User user1 = storage.get(User.class, user.getId());
        if (!user1.getName().equals(user.getName())) throw new Exception("Users should be equals!");

        user.setAdmin(false);
        storage.save(user);

        User user2 = storage.get(User.class, user.getId());
        if (!user.getAdmin().equals(user2.getAdmin())) throw new Exception("Users should be updated!");

        storage.delete(user1);

        User user3 = storage.get(User.class, user.getId());

        if (user3 != null) throw new Exception("User should be deleted!");
    }

    private static DataSource createDataSource(Environment env) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(env.getProperty("db.url"));
        config.setUsername(env.getProperty("db.username"));
        config.setPassword(env.getProperty("db.password"));

        HikariDataSource ds;
        try {
            ds = new HikariDataSource(config);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ds;
        /*
        Must create a hikari cp datasource. Use Environment to get jdbc properties
         */
        //return null;
    }
}
