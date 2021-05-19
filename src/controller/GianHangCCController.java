/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Date;
import model.dao.GianHangCCDAO;
import model.dto.GianHang;

/**
 *
 * @author vutrongquang29092001
 */
// class tên GianHangCCController phạm vi truy cập public 
public class GianHangCCController {
   private  GianHangCCDAO gianHangCCDAO = new GianHangCCDAO();
   //method lấy danh sách gian hàng 
   public ArrayList<GianHang> get(){
       return gianHangCCDAO.get();
   }
   //method thêm gian hàng 
   public Boolean add(GianHang gianHang){
       return gianHangCCDAO.add(gianHang);
   }
   // method xóa gian hàng 
   public Boolean delete(String id){
       return gianHangCCDAO.delete(id);
   }
   //method tìm kiếm gian hàng 
   public GianHang search(String id){
       return gianHangCCDAO.search(id);
   }
   // methoc chỉnh sửa thông tin gian hàng 
   public Boolean update(GianHang gianHang){
       return gianHangCCDAO.update(gianHang);
   }
   // method tính chi thuê gian hàng 
   public double chiPhiThueGianHang(String id , Date a, Date b){
       return gianHangCCDAO.chiPhiThueGianHang(id, a, b);
   }
   public double chiPhiThueGianHang(String id, int soNgay){
       return gianHangCCDAO.chiPhiThueGianHang(id, soNgay);
   }
   // method tính doanh thu gian hàng 
   public double doanhThu(Date a, Date b){
       return gianHangCCDAO.doanhThu(a, b);
   }
   public double doanhThu(int soNagy){
       return gianHangCCDAO.doanhThu(soNagy);
   }
}

