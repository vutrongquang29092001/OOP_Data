/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.Date;
import model.dto.GianHang;

/**
 *
 * @author vutrongquang29092001
 */
//Interface tên GianHangInterface phạm vi truy cập public 
public interface GianHangInterface { 
    // method lấy danh sách gian hàng 
    public ArrayList<GianHang> get();
    // method tìm kiếm gian hàng 
    public GianHang search(String id);
    //method thêm gian hàng 
    public Boolean add(GianHang gianHang);
    // method chỉnh sửa thông tin gian hàng 
    public Boolean update(GianHang gianHang);
    // method xóa gian hàng 
    public Boolean delete(String id);
    // method tính chi phí thue gian hàng 
    public double chiPhiThueGianHang(String id, Date a, Date b);
    // method tính chi phí thuê gian hàng 
    public double chiPhiThueGianHang(String id, int soNgay);
    // method tính doanh thu cho thuê gian hàng 
    public double doanhThu(Date a, Date b);
    public double doanhThu(int soNagy);

}
