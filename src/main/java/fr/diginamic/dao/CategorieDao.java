package fr.diginamic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.exception.TechnicalException;
import fr.diginamic.modele.Categorie;

public class CategorieDao {

	public void addCategorie(String categorie) {
		Connection conn = ConnectionMgr.getInstance();
		PreparedStatement statement = null;

		try {
			statement = conn.prepareStatement("INSERT INTO categorie (nom) VALUES (?)");
			statement.setString(1, categorie);
			statement.executeUpdate();

			conn.commit();
		} catch (SQLException e) {
			try {
				if (conn != null) {
					conn.rollback();
				}
			} catch (SQLException e1) {
				throw new TechnicalException("Le rollback a échoué", e1);
			}
			throw new TechnicalException("La ligne n'a pas pu être insérée", e);
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				throw new TechnicalException("La fermeture de la base de données à échouée", e);

			}
		}
	}

	public Integer findIdCategorie(String categorie) {
		Connection conn = ConnectionMgr.getInstance();
		PreparedStatement statement = null;
		ResultSet cursor = null;
		Integer id = 0;

		try {
			statement = conn.prepareStatement("SELECT id FROM categorie WHERE nom =?");
			statement.setString(1, categorie);
			cursor = statement.executeQuery();

			if (cursor.next()) {
				id = cursor.getInt("id");
			}

			return id;

		} catch (SQLException e) {
			throw new TechnicalException("La ligne n'a pas pu être insérée", e);
		} finally {
			try {
				if (cursor != null) {
					cursor.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				throw new TechnicalException("La fermeture de la base de données à échouée", e);

			}
		}
	}

	public boolean categorieExists(String categorie) {
		return findIdCategorie(categorie) != 0;
	}

	public List<Categorie> getCategorie() {

		Connection conn = ConnectionMgr.getInstance();
		PreparedStatement statement = null;
		ResultSet cursor = null;
		List<Categorie> listeCat = new ArrayList();
		Integer id = 0;

		try {
			statement = conn.prepareStatement("SELECT * FROM categorie");
			cursor = statement.executeQuery();

			while (cursor.next()) {
				id = cursor.getInt("id");
				String nom = cursor.getString("nom");

				listeCat.add(new Categorie(id, nom));
			}

			return listeCat;

		} catch (SQLException e) {
			throw new TechnicalException("La ligne n'a pas pu être insérée", e);
		} finally {
			try {
				if (cursor != null) {
					cursor.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				throw new TechnicalException("La fermeture de la base de données à échouée", e);

			}
		}
	}
}
