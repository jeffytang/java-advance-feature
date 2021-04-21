package com.twq.multithread;

/**
 *  退票的窗口
 */
public class RefundTicketWindow implements Runnable {
    // 所属的火车站
    private RailwayStation railwayStation;

    public RefundTicketWindow(RailwayStation railwayStation) {
        this.railwayStation = railwayStation;
    }

    @Override
    public void run() {
        // 退票：将票号退还给火车站
        railwayStation.addTicket();
    }
}
