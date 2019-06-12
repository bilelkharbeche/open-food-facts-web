package fr.diginamic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.exception.TechnicalException;
import fr.diginamic.modele.Marque;
import fr.diginamic.modele.Produit;

/**
 * @author KHARBECHE Bilel
 *
 */
public class MarqueDao {

	/** listePizza : ArrayList<Pizza> */
	private ArrayList<Produit> listeMarque = new ArrayList();

	/**
	 * @param marque
	 */
	public void addMarque(String marque) {
		Connection conn = ConnectionMgr.getInstance();
		PreparedStatement statement = null;

		try {
			statement = conn.prepareStatement("INSERT INTO marque (nom) VALUES (?)");
			statement.setString(1, marque);
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

	public Integer findIdMarque(String marque) {
		Connection conn = ConnectionMgr.getInstance();
		PreparedStatement statement = null;
		ResultSet cursor = null;
		Integer id = 0;

		try {
			statement = conn.prepareStatement("SELECT id FROM marque WHERE nom =?");
			statement.setString(1, marque);
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

	public boolean marqueExists(String marque) {
		return findIdMarque(marque) != 0;
	}

	public List<Marque> getMarque(Integer idCat) {

		Connection conn = ConnectionMgr.getInstance();
		PreparedStatement statement = null;
		ResultSet cursor = null;
		List<Marque> listeMarque = new ArrayList();
		Integer id = 0;

		try {
			statement = conn.prepareStatement(
					"SELECT DISTINCT (m.nom) FROM marque m, produit p WHERE m.id = p.id_marque AND id_cat = ?");
			statement.setLong(1, idCat);
			cursor = statement.executeQuery();

			while (cursor.next()) {
				// id = cursor.getInt("id");
				String nom = cursor.getString("m.nom");

				listeMarque.add(new Marque(nom));
			}

			return listeMarque;

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
