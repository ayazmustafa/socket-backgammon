package backgammon;

import java.awt.Color;
import java.util.LinkedList;

public class Eaten implements java.io.Serializable {

    int x, y, width, height;
    LinkedList<Piece> blackPieces = new LinkedList<>(); // yellow pieces
    LinkedList<Piece> redPieces = new LinkedList<>(); // blue pieces
    
    // add piece for color and set coordinates
    public void add(Piece p) {

        if (p.color.equals(Color.BLACK)) {
            p.setCoordinate(x + 5, y);
            blackPieces.add(p);
        } else {
            p.setCoordinate(x + 5, height - p.r);
            redPieces.add(p);
        }
    }

    public void setBounds(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int sizeBlack() {
        return blackPieces.size();
    }

    public int sizeRed() {
        return redPieces.size();
    }
    
    // remove last piece by using color from bar
    public Piece remove(Color player) {
        if (player.equals(Color.BLACK)) {
            return blackPieces.removeLast();
        } else {
            return redPieces.removeLast();
        }
    }
    
    // get piece selected color from bar
    public Piece get(Color player) {
        if (player.equals(Color.BLACK)) {
            return blackPieces.getLast();
        } else {
            return redPieces.getLast();
        }
    }
    
    // check a player has piece on bar
    public boolean hasPiece(Color player) {
        if (player.equals(Color.BLACK) && sizeBlack() > 0) {
            return true;
        } else if (player.equals(Color.RED) && sizeRed() > 0) {
            return true;
        }
        return false;
    }

}
