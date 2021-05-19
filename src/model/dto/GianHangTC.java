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
public class GianHangTC extends GianHang { // class tên GianHangTC kế thừa class GianHang
private String chatLieuMaiChe;  // thuộc tính chatLieuMaiChe kiểu dữ kiệu trả về String pham vi truy cập private 
private String chatLieuVachNgan; // thuộc tính chatLieuVachNgan kiểu dữ liệu trả về String phạm vi truy cập private 

    public GianHangTC() { // method constructor không tham số
        super();
    }
    // method constructor có tham số truyền vào 
    public GianHangTC(String maGianHang, double dienTich, String viTri,String chatLieuMaiChe, String chatLieuVachNgan) {
        super(maGianHang, dienTich, viTri);
        this.chatLieuMaiChe = chatLieuMaiChe;
        this.chatLieuVachNgan = chatLieuVachNgan;
    }
    // method lấy giá trị thuộc tính chatLieuMaiChe kiểu dữ liệu trả về String 
    public String getChatLieuMaiChe() {
        return chatLieuMaiChe;
    }
    // method sửa giá trị thuộc tính chatLieuMaiChe tham số truyền vào có kiểu dữ liệu String 
    public void setChatLieuMaiChe(String chatLieuMaiChe) {
        this.chatLieuMaiChe = chatLieuMaiChe;
    }
    // method lấy giá trị thuộc tính chatLieuVachNgan kiểu dữ kiệu trả về String 
    public String getChatLieuVachNgan() {
        return chatLieuVachNgan;
    }
    // method sửa giá trị thuộc tính chatLieuVachNgan tham số truyền vào có kiểu dữ kiểu String 
    public void setChatLieuVachNgan(String chatLieuVachNgan) {
        this.chatLieuVachNgan = chatLieuVachNgan;
    }
    
    // method trả về thông tin đối tượng gọi method có kiểu dữ liệu String 
    @Override
    public String toString() {
     return "GianHangTC {" + "maGianHang=" + this.getMaGianHang() + ", dienTich=" + this.getDienTich() + ", viTri=" + this.getViTri() + ", chatLieuMaiChe="+ this.chatLieuMaiChe+ ", chatLieuVachNgan="+ this.chatLieuVachNgan +'}';

    }
    
}
