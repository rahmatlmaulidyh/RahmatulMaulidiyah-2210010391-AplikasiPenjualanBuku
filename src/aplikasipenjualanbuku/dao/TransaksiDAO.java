/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplikasipenjualanbuku.dao;

import aplikasipenjualanbuku.model.*;
import aplikasipenjualanbuku.utils.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransaksiDAO {
    public void insertTransaksi(TransaksiModel transaksi) throws SQLException {
        String sql = "INSERT INTO transaksi (tanggal, id_buku, jumlah, total_harga) VALUES (?, ?, ?, ?)";
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, transaksi.getTanggal());
        statement.setInt(2, transaksi.getIdBuku());
        statement.setInt(3, transaksi.getJumlah());
        statement.setDouble(4, transaksi.getTotalHarga());
        statement.executeUpdate();
    }

    public void updateTransaksi(TransaksiModel transaksi) throws SQLException {
        String sql = "UPDATE transaksi SET tanggal = ?, id_buku = ?, jumlah = ?, total_harga = ? WHERE id_transaksi = ?";
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, transaksi.getTanggal());
        statement.setInt(2, transaksi.getIdBuku());
        statement.setInt(3, transaksi.getJumlah());
        statement.setDouble(4, transaksi.getTotalHarga());
        statement.setInt(5, transaksi.getIdTransaksi());
        statement.executeUpdate();
    }

    public void deleteTransaksi(int idTransaksi) throws SQLException {
        String sql = "DELETE FROM transaksi WHERE id_transaksi = ?";
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idTransaksi);
        statement.executeUpdate();
    }

    public List<TransaksiModel> getAllTransaksi() throws SQLException {
        List<TransaksiModel> list = new ArrayList<>();
        String sql = "SELECT * FROM transaksi";
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            TransaksiModel transaksi = new TransaksiModel();
            transaksi.setIdTransaksi(resultSet.getInt("id_transaksi"));
            transaksi.setTanggal(resultSet.getString("tanggal"));
            transaksi.setIdBuku(resultSet.getInt("id_buku"));
            transaksi.setJumlah(resultSet.getInt("jumlah"));
            transaksi.setTotalHarga(resultSet.getDouble("total_harga"));
            list.add(transaksi);
        }

        return list;
    }
}
