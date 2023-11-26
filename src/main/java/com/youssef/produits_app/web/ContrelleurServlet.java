package com.youssef.produits_app.web;

import com.youssef.produits_app.dao.IProduitDao;
import com.youssef.produits_app.dao.ProduitDaoImpl;
import com.youssef.produits_app.model.Produit;
import org.eclipse.jetty.http.MetaData;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.ws.rs.core.Response;


public class ContrelleurServlet extends HttpServlet {

    private IProduitDao metier;


    public void init() {
        metier = new ProduitDaoImpl();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = request.getServletPath();
        if(path.equals("/index.do")){
            request.getRequestDispatcher("produits.jsp").forward(request,response);
        }
        else if(path.equals("/chercher.do")){
            String motcle = request.getParameter("motCle");
            ProduitModel model = new ProduitModel();
            model.setMotCle(motcle);
            List<Produit> produits = metier.produitsParMC("%" + motcle + "%");
            model.setProduits(produits);
            request.setAttribute("model" , model);
            request.getRequestDispatcher("produits.jsp").forward(request,response);
        }
        else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Resource not found");
        }
    }

    public void destroy() {
    }
}