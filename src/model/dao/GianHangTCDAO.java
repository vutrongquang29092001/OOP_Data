/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.Date;
import model.dto.GianHang;
import model.dto.GianHangTC;

/**
 *
 * @author vutrongquang29092001
 */
public class GianHangTCDAO implements GianHangInterface {

    ArrayList<GianHang> list = List.listGhTC();

    @Override
    public ArrayList<GianHang> get() {
        return this.list;
    }

    @Override
    public GianHangTC search(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaGianHang().equals(id) == true) {
                return (GianHangTC) list.get(i);
            }
        }
        return null;
    }

    @Override
    public Boolean add(GianHang gianHang) {
        if (search(gianHang.getMaGianHang()) == null) {
            list.add(gianHang);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean delete(String id) {
        if (search(id) == null) {
            return false;
        } else {
            list.remove(search(id));
            return true;
        }
    }

    @Override
    public Boolean update(GianHang gianHang) {
        Boolean b = false;
        GianHangTC gianHangTC = (GianHangTC) gianHang;
        for (int i = 0; i < list.size(); i++) {
            GianHangTC ghcc = (GianHangTC) list.get(i);
            if (ghcc.getMaGianHang().equals(gianHangTC.getMaGianHang()) == true) {

                ghcc.setDienTich(gianHangTC.getDienTich());
                ghcc.setViTri(gianHangTC.getViTri());
                ghcc.setChatLieuMaiChe(gianHangTC.getChatLieuMaiChe());
                ghcc.setChatLieuVachNgan(gianHangTC.getChatLieuVachNgan());
                b = true;

            }

        }
        return b;
    }

    @Override

    public double chiPhiThueGianHang(String id, Date a, Date b) {
        GianHangTC gh = (GianHangTC) search(id);
        long noDay = (a.getTime() - b.getTime()) / (24 * 3600 * 1000);
        double sum = (gh.getDienTich() * 100000) * noDay;
        return sum;
    }

    @Override
    public double chiPhiThueGianHang(String id, int soNgay) {
        GianHangTC gh = (GianHangTC) search(id);
        double sum = (gh.getDienTich() * 100000) * soNgay;
        return sum;
    }

    @Override
    public double doanhThu(Date a, Date b) {
        double sum = 0;
        long noDay = (a.getTime() - b.getTime()) / (24 * 3600 * 1000);
        for (GianHang gh : list) {
            GianHangTC temp = (GianHangTC) gh;
            sum += (temp.getDienTich() * 100000) * noDay;
        }
        return sum;
    }

    @Override
    public double doanhThu(int soNgay) {
        double sum = 0;

        for (GianHang gh : list) {
            GianHangTC temp = (GianHangTC) gh;
            sum += (temp.getDienTich() * 100000) * soNgay;
        }
        return sum;
    }

}
