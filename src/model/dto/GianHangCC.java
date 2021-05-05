/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;

/**
 *
 * @author Admin
 */
public class GianHangCC extends GianHang {
    private int soLuongQuatLamMat;
    private int soLuongBanGhe;

    public GianHangCC() {
    }
    public GianHangCC(GianHangCC gianHangCC){
        super(gianHangCC.getMaGianHang(), gianHangCC.getSoLuongBanGhe(),gianHangCC.getViTri());
        this.soLuongBanGhe = gianHangCC.getSoLuongBanGhe();
        this.soLuongQuatLamMat = gianHangCC.getSoLuongQuatLamMat();
    }
    public GianHangCC(String maGianHang, double dienTich, String viTri,int soLuongQuatLamMat, int soLuongBanGhe) {
        super(maGianHang, dienTich, viTri);
        this.soLuongQuatLamMat = soLuongQuatLamMat;
        this.soLuongBanGhe = soLuongBanGhe;
    }

    public int getSoLuongQuatLamMat() {
        return soLuongQuatLamMat;
    }

    public void setSoLuongQuatLamMat(int soLuongQuatLamMat) {
        this.soLuongQuatLamMat = soLuongQuatLamMat;
    }

    public int getSoLuongBanGhe() {
        return soLuongBanGhe;
    }

    public void setSoLuongBanGhe(int soLuongBanGhe) {
        this.soLuongBanGhe = soLuongBanGhe;
    }

    @Override
    public String toString() {
                return "GianHangCC {" + "maGianHang=" + this.getMaGianHang() + ", dienTich=" + this.getDienTich() + ", viTri=" + this.getViTri() + ", soLuongQuatLamMat="+ this.soLuongQuatLamMat+ ", soLuongBanGhe="+ this.soLuongBanGhe +'}';

    }

  

   
    
}
