package org.unlimint.scanners;

public class SuperScanner implements Runnable{
    static int  number=0;
    static Object lock=new Object();

    protected String fileName;

    public SuperScanner() { }
    public SuperScanner(String fileName) {
        this.fileName = fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public void run() {
    }
}
