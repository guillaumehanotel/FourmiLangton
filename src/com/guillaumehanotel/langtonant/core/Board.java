package com.guillaumehanotel.langtonant.core;

import com.guillaumehanotel.langtonant.beans.Cell;
import com.guillaumehanotel.langtonant.beans.Ant;

public class Board {


    private Cell[][] board;
    private int gridLength;
    private Ant ant;
    private boolean borderMode;

    public Board(int gridLength, boolean borderMode) {
        this.gridLength = gridLength;
        this.borderMode = borderMode;
        this.board = new Cell[this.gridLength][this.gridLength];
        initBoard();
    }


    void reinitialization() {

        for (int i = 0; i < this.gridLength; i++) {
            for (int j = 0; j < this.gridLength; j++) {
                this.board[i][j].initCell();
            }
        }

        ant.initAnt();
    }

    private void initBoard() {
        for (int i = 0; i < this.gridLength; i++) {
            for (int j = 0; j < this.gridLength; j++) {
                createCell(i, j);
            }
        }
    }

    private void createCell(int i, int j) {
        // si c'est la case du milieu, on y met la fourmi
        if (isCenterCell(i, j)) {
            createAnt(i, j);
        } else {
            this.board[i][j] = new Cell(i, j);
        }
    }

    private boolean isCenterCell(int i, int j) {
        return ((i == (this.gridLength - 1) / 2) && (j == (this.gridLength - 1) / 2));
    }

    private void createAnt(int i, int j) {
        Cell cell = new Cell(i, j);
        this.board[i][j] = cell;
        this.ant = new Ant(cell);
        this.ant.associeBoard(this);
    }

    /**
     * Prend en paramètre la position d'une cellule, et renvoie la cellule à sa gauche,
     * si il n'y a pas de cellule à sa gauche c'est la cellule dont la position est passée en
     * paramètre qui est renvoyé
     *
     * @param x X
     * @param y Y
     * @return Cell
     */
    public Cell getLeftCell(int x, int y) {
        int xLimit = borderMode ? gridLength - 1 : x;
        return (x - 1 >= 0) ? this.getBoard()[x - 1][y] : this.getBoard()[xLimit][y];
    }

    /**
     * Prend en paramètre la position d'une cellule, et renvoie la cellule à sa droite,
     * si il n'y a pas de cellule à sa droite c'est la cellule dont la position est passée en
     * paramètre qui est renvoyé
     *
     * @param x X
     * @param y Y
     * @return Cell
     */
    public Cell getRightCell(int x, int y) {
        int xLimit = borderMode ? 0 : x;
        return (x + 1 <= this.gridLength - 1) ? this.getBoard()[x + 1][y] : this.getBoard()[xLimit][y];
    }

    /**
     * Prend en paramètre la position d'une cellule, et renvoie la cellule du haut,
     * si il n'y a pas de cellule en haut c'est la cellule dont la position est passée en
     * paramètre qui est renvoyé
     *
     * @param x X
     * @param y Y
     * @return Cell
     */
    public Cell getTopCell(int x, int y) {
        int yLimit = borderMode ? 0 : y;
        return (y + 1 <= this.gridLength - 1) ? this.getBoard()[x][y + 1] : this.getBoard()[x][yLimit];
    }

    /**
     * Prend en paramètre la position d'une cellule, et renvoie la cellule du bas,
     * si il n'y a pas de cellule en bas c'est la cellule dont la position est passée en
     * paramètre qui est renvoyé
     *
     * @param x X
     * @param y Y
     * @return Cell
     */
    public Cell getBottomCell(int x, int y) {
        int yLimit = borderMode ? gridLength - 1 : y;
        return (y - 1 >= 0) ? this.getBoard()[x][y - 1] : this.getBoard()[x][yLimit];
    }

    public Cell[][] getBoard() {
        return board;
    }

    public int getGridLength() {
        return gridLength;
    }

    public void setGridLength(int gridLength) {
        this.gridLength = gridLength;
    }

    public Ant getAnt() {
        return ant;
    }

    public void setAnt(Ant ant) {
        this.ant = ant;
    }

}
