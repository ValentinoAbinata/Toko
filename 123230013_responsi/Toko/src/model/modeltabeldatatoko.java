/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lab Informatika
 */
public class modeltabeldatatoko extends AbstractTableModel {
    
    List<datatoko> dp;
    public modeltabeldatatoko(List<datatoko> dp){
        this.dp = dp ;
    }

    @Override
    public int getRowCount() {
        return dp.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0 : 
                return "NAMA";
            case 1 : 
                return "BARANG";
            case 2 : 
                return "HARGA";
            case 3 : 
                return "CICILAN";
            case 4 : 
                return "BUNGA";
            case 5 : 
                return "ANGSURAN";
            case 6 : 
                return "TOTAL";
            default : 
                return null ;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0 : 
                return dp.get(row).getNama();
            case 1 : 
                return dp.get(row).getBarang();
            case 2 : 
                return dp.get(row).getHarga();
            case 3 : 
                return dp.get(row).getCicilan();
            case 4 : 
                return dp.get(row).getBunga();
            case 5 : 
                return dp.get(row).getAngsuran();
            case 6 : 
                return dp.get(row).getTotal();
            default : 
                return null ;
        }

    }
    
}
