package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IProduitDao;
import dao.ProduitDaoImpl;
import metier.entities.Produit;

public class ControleurServlet extends HttpServlet {
	private IProduitDao metier ;
//	@WebServlet(urlPatterns = "/*.do");
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		metier =new ProduitDaoImpl();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path =req.getServletPath();
		if(path.equals("/chercher.do")) {
			String motCle=req.getParameter("moCle");
			ProduitModel produit=new ProduitModel();
			produit.setMotCle("moCle");
			List<Produit>produits=metier.produitParMC("%"+motCle+"%");
			produit.setProduits(produits);
			req.setAttribute("produit", produit);
			req.getRequestDispatcher("/views/produits.jsp").forward(req, resp);

		}
	}

}
