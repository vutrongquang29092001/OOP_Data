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
// class tên GIanHangCCDAO implements Interface GianHangInterface , phạm vi truy cập public 
public class GianHangCCDAO implements GianHangInterface {
    // thuộc tính tên list kiểu dữ liệu ArrayList<GianHang> phạm vi truy cập private 
    // gán list = List.listGhCC()
    private ArrayList<GianHang> list = List.listGhCC();

    @Override// method lấy danh sách GianHangCC , kiểu dữ liệu trả về là ArrayList<GianHang> 
    public ArrayList<GianHang> get() {

        return this.list;
    }

    @Override // method thêm GianHangCC , kiểu dữ liệu tham số truyền vào là một đối tượng GianHang , kiểu trả về Boolean 
    public Boolean add(GianHang gianHang) {
        if (search(gianHang.getMaGianHang()) == null) {
            this.list.add(gianHang);
            return true;
        } else {
            return false;
        }

    }

    @Override // method xóa GianHangCC theo maGianHang , kiểu tham số truyền vào String , kiểu dữ liệu trả Boolean 
    public Boolean delete(String id) {
        if (search(id) == null) {
            return false;
        } else {
            list.remove(search(id));
            return true;
        }
    }

    @Override// method tim kiếm GianHangCC theo maGianHang , kiểu tham số truyền vào String , kiểu dữ liệu trả về một đối tượng GianHang 
    public GianHang search(String id) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaGianHang().equals(id) == true) {
                return list.get(i);
            }
        }
        return null;
    }

    @Override// method sủa thông tin GianHang , kiểu dữ liệu tham số truyền vào một đối tượng GianHang, kiểu trả về  boolean 
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

    @Override // method tính chi phí thuê gian hàng ,tham số truyền vào maGianHang:String , và thời gian bắt đầu và thời gian kết thúc, kiểu dữ liệu trả về Boolean 
    public double chiPhiThueGianHang(String id, Date a, Date b) {
        GianHangCC gh = (GianHangCC) search(id);
        long noDay = (a.getTime() - b.getTime()) / (24 * 3600 * 1000);
        double sum = (gh.getDienTich() * 120000 + gh.getSoLuongQuatLamMat() * 50000) * noDay;
        return sum;
    }

    @Override// method tính chi phí thuê gian hàng ,tham số truyền vào maGianHang:String , và sô ngày thuê , kiểu dữ liệu trả về Boolean 
    public double chiPhiThueGianHang(String id, int soNgay) {
        GianHangCC gh = (GianHangCC) search(id);
        double sum = (gh.getDienTich() * 120000 + gh.getSoLuongQuatLamMat() * 50000) * soNgay;
        return sum;
    }

    @Override// method tính doanh thu  thuê gian hàng ,tham số truyền vào maGianHang:String , và thời gian bắt đầu và thời gian kết thúc, kiểu dữ liệu trả về Boolean 
    public double doanhThu(Date a, Date b) {
        double sum = 0;
        long noDay = (a.getTime() - b.getTime()) / (24 * 3600 * 1000);
        for (GianHang gh : list) {
            GianHangCC temp = (GianHangCC) gh;
            sum += (temp.getDienTich() * 120000 + temp.getSoLuongQuatLamMat() * 50000) * noDay;
        }
        return sum;
    }

    @Override// method tính doanh thu  thuê gian hàng ,tham số truyền vào maGianHang:String , và số ngày , kiểu dữ liệu trả về Boolean
    public double doanhThu(int soNagy) {
        double sum = 0;

        for (GianHang gh : list) {
            GianHangCC temp = (GianHangCC) gh;
            sum += (temp.getDienTich() * 120000 + temp.getSoLuongQuatLamMat() * 50000) * soNagy;
        }
        return sum;
    }

}
