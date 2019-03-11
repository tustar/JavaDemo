package com.tustar.crazy.chapter16;

import java.util.Random;

/**
 * Created by tustar on 6/10/16.
 */
class ParkingLot {

    private int no;
    private String carOwner;

    public ParkingLot(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(String carOwner) {
        this.carOwner = carOwner;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "no=" + no +
                ", carOwner='" + carOwner + '\'' +
                '}';
    }
}

class Garage {
    private ParkingLot[] parkingLots = new ParkingLot[10];

    public Garage() {
        for (int i = 0; i < parkingLots.length; i++) {
            parkingLots[i] = new ParkingLot(i + 1);
        }
    }

    public synchronized void in(String carOwner) {
        boolean hasParkingLot = false;
        for (ParkingLot lot : parkingLots) {
            if (lot.getCarOwner() == null) {
                System.out.println("车位" + lot.getNo() + "=>     可以停车.");
                hasParkingLot = true;
            }
        }

        if (!hasParkingLot) {
            System.out.println("车位已满!!!");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (ParkingLot lot : parkingLots) {
            if (lot.getCarOwner() == null) {
                lot.setCarOwner(carOwner);
                System.out.println("车位" + lot.getNo() + "已被" + carOwner + "占用.");
                notifyAll();
                break;
            }
        }
    }

    public synchronized void out(String carOwner) {
        ParkingLot mine = null;
        for (ParkingLot lot : parkingLots) {
            String tmp = lot.getCarOwner();
            if (tmp != null && tmp.equals(carOwner)) {
                System.out.println("车位" + lot.getNo() + "停着" + carOwner + "的车.");
                mine = lot;
                break;
            }
        }

        if (mine != null) {
            System.out.println(carOwner + "的车准备离开车位" + mine.getNo());
            mine.setCarOwner(null);
            System.out.println(carOwner + "的车离开车, " + "车位" + mine.getNo() + "可以停车.");
            notifyAll();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

public class Exercise02 {
    public static void main(String[] args) {
        Garage garage = new Garage();
        new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                try {
                    Thread.sleep(new Random().nextInt(300));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                garage.in(String.valueOf(i));
            }
        }).start();
        new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                try {
                    Thread.sleep(new Random().nextInt(300));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                garage.out(String.valueOf(i));
            }
        }).start();
    }
}
