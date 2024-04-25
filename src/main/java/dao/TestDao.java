package dao;

import java.util.Iterator;
import java.util.List;

import metier.entities.Produit;

public class TestDao {

	public static void main(String[] args) {

		
		ProduitDaoImpl dao =new ProduitDaoImpl();
		Produit produit1 =dao.save(new Produit("cle wifi",200,5));
		Produit produit2 =dao.save(new Produit("stylo",200,5));

		Produit produit3=dao.save(new Produit("ordinateur",2000,5));
		System.out.println(produit1.toString());
		System.out.println(produit2.toString());
		System.out.println(produit3.toString());
		System.out.println("cherher les produits ");
		
		
		List<Produit>produits=dao.produitParMC("%s%");
	   for (Produit p : produits) {
		   if(p !=null)
		   System.out.println(p.toString());
	     }


	}

}
