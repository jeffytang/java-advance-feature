package com.twq.multithread;

/**
 *  售票窗口
 *  每一个售票窗口都是一个线程
 */
public class TicketWindow implements Runnable {
    // 所属的火车站
    private RailwayStation railwayStation;

    public TicketWindow(RailwayStation railwayStation) {
        this.railwayStation = railwayStation;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " 正在买票");
        // 售票，拿到票号
        int ticketNum = railwayStation.getTicket();
        if (ticketNum == RailwayStation.NO_TICKET_FLAG) {
            System.out.println(name + " 没有买到票");
        } else {
            System.out.println(name + "买到的票号是：" + ticketNum);
        }
    }

}
