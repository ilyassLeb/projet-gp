package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Produit;

public class ProduitDaoImpl implements IProduitDao {
	

	public ProduitDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Produit save(Produit p) {
		Connection  connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("INSERT INTO  PRODUITS (DESIGNATION,PRIX,QUANTITE)VALUES(?,?,?)");
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3,p.getQuantite());
			ps.executeUpdate();
			ps.close();
			//quand vous utilisrr le sengleton , on doit pas fermer la connexion parce uq elle a créer une seul fois 
			PreparedStatement ps2=connection.prepareStatement("SELECT MAX(ID) AS MAX_ID FROM PRODUITS");
			ResultSet rs=ps2.executeQuery();
			if(rs.next()) {
				p.setId(rs.getLong("MAX_ID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Produit> produitParMC(String mc) {
		Connection connection =SingletonConnection.getConnection();
		List<Produit> produits=new ArrayList<Produit>();
		try {
			PreparedStatement ps=connection.prepareStatement("SELECT * FROM PRODUITS WHERE DESIGNATION LIKE ?");
			ps.setString(1,mc);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Produit p =new Produit();
				p.setId(rs.getLong("ID"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("PRIX"));
				p.setQuantite(rs.getInt("QUANTITE"));
				produits.add(p);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produits;
		
	} 

	@Override
	public Produit getProduit(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit update(Produit p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduit(Long id) {
		// TODO Auto-generated method stub
		
	}

}
