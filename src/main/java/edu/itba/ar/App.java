package edu.itba.ar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App
{
    private final static List<Node> nodes = new ArrayList<>();

    public static void main( String[] args )
    {
        int N = 2000, L = 150, M=1;
        float rc = 25.56755f;
        cellIndex(N,L,M,rc);
        System.out.println("hola\n");
    }
    public static void setCellCoords(int M, int L){
        for(Node node : nodes){
            node.setCellX((int) Math.floor((node.getX()*M)/L));
            node.setCellY((int) Math.floor((node.getY()*M)/L));
        }
    }
    public static void generateNodes(int N, int L,float rc){
        Random r =new Random();
        for(int i=0;i<N;i++){
            nodes.add(new Node( L * r.nextFloat(),L * r.nextFloat(),rc));
        }
    }
    public static void cellIndex(int N, int L, int M, float rc){
        while(L/M> rc){
            M++;
        }
        generateNodes(N,L,rc);
        setCellCoords(M,L);
        for(Node node: nodes){
            for(Node node2 : nodes){
                if(!node.equals(node2)){
                    node.isNeighbor(node2);
                }
            }
        }
    }
}
