package com.twq.multithread;

public class TestTicket {
    public static void main(String[] args) {
        // 创建一个火车站
        RailwayStation railwayStation = new RailwayStation("上海火车站");

        // 创建五个售票窗口
        TicketWindow window1 = new TicketWindow(railwayStation);
        TicketWindow window2 = new TicketWindow(railwayStation);
        TicketWindow window3 = new TicketWindow(railwayStation);
        TicketWindow window4 = new TicketWindow(railwayStation);
        TicketWindow window5 = new TicketWindow(railwayStation);

        // 模拟 8 个人来窗口买票
        new Thread(window1, "用户A").start();
        new Thread(window2, "用户B").start();
        new Thread(window2, "用户C").start();
        new Thread(window3, "用户D").start();
        new Thread(window4, "用户E").start();
        new Thread(window4, "用户F").start();
        new Thread(window5, "用户G").start();
        new Thread(window5, "用户H").start();
        new Thread(window5, "用户I").start();

        // 创建退票窗口
        RefundTicketWindow refundTicketWindow = new RefundTicketWindow(railwayStation);

        // 模拟两个用户退票
        new Thread(refundTicketWindow, "用于甲").start();
        new Thread(refundTicketWindow, "用于乙").start();
    }
}
