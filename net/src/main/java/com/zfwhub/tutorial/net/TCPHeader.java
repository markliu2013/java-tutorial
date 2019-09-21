package com.zfwhub.tutorial.net;

/**
 * TCP协议头结构
 * http://www.blogjava.net/ljf-tianyi/archive/2009/09/18/295534.html
 * https://blog.csdn.net/chenlycly/article/details/74103788
 * https://blog.csdn.net/wdscq1234/article/details/52423272
 */
public class TCPHeader {

    private int sourcePort; //源端口号 16bit
    private int destPort; //目的端口号 16bit
    private int seqNum; // 传输数据过程中，为每一个封包分配一个序号，保证网络传输数据的顺序性 32bit
    private int ackNum; // Acknowledgment Number, 用来确认确实有收到相关封包，内容表示期望收到下一个报文的序列号，用来解决丢包的问题 32bit
    private int headerLength; // 4位头部长度  + 6位保留字中的4位
    // 1.URG 2.ACK 3.PSH 4.RST 5.SYN 6.FIN
    private int flag; // 这部分主要标志数据包的属性，比如SYN，RST，FIN等，操控TCP的状态机
    private int window; // 滑动窗口，主要用于解决流控拥塞的问题
    private int checkSum; // 检验和 16bit
    private int urgentPointer; //紧急指针，可以告知紧急的数据位置，需要和Flag的U flag 配合使用

    public TCPHeader() {
    }

    public TCPHeader(int sourcePort, int destPort, int seqNum, int ackNum, int headerLength, int flag, int window, int checkSum, int urgentPointer) {
        this.sourcePort = sourcePort;
        this.destPort = destPort;
        this.seqNum = seqNum;
        this.ackNum = ackNum;
        this.headerLength = headerLength;
        this.flag = flag;
        this.window = window;
        this.checkSum = checkSum;
        this.urgentPointer = urgentPointer;
    }

    public int getSourcePort() {
        return sourcePort;
    }

    public void setSourcePort(int sourcePort) {
        this.sourcePort = sourcePort;
    }

    public int getDestPort() {
        return destPort;
    }

    public void setDestPort(int destPort) {
        this.destPort = destPort;
    }

    public int getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(int seqNum) {
        this.seqNum = seqNum;
    }

    public int getAckNum() {
        return ackNum;
    }

    public void setAckNum(int ackNum) {
        this.ackNum = ackNum;
    }

    public int getHeaderLength() {
        return headerLength;
    }

    public void setHeaderLength(int headerLength) {
        this.headerLength = headerLength;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getWindow() {
        return window;
    }

    public void setWindow(int window) {
        this.window = window;
    }

    public int getCheckSum() {
        return checkSum;
    }

    public void setCheckSum(int checkSum) {
        this.checkSum = checkSum;
    }

    public int getUrgentPointer() {
        return urgentPointer;
    }

    public void setUrgentPointer(int urgentPointer) {
        this.urgentPointer = urgentPointer;
    }

}