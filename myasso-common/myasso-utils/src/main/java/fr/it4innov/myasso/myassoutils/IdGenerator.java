package fr.it4innov.myasso.myassoutils;

import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class IdGenerator {

    public static String generateId(String entityName){
        int min = 50; // Minimum value of range
        int max = 1000000; // Maximum value of range
        int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        AtomicLong uuid = new AtomicLong(timestamp.getTime());
        String myGeneratedId = new StringBuilder()
                .append(entityName.toUpperCase(Locale.getDefault()))
                .append("_")
                .append(random_int)
                .append(uuid).toString();
        log.info("myGeneratedId: {}", myGeneratedId);
        return myGeneratedId;
    }
}
