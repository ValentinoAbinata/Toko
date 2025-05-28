/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOdatatoko;

import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOImplement.datatokoimplement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lab Informatika
 */
public class datatokoDAO implements datatokoimplement {
    
    Connection connection;
    
    final String select = "SELECT * FROM datatoko;";
//    INSERT INTO `datatoko` (`nama`, `barang`, `harga`, `cicilan`, `bunga`, `angsuran`, `total`) VALUES ('Adit', 'Kulkas', '48000000', '6', '72000', '872000', '5232000');
    final String insert = "INSERT INTO `datatoko` (`nama`, `barang`, `harga`, `cicilan`, `bunga`, `angsuran`, `total`) VALUES (?,?,?,?,?,?,?); ";
    final String update = "UPDATE `datatoko` SET `nama` = ?, `barang` = ?, `harga` = ?, `cicilan` = ?, `bunga` = ?, `angsuran` = ?, `total` = ? WHERE `datatoko`.`nama` = ?;" ;
    final String delete = "DELEETE FROM datatoko WHERE datatoko . nama = ?;";
    
    public datatokoDAO(){
        connection = connector.connection();
    }

    @Override
    public void insert(datatoko p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getNama());
            statement.setString(2, p.getBarang());
            statement.setInt(3, p.getHarga());
            statement.setInt(4, p.getCicilan());
            statement.setInt(5, p.getBunga());
            statement.setInt(6, p.getAngsuran());
            statement.setInt(7, p.getTotal());
            
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
        }catch(SQLException Ex){
            Ex.printStackTrace();
        } finally{
            try{
                if(statement != null) statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(datatoko p, String namaLama) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, p.getNama());
            statement.setString(2, p.getBarang());
            statement.setInt(3, p.getHarga());
            statement.setInt(4, p.getCicilan());
            statement.setInt(5, p.getBunga());
            statement.setInt(6, p.getAngsuran());
            statement.setInt(7, p.getTotal());
            statement.setString(8, namaLama);
            
            statement.executeUpdate();
        }catch(SQLException Ex){
            Ex.printStackTrace();
        } finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }

    }

    @Override
    public void delete(String nama) {
        PreparedStatement statement = null ;
        try{
            statement = connection.prepareStatement(delete);
            
            statement.setString(1, nama);
            statement.executeUpdate();
        } catch(Exception ex){
            ex.printStackTrace();
        } finally{
            try{
                statement.close();
            } catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<datatoko> getAll() {
        List<datatoko> dp = null;
        try{
            dp = new ArrayList<datatoko>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                datatoko toko = new datatoko();
                toko.setNama(rs.getString("nama"));
                toko.setBarang(rs.getString("barang"));
                toko.setHarga(rs.getInt("harga"));
                toko.setCicilan(rs.getInt("cicilan"));
                toko.setBunga(rs.getInt("bunga"));
                toko.setAngsuran(rs.getInt("angsuran"));
                toko.setTotal(rs.getInt("total"));
                dp.add(toko);
            }
        }catch(Exception ex){
            Logger.getLogger(datatokoDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        return dp;
    }
    
}
