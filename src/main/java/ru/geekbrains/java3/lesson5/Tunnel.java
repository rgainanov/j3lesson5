package ru.geekbrains.java3.lesson5;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private static Semaphore semaphore;

    public Tunnel(int length, int numberOfCarsPermitted) {
        this.length = length;
        this.description = "Тоннель " + this.length + " метров";
        semaphore = new Semaphore(numberOfCarsPermitted);
    }
    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                semaphore.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                semaphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

