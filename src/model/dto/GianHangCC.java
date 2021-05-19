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
public class GianHangCC extends GianHang { // một class tên GianHangCC kế thừa class GianHang phamj vi truy cập public
    private int soLuongQuatLamMat;  // thuộc tính soLuongQuatMat kiểu dữ liệu int pham vi truy cập private
    private int soLuongBanGhe; // thuộc tính soLuongBanGhe kiểu dữ liệu int phạm vi truy cập private 

    public GianHangCC() { // method Constructor không parameter
    }
    public GianHangCC(GianHangCC gianHangCC){ // method Contructor có tham số truyền vào là một đối tượng 
        super(gianHangCC.getMaGianHang(), gianHangCC.getSoLuongBanGhe(),gianHangCC.getViTri());
        this.soLuongBanGhe = gianHangCC.getSoLuongBanGhe();
        this.soLuongQuatLamMat = gianHangCC.getSoLuongQuatLamMat();
    }
    // method Constructor có tham số truyền vào là các thuộc tính của đối tượng GianHangCC 
    public GianHangCC(String maGianHang, double dienTich, String viTri,int soLuongQuatLamMat, int soLuongBanGhe) {
        super(maGianHang, dienTich, viTri);
        this.soLuongQuatLamMat = soLuongQuatLamMat;
        this.soLuongBanGhe = soLuongBanGhe;
    }

    public int getSoLuongQuatLamMat() { // method get values attribute , return kind of data int 
        return soLuongQuatLamMat;
    }

    public void setSoLuongQuatLamMat(int soLuongQuatLamMat) { // method set attribute 
        this.soLuongQuatLamMat = soLuongQuatLamMat;
    }

    public int getSoLuongBanGhe() { // method lấy giá trị  thuộc tính soLuongBanGhe , kiểu dữ liệu trả về int 
        return soLuongBanGhe;
    }

    public void setSoLuongBanGhe(int soLuongBanGhe) { // phuong thuc sửa giá trị thuộc tính 
        this.soLuongBanGhe = soLuongBanGhe;
    }

    @Override
    public String toString() { // method trả về thông tin đối tượng kiểu String 
                return "GianHangCC {" + "maGianHang=" + this.getMaGianHang() + ", dienTich=" + this.getDienTich() + ", viTri=" + this.getViTri() + ", soLuongQuatLamMat="+ this.soLuongQuatLamMat+ ", soLuongBanGhe="+ this.soLuongBanGhe +'}';

    }

  

   
    
}
