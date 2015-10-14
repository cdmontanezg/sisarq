package com.sisarq;

import java.util.Random;

/**
 * Created by andre on 14/10/2015.
 */
public class ThreadSender implements Runnable {
    public static final String BASE_URL = "localhost:8080/sisarq/rest/receptor/";

    @Override
    public void run() {
        Random rnd = new Random();
        try {
            Main.sendGet(BASE_URL + rnd.nextInt(1000)+"/"+rnd.nextInt(500)+"/"+rnd.nextInt(400));
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
