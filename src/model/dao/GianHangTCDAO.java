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
// class tên GianHangTCDAO implements Interface GianHangInterface
public class GianHangTCDAO implements GianHangInterface {

    //thuộc tính tên list kiểu dữ liệu Arraylist<GianHang> phạm vi truy cập private 
    // gán list = List.listGhTC()
    private ArrayList<GianHang> list = List.listGhTC();

    @Override // method lấy danh sách GianHangTC , kiểu dữ liệu trả về ArrayList<GianHang> , sử dụng liên kêt muộn
    public ArrayList<GianHang> get() {
        return this.list;
    }

    @Override // method tìm kiếm GianHangTC theo maGianHang kiểu dữ liệu trả về là một đối tượng GianHangTC 
    public GianHangTC search(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaGianHang().equals(id) == true) {
                return (GianHangTC) list.get(i);
            }
        }
        return null;
    }

    @Override// method thêm GianHangTC vào danh sách list, kiểu dữ liệu  tham số truyền vào là một đối tượng GianHang, kiểu dữ liệu trả về Boolean 
    public Boolean add(GianHang gianHang) {
        if (search(gianHang.getMaGianHang()) == null) {
            list.add(gianHang);
            return true;
        } else {
            return false;
        }
    }

    @Override// method xóa GianHangTC theo maGianHang, kiểu dữ liệu tham số truyền là String, kiểu dữ liệu trả về Boolean
    public Boolean delete(String id) {
        if (search(id) == null) {
            return false;
        } else {
            list.remove(search(id));
            return true;
        }
    }

    @Override // method chỉnh sửa thông tin GianHangTC, kiểu dữ liệu tham số truyền vào là một đối tượng GianHangTC, kiểu dữ liệu trả về Boolean
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

    @Override// method tính chi phí thuê gian hang, tham số truyền vào mã gian hàng , thời gian bắt đầu thuê vè kết thúc thuê , kiểu dữ liệu trả về Double 
    public double chiPhiThueGianHang(String id, Date a, Date b) {
        GianHangTC gh = (GianHangTC) search(id);
        long noDay = (a.getTime() - b.getTime()) / (24 * 3600 * 1000);
        double sum = (gh.getDienTich() * 100000) * noDay;
        return sum;
    }

    @Override // method tính chi phí thuê gian hang, tham số truyền vào mã gian hàng ,số ngày thuê , kiểu dữ liệu trả về Double 
    public double chiPhiThueGianHang(String id, int soNgay) {
        GianHangTC gh = (GianHangTC) search(id);
        double sum = (gh.getDienTich() * 100000) * soNgay;
        return sum;
    }

    @Override// method tính doanh thu cho thuê gian hàng , tham số truyền vào mã gian hàng , thời gian bắt đầu  vè kết thúc , kiểu dữ liệu trả về Double 
    public double doanhThu(Date a, Date b) {
        double sum = 0;
        long noDay = (a.getTime() - b.getTime()) / (24 * 3600 * 1000);
        for (GianHang gh : list) {
            GianHangTC temp = (GianHangTC) gh;
            sum += (temp.getDienTich() * 100000) * noDay;
        }
        return sum;
    }

    @Override// method tính doanh thu cho thuê gian hàng , tham số truyền vào mã gian hàng , sô ngày tính  , kiểu dữ liệu trả về Double 
    public double doanhThu(int soNgay) {
        double sum = 0;

        for (GianHang gh : list) {
            GianHangTC temp = (GianHangTC) gh;
            sum += (temp.getDienTich() * 100000) * soNgay;
        }
        return sum;
    }

}
