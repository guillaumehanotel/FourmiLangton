package com.guillaumehanotel.langtonant.core;

import com.guillaumehanotel.langtonant.beans.Cell;
import com.guillaumehanotel.langtonant.beans.Ant;

public class Plateau {


	private Cell[][] plateau;
	private int tailleGrille;
	private Ant ant;
	private boolean borderMode;

	public Plateau(int tailleGrille, boolean borderMode){
		this.tailleGrille = tailleGrille;
		this.borderMode = borderMode;
		this.plateau = new Cell[this.tailleGrille][this.tailleGrille];
		initPlateau();
	}


	public void reinitialisation() {

		for (int i =0; i < this.tailleGrille;i++){
			for (int j = 0; j < this.tailleGrille;j++){
				this.plateau[i][j].initCell();
			}
		}  

		ant.initAnt();
	}

	private void initPlateau() {
		for (int i =0; i < this.tailleGrille;i++){
			for (int j = 0; j < this.tailleGrille;j++){
				createCell(i, j);
			}
		}  
	}

	private void createCell(int i, int j) {
		// si c'est la case du milieu, on y met la fourmi
		if(isCenterCell(i, j))    {
			createAnt(i, j);
		} else {
			this.plateau[i][j] = new Cell(i,j);
		} 	
	}

	private boolean isCenterCell(int i, int j) {
		return ((i == (this.tailleGrille-1)/2) && (j == (this.tailleGrille-1)/2));
	}

	private void createAnt(int i, int j) {
		Cell cell = new Cell(i,j);
		this.plateau[i][j] = cell;
		this.ant = new Ant(cell);
		this.ant.associePlateau(this);
	}

	/**
	 * Prend en paramètre la position d'une cellule, et renvoie la cellule à sa gauche, 
	 * si il n'y a pas de cellule à sa gauche c'est la cellule dont la position est passée en 
	 * paramètre qui est renvoyé
	 * @param x
	 * @param y
	 * @return
	 */
	public Cell getCelluleGauche(int x, int y){
		if(borderMode) {
			return (x-1 >= 0) ? this.getPlateau()[x-1][y] : this.getPlateau()[tailleGrille-1][y];
		} else {
			return (x-1 >= 0) ? this.getPlateau()[x-1][y] : this.getPlateau()[x][y];
		}
	}

	/**
	 * Prend en paramètre la position d'une cellule, et renvoie la cellule à sa droite, 
	 * si il n'y a pas de cellule à sa droite c'est la cellule dont la position est passée en 
	 * paramètre qui est renvoyé
	 * @param x
	 * @param y
	 * @return
	 */
	public Cell getCelluleDroite(int x, int y){
		if(borderMode) {
			return (x+1 <= this.tailleGrille-1) ? this.getPlateau()[x+1][y] : this.getPlateau()[0][y];
		} else {
			return (x+1 <= this.tailleGrille-1) ? this.getPlateau()[x+1][y] : this.getPlateau()[x][y];
		}
	}

	/**
	 * Prend en paramètre la position d'une cellule, et renvoie la cellule du haut, 
	 * si il n'y a pas de cellule en haut c'est la cellule dont la position est passée en 
	 * paramètre qui est renvoyé
	 * @param x
	 * @param y
	 * @return
	 */
	public Cell getCelluleHaut(int x, int y){
		if(borderMode) {
			return (y+1 <= this.tailleGrille-1) ? this.getPlateau()[x][y+1] : this.getPlateau()[x][0];
		} else {
			return (y+1 <= this.tailleGrille-1) ? this.getPlateau()[x][y+1] : this.getPlateau()[x][y];
		}
	}

	/**
	 * Prend en paramètre la position d'une cellule, et renvoie la cellule du bas, 
	 * si il n'y a pas de cellule en bas c'est la cellule dont la position est passée en 
	 * paramètre qui est renvoyé
	 * @param x
	 * @param y
	 * @return
	 */
	public Cell getCelluleBas(int x, int y){
		if (borderMode) {
			return (y-1 >= 0) ? this.getPlateau()[x][y-1] : this.getPlateau()[x][tailleGrille-1];
		} else {
			return (y-1 >= 0) ? this.getPlateau()[x][y-1] : this.getPlateau()[x][y];
		}
	}

	public Cell[][] getPlateau() {
		return plateau;
	}

	public int getTailleGrille() {
		return tailleGrille;
	}

	public void setTailleGrille(int tailleGrille) {
		this.tailleGrille = tailleGrille;
	}

	public Ant getAnt() {
		return ant;
	}

	public void setAnt(Ant ant) {
		this.ant = ant;
	}

}
