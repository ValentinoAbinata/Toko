/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import DAOdatatoko.datatokoDAO;
import DAOImplement.datatokoimplement;
import model.*;
import view.MainView;
import javax.swing.*;

/**
 *
 * @author Lab Informatika
 */
public class datatokocontroller {
    MainView frame;
    datatokoimplement impldatatoko;
    List<datatoko> dp;
    
    public datatokocontroller(MainView frame){
        this.frame = frame ;
        impldatatoko = new datatokoDAO();
        dp = impldatatoko.getAll();
    }
    
    public void isitabel(){
        dp = impldatatoko.getAll();
        modeltabeldatatoko mp = new modeltabeldatatoko(dp);
        frame.getTabelDatatoko().setModel(mp);
    }
    
    public void insert(){
        datatoko dp = new datatoko();
        dp.setNama(frame.getjTxtnama().getText());
        String barang;
        barang = (frame.getjComboBoxbarang().getSelectedItem().toString());
        dp.setBarang(frame.getjComboBoxbarang().getSelectedItem().toString());
//        barang = dp.setBarang(frame.getjComboBoxbarang().getSelectedItem().toString());
        dp.setCicilan(Integer.valueOf(frame.getjComboBoxcicilan().getSelectedItem().toString()));// testing atau Integer.parseInt
        
        // Harga
        int harga = 0;
        if(barang.equals("TV")){
            harga = 4800000;
        }
        if(barang.equals("Kulkas")){
            harga = 6000000;
        }
        if(barang.equals("Mesin Cuci")){
            harga = 4800000;
        }
        dp.setHarga(harga);
        
        // Bunga
        int bunga = harga * 15/1000;
        dp.setBunga(bunga);
        
        // Angsuran
        int cicilan = Integer.valueOf(frame.getjComboBoxcicilan().getSelectedItem().toString());
        int angsuran ;
        angsuran = (harga/ cicilan) + bunga;
        dp.setAngsuran(angsuran);
        
        // Total
        int total = angsuran * cicilan;
        dp.setTotal(total);
    }
    
    public void update(){
        // testing
    }
    
    public void delete(){
        String nama = frame.getjTxtnama().getText();
        impldatatoko.delete(nama);
    }
}

//dp.setBarang(frame.getjComboBoxbarang().getSelectedItem().toString());
