package dao;

import metier.entities.Produit;
import java.util.*;
public interface IProduitDao {

	public Produit  save (Produit p) ;
	public List<Produit>produitParMC(String mc);
	public Produit getProduit(Long id);
	public Produit update (Produit p);
	public void deleteProduit(Long id);
}
