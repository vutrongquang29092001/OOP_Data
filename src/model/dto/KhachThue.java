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
public class KhachThue {      // class tên KhachThue phạm vi truy cập public 

    private String name;       // thuộc tính name kiểu dữ liệu string phạm vi truy cập private 
    private String address;    // thuộc tính address liểu dữ liệu String phạm vi truy cập private 
    private Date startTime;    // thuộc tính startTime kiệu dữ liệu Date phạm vi truy cập private 
    private Date endsTime;     // thuộc tính endTime kiểu dữ liệu trả Date phạm vi truy cập private 
    private String maGianHang; // thuộc tính maGianHang kiểu dữ kiệu String phạm vi truy cập private
    private int tienCoc;       // thuộc tính tienCoc kiểu dữ liệu int phạm vi truy cập private 

    // method Constructor không truyền tham số 
    public KhachThue() {
    }
    // method Constructor truyền tham số
    public KhachThue(String name, String address, Date startTime, Date endsTime, String maGianHang, int tienCoc) {
        this.name = name;
        this.address = address;
        this.startTime = startTime;
        this.endsTime = endsTime;
        this.maGianHang = maGianHang;
        this.tienCoc = tienCoc;
    }
    // method lấy giá trị thuộc tính name , kiểu dữ liệu trả về String 
    public String getName() {
        return name;
    }
    // method sửa giá trị thuộc tính name , tham số truyền vào có kiểu dữ liệu String 
    public void setName(String name) {
        this.name = name;
    }
    // method lấy giá trị thuộc tính address , kiểu dữ liệu trả về String 
    public String getAddress() {
        return address;
    }
    // method sửa giá trị thuộc tính address , tham số truyền vào có kiểu dữ liệu String 
    public void setAddress(String address) {
        this.address = address;
    }
    // method lấy giá trị thuộc tính startTime , kiểu dữ kiệu trả về Date 
    public Date getStartTime() {
        return startTime;
    }
    // method sửa giá trị thuộc tính startTime, tham số truyền vào có kiểu dữ liệu Date 
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    // method lấy giá trị thuộc tính ennsTime kiểu dữ liệu trả về  Date
    public Date getEndsTime() {
        return endsTime;
    }
    // method sửa giá trị thuộc tính endsTime, kiểu dữ liệu tham số truyền vào Date 
    public void setEndsTime(Date endsTime) {
        this.endsTime = endsTime;
    }
    // method lấy giá trị thuộc tính maGianHang kiểu dữ liệu trả về String 
    public String getMaGianHang() {
        return maGianHang;
    }
    // method sửa giá trị thuộc tính maGianHang , tham số truyền vào có kiểu dữ liệu String 
    public void setMaGianHang(String maGianHang) {
        this.maGianHang = maGianHang;
    }
    // method lấy giá trj thuộc tính tienCoc , kiểu dữ liệu trả về int 
    public int getTienCoc() {
        return tienCoc;
    }
    // method sửa giá trị thuộc tính, tham số truyền vào có kiểu dữ liệu int 
    public void setTienCoc(int tienCoc) {
        this.tienCoc = tienCoc;
    }
    // method lấy thông tin đối tượng, kiểu dữ liệu trả về String 
    @Override
    public String toString() {
        return "KhachThue{" + "maGianHang=" + maGianHang + ", name=" + name + ", address=" + address + ", startTime=" + startTime + ", endsTime=" + endsTime + ", tienCoc=" + tienCoc + '}';
    }

}
