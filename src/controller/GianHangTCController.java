/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Date;
import model.dao.GianHangTCDAO;
import model.dto.GianHang;

/**
 *
 * @author vutrongquang29092001
 */
// class tên GianHangTCController phạm vi truy cập public 
public class GianHangTCController {

    GianHangTCDAO gianHangTCDAO = new GianHangTCDAO();
    //method lấy danh sách gian hàng

    public ArrayList<GianHang> get() {
        return gianHangTCDAO.get();
    }
    // method thêm gian hàng 

    public Boolean add(GianHang gianHang) {
        return gianHangTCDAO.add(gianHang);
    }
    // method xóa gian hàng 

    public Boolean delete(String id) {
        return gianHangTCDAO.delete(id);
    }
    //method tìm kiếm gian hàng 

    public GianHang search(String id) {
        return gianHangTCDAO.search(id);
    }
    //method chỉnh sửa thông tin gian hàng

    public Boolean update(GianHang gianHang) {
        return gianHangTCDAO.update(gianHang);
    }
    //method tính chi phí thuê gian hàng 

    public double chiPhiThueGianHang(String id, Date a, Date b) {
        return gianHangTCDAO.chiPhiThueGianHang(id, a, b);
    }

    public double chiPhiThueGianHang(String id, int soNgay) {
        return gianHangTCDAO.chiPhiThueGianHang(id, soNgay);
    }
    //method tính doanh thu cho thuê gian hàng
    public double doanhThu(Date a, Date b) {
        return gianHangTCDAO.doanhThu(a, b);
    }

    public double doanhThu(int soNagy) {
        return gianHangTCDAO.doanhThu(soNagy);
    }
}
