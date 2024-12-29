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

public class BukuDAO {
    public void tambahBuku(BukuModel buku) throws SQLException {
        String sql = "INSERT INTO buku (judul, pengarang, harga) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, buku.getJudul());
            stmt.setString(2, buku.getPengarang());
            stmt.setDouble(3, buku.getHarga());
            stmt.executeUpdate();
        }
    }

    public List<BukuModel> daftarBuku() throws SQLException {
        List<BukuModel> listBuku = new ArrayList<>();
        String sql = "SELECT * FROM buku";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                BukuModel buku = new BukuModel();
                buku.setIdBuku(rs.getInt("id_buku"));
                buku.setJudul(rs.getString("judul"));
                buku.setPengarang(rs.getString("pengarang"));
                buku.setHarga(rs.getDouble("harga"));
                listBuku.add(buku);
            }
        }
        return listBuku;
    }

    public List<BukuModel> cmbBuku() throws SQLException {
    List<BukuModel> list = new ArrayList<>();
    String sql = "SELECT id_buku, judul FROM buku";

    Connection connection = DBConnection.getConnection();
    PreparedStatement statement = connection.prepareStatement(sql);
    ResultSet resultSet = statement.executeQuery();

    while (resultSet.next()) {
        BukuModel buku = new BukuModel();
        buku.setIdBuku(resultSet.getInt("id_buku"));
        buku.setJudul(resultSet.getString("judul"));
        list.add(buku);
    }

    return list;
}
    public double getHargaBukuById(int idBuku) throws SQLException {
    String sql = "SELECT harga FROM buku WHERE id_buku = ?";
    Connection connection = DBConnection.getConnection();
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setInt(1, idBuku);

    ResultSet resultSet = statement.executeQuery();
    if (resultSet.next()) {
        return resultSet.getDouble("harga");
    }
    return 0;
}
    public void updateBuku(BukuModel buku) throws SQLException {
        String sql = "UPDATE buku SET judul = ?, pengarang = ?, harga = ? WHERE id_buku = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, buku.getJudul());
            stmt.setString(2, buku.getPengarang());
            stmt.setDouble(3, buku.getHarga());
            stmt.setInt(4, buku.getIdBuku());
            stmt.executeUpdate();
        }
    }

    public void hapusBuku(int idBuku) throws SQLException {
        String sql = "DELETE FROM buku WHERE id_buku = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idBuku);
            stmt.executeUpdate();
        }
    }
    
    
}

