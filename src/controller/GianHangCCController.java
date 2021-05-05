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
public class GianHangCCController {
    GianHangCCDAO gianHangCCDAO = new GianHangCCDAO();
   public ArrayList<GianHang> get(){
       return gianHangCCDAO.get();
   }
   public Boolean add(GianHang gianHang){
       return gianHangCCDAO.add(gianHang);
   }
   public Boolean delete(String id){
       return gianHangCCDAO.delete(id);
   }
   public GianHang search(String id){
       return gianHangCCDAO.search(id);
   }
   public Boolean update(GianHang gianHang){
       return gianHangCCDAO.update(gianHang);
   }
   public double chiPhiThueGianHang(String id , Date a, Date b){
       return gianHangCCDAO.chiPhiThueGianHang(id, a, b);
   }
   public double chiPhiThueGianHang(String id, int soNgay){
       return gianHangCCDAO.chiPhiThueGianHang(id, soNgay);
   }
   public double doanhThu(Date a, Date b){
       return gianHangCCDAO.doanhThu(a, b);
   }
   public double doanhThu(int soNagy){
       return gianHangCCDAO.doanhThu(soNagy);
   }
}

