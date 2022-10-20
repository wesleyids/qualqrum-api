package br.com.qualqrum.api.cahce;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import br.com.qualqrum.api.model.User;

public class UserCache {
    
    // public static List<User> users = new ArrayList<>();

    // public static void addUser(User user) {
    //     users.add(user);
    // }

    private static final int CLEAN_UP_PERIOD_IN_SEC = 60;

    private final ConcurrentHashMap<String, SoftReference<User>> cache = new ConcurrentHashMap<>();

    public UserCache() {
        Thread cleanerThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(CLEAN_UP_PERIOD_IN_SEC * 1000);
                    cache.entrySet().removeIf(entry -> Optional.ofNullable(entry.getValue()).map(SoftReference::get).map(User::isExpired).orElse(false));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        cleanerThread.setDaemon(true);
        cleanerThread.start();
    }
 
    public void add(String key, User value, long periodInMillis) {
        if (key == null) {
            return;
        }
        if (value == null) {
            cache.remove(key);
        } else {
            long expiryTime = System.currentTimeMillis() + periodInMillis;
            // value.addExpiryTime(expiryTime);
            cache.put(key, new SoftReference<>(value));
        }
    }
 
    public void remove(String key) {
        cache.remove(key);
    }
 
    public Object get(String key) {
        return Optional.ofNullable(cache.get(key)).map(SoftReference::get).filter(cacheObject -> !cacheObject.isExpired()).map(CacheObject::getValue).orElse(null);
    }
 
    public void clear() {
        cache.clear();
    }
}
