/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class KhachThue {
    private String name;
    private String address;
    private Date startTime;
    private Date endsTime;
    private String maGianHang;
    private int tienCoc;

    public KhachThue() {
    }

    public KhachThue(String name, String address, Date startTime, Date endsTime, String maGianHang, int tienCoc) {
        this.name = name;
        this.address = address;
        this.startTime = startTime;
        this.endsTime = endsTime;
        this.maGianHang = maGianHang;
        this.tienCoc = tienCoc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndsTime() {
        return endsTime;
    }

    public void setEndsTime(Date endsTime) {
        this.endsTime = endsTime;
    }

    public String getMaGianHang() {
        return maGianHang;
    }

    public void setMaGianHang(String maGianHang) {
        this.maGianHang = maGianHang;
    }

    public int getTienCoc() {
        return tienCoc;
    }

    public void setTienCoc(int tienCoc) {
        this.tienCoc = tienCoc;
    }
    
    @Override
    public String toString() {
        return "KhachThue{" + "maGianHang=" + maGianHang + ", name=" + name + ", address=" + address + ", startTime=" + startTime + ", endsTime=" + endsTime + ", tienCoc=" + tienCoc + '}';
    }

    
    
}
