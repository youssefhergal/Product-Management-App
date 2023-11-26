package com.youssef.produits_app.dao;

import com.youssef.produits_app.model.Produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitDaoImpl implements IProduitDao{

    @Override
    public Produit save(Produit p) {
        try {
            Connection cn = SingletonConnection.getConnection();
            PreparedStatement ps = cn.prepareStatement
                    ("INSERT INTO produits (designation ,prix , quantite)" +
                            "VALUES (?,?,?)");
            ps.setString(1, p.getDesignation());
            ps.setDouble(2, p.getPrix());
            ps.setInt(3, p.getQuantite());
            ps.executeUpdate();
            PreparedStatement ps2 = cn.prepareStatement
                    ("SELECT MAX(id) AS MAX_ID FROM produits");
            ResultSet rs = ps2.executeQuery();
            if(rs.next()){
                p.setId(rs.getLong("MAX_ID"));
            }
            ps.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return  p ;
    }

    @Override
    public List<Produit> produitsParMC(String mc) {
        List<Produit> produits = new ArrayList<Produit>();
        Connection cn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = cn.prepareStatement
                    ("SELECT * FROM produits WHERE designation LIKE ?");
            ps.setString(1, mc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Produit p = new Produit();
                p.setId(rs.getLong("id"));
                p.setDesignation(rs.getString("designation"));
                p.setPrix(rs.getDouble("prix"));
                p.setQuantite(rs.getInt("quantite"));
                produits.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  produits;
    }

    @Override
    public Produit getProduit(Long id) {
        return null;
    }

    @Override
    public Produit UpdateProduit(Produit p) {
        return null;
    }

    @Override
    public void deleteProduit(Long id) {

    }
}
