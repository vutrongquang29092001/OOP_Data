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
public class GianHangTCController {
        GianHangTCDAO gianHangTCDAO = new GianHangTCDAO();
   public ArrayList<GianHang> get(){
       return gianHangTCDAO.get();
   }
   public Boolean add(GianHang gianHang){
       return gianHangTCDAO.add(gianHang);
   }
   public Boolean delete(String id){
       return gianHangTCDAO.delete(id);
   }
   public GianHang search(String id){
       return gianHangTCDAO.search(id);
   }
   public Boolean update(GianHang gianHang){
       return gianHangTCDAO.update(gianHang);
   }
   public double chiPhiThueGianHang(String id , Date a, Date b){
       return gianHangTCDAO.chiPhiThueGianHang(id, a, b);
   }
   public double chiPhiThueGianHang(String id, int soNgay){
       return gianHangTCDAO.chiPhiThueGianHang(id, soNgay);
   }
   public double doanhThu(Date a, Date b){
       return gianHangTCDAO.doanhThu(a, b);
   }
   public double doanhThu(int soNagy){
       return gianHangTCDAO.doanhThu(soNagy);
   }
}
