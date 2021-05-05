/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.Date;
import model.dto.GianHang;
import model.dto.GianHangCC;

/**
 *
 * @author vutrongquang29092001
 */
public class GianHangCCDAO implements GianHangInterface {

    ArrayList<GianHang> list = List.listGhCC();

    @Override
    public ArrayList<GianHang> get() {

        return this.list;
    }

    @Override
    public Boolean add(GianHang gianHang) {
        if(search(gianHang.getMaGianHang()) == null){
            this.list.add(gianHang);
            return true;
        }else{
            return false;
        }
      

    }

    @Override
    public Boolean delete(String id) {
       if(search(id) == null){
            return false;
        }else{
            list.remove(search(id));
            return true;
        }
    }

    @Override
    public GianHang search(String id) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaGianHang().equals(id) == true) {
                return list.get(i);
            }
        }
        return null;
    }

    @Override
    public Boolean update(GianHang gianHang) {
        Boolean b = false;
        GianHangCC gianHangCC = (GianHangCC) gianHang;
        for (int i = 0; i < list.size(); i++) {
            GianHangCC ghcc = (GianHangCC) list.get(i);
            if (ghcc.getMaGianHang().equals(gianHangCC.getMaGianHang()) == true) {

                ghcc.setDienTich(gianHangCC.getDienTich());
                ghcc.setViTri(gianHangCC.getViTri());
                ghcc.setSoLuongBanGhe(gianHangCC.getSoLuongBanGhe());
                ghcc.setSoLuongQuatLamMat(gianHangCC.getSoLuongQuatLamMat());
                b = true;

            }

        }
        return b;
    }

    @Override
    public double chiPhiThueGianHang(String id, Date a, Date b) {
        GianHangCC gh = (GianHangCC) search(id);
        long noDay = (a.getTime() - b.getTime()) / (24 * 3600 * 1000);
        double sum = (gh.getDienTich() * 120000 + gh.getSoLuongQuatLamMat() * 50000) * noDay;
        return sum;
    }

    @Override
    public double chiPhiThueGianHang(String id, int soNgay) {
        GianHangCC gh = (GianHangCC) search(id);
        double sum = (gh.getDienTich() * 120000 + gh.getSoLuongQuatLamMat() * 50000) * soNgay;
        return sum;
    }

    @Override
    public double doanhThu(Date a, Date b) {
        double sum = 0;
        long noDay = (a.getTime() - b.getTime()) / (24 * 3600 * 1000);
        for (GianHang gh : list) {
            GianHangCC temp = (GianHangCC) gh;
            sum += (temp.getDienTich() * 120000 + temp.getSoLuongQuatLamMat() * 50000) * noDay;
        }
        return sum;
    }

    @Override
    public double doanhThu(int soNagy) {
         double sum = 0;
        
        for (GianHang gh : list) {
            GianHangCC temp = (GianHangCC) gh;
            sum += (temp.getDienTich() * 120000 + temp.getSoLuongQuatLamMat() * 50000) * soNagy;
        }
        return sum;
    }

}
