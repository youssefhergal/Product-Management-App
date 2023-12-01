package com.youssef.produits_app.web;

import com.youssef.produits_app.dao.IProduitDao;
import com.youssef.produits_app.dao.ProduitDaoImpl;
import com.youssef.produits_app.model.Produit;
import org.eclipse.jetty.http.MetaData;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.ws.rs.core.Response;


@WebServlet(name = "cs" , urlPatterns = {"*.php"})
public class ContrelleurServlet extends HttpServlet {

    private IProduitDao metier;


    public void init() {
        metier = new ProduitDaoImpl();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = request.getServletPath();
        if(path.equals("/index.php")){
            request.getRequestDispatcher("produits.jsp").forward(request,response);
        }
        else if(path.equals("/chercher.php")){
            String motcle = request.getParameter("motCle");
            ProduitModel model = new ProduitModel();
            model.setMotCle(motcle);
            List<Produit> produits = metier.produitsParMC("%" + motcle + "%");
            model.setProduits(produits);
            request.setAttribute("model" , model);
            request.getRequestDispatcher("produits.jsp").forward(request,response);
        } else if (path.equals("/Saisie.php") ) {
            request.setAttribute("produit" , new Produit());
            request.getRequestDispatcher("SaisieProduit.jsp").forward(request, response);
        }else if (path.equals("/SaveProduit.php") && (request.getMethod().equals("POST"))){
            String designation = request.getParameter("designation");
            double prix =Double.parseDouble(request.getParameter("prix"));
            int quantite = Integer.parseInt(request.getParameter("quantite"));
            Produit p = metier.save(  new Produit(designation,prix,quantite));
            request.setAttribute("produit" , p );
            request.getRequestDispatcher("confirmation.jsp").forward(request,response);


        } else if (path.equals("/supprimer.php")) {
          Long id = Long.parseLong(request.getParameter("id"));
          metier.deleteProduit(id);
          //request.getRequestDispatcher("produits.jsp").forward(request,response);
          response.sendRedirect("chercher.php?motCle=");
        }
        else if (path.equals("/edit.php")) {
            Long id = Long.parseLong(request.getParameter("id"));
            Produit p = metier.getProduit(id);
            request.setAttribute("produit",p);
            request.getRequestDispatcher("EditProduit.jsp").forward(request,response);
        }
        else if (path.equals("/UpdateProduit.php") && (request.getMethod().equals("POST"))){
            Long id = Long.parseLong(request.getParameter("id"));
            String designation = request.getParameter("designation");
            double prix =Double.parseDouble(request.getParameter("prix"));
            int quantite = Integer.parseInt(request.getParameter("quantite"));
            Produit p = new Produit(designation,prix,quantite);
            p.setId(id);
            p = metier.UpdateProduit(p);
            request.setAttribute("produit" , p );
            request.getRequestDispatcher("confirmation.jsp").forward(request,response);
        }
        else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Resource not found");
        }
    }

    public void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    public void destroy() {
    }
}