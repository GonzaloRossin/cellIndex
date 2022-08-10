package edu.itba.ar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {
    private final float x;
    private final float y;
    float rc;
    List<Node> neighbors = new ArrayList<>();
    private int cellX;
    private int cellY;

    public Node(float x, float y ,float rc) {
        this.x = x;
        this.y = y;
        this.rc = rc;
    }

    public float getRc() {
        return rc;
    }

    public void setRc(float rc) {
        this.rc = rc;
    }

    public void isNeighbor(Node node){
        if(neighbors.contains(node)){
            return;
        }
        if( Math.abs(this.getCellX()- node.getCellX())<=1 && Math.abs(this.getCellY()- node.getCellY())<=1){
            if(isInRange(node)){
                this.neighbors.add(node);
                node.neighbors.add(this);
            }
        }
    }
    boolean isInRange(Node node){
        return Math.sqrt(Math.pow(node.getX()-x,2)+Math.pow(node.getY()-y,2)) <= rc;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return Double.compare(node.getX(), getX()) == 0 && Double.compare(node.getY(), getY()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getCellX() {
        return cellX;
    }

    public void setCellX(int cellX) {
        this.cellX = cellX;
    }

    public int getCellY() {
        return cellY;
    }

    public void setCellY(int cellY) {
        this.cellY = cellY;
    }

    @Override
    public String toString() {
        return "Node{cellX=" + cellX +",cellY="+ cellY + '}';
    }
}
