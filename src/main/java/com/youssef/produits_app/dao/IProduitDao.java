package com.youssef.produits_app.dao;

import com.youssef.produits_app.model.Produit;

import java.util.List;

public interface IProduitDao {

    public Produit save(Produit p );
    public List<Produit> produitsParMC(String mc);

    public Produit getProduit(Long id);

    public Produit UpdateProduit(Produit p);

    public void deleteProduit(Long id);




}
