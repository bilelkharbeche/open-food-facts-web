package fr.diginamic.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.diginamic.dao.CategorieDao;
import fr.diginamic.dao.MarqueDao;
import fr.diginamic.dao.ProduitDao;
import fr.diginamic.modele.Categorie;
import fr.diginamic.modele.Marque;
import fr.diginamic.modele.Produit;

@WebServlet(urlPatterns = "/rechercher/*")
public class InitController extends HttpServlet {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategorieDao catDao = new CategorieDao();
		MarqueDao marqueDao = new MarqueDao();

		String marqueSelect = req.getParameter("marqueSelect");
		if (marqueSelect != null) {
			Integer marqueSelectParse = Integer.parseInt(marqueSelect);
			List<Marque> listeMarque = marqueDao.getMarque(marqueSelectParse);
			req.setAttribute("marque", listeMarque);
			req.setAttribute("marqueSelect", marqueSelectParse);
		}

		List<Categorie> listeCat = catDao.getCategorie();

		req.setAttribute("categorie", listeCat);

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/openFoodFact.jsp");
		dispatcher.forward(req, resp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProduitDao prodDao = new ProduitDao();

		String catSelect = req.getParameter("catSelect");
		Integer catSelectParse = Integer.parseInt(catSelect);
		List<Produit> listeProd = prodDao.getProduit(catSelectParse);

		req.setAttribute("produit", listeProd);

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/openFoodRecup.jsp");
		dispatcher.forward(req, resp);
	}

}
