package com.youssef.produits_app.dao;

import com.youssef.produits_app.model.Produit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class ProduitDaoImplTest {

    ProduitDaoImpl dao;

    @BeforeEach
    void setUp() {
        dao = new ProduitDaoImpl();
    }


    @Test
    void save()
    {
        Produit p1 = dao.save(new Produit("Dell" , 10000 , 2));
        Produit p2 = dao.save(new Produit("HP" , 5100,3));
    }

    @Test
    void produitsParMC() {
        List<Produit> produits = dao.produitsParMC("%e%");
        for (Produit p : produits){
            System.out.println(p.toString());
        }
    }

    @Test
    void getProduit() {
    }

    @Test
    void updateProduit() {
    }

    @Test
    void deleteProduit() {
    }
}