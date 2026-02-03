package org.olive.algorithm.task6;

import java.util.*;

/**
 * task4.
 *
 * @author Elena Maltseva
 */
public class task4 {

    static class Node {
        int bandwidth;
        double lossPercentage;
        Node(int bandwidth, double lossPercentage) { this.bandwidth = bandwidth; this.lossPercentage = lossPercentage; }
        @Override public String toString() { return bandwidth + ", " + (int)lossPercentage + "%"; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return bandwidth == node.bandwidth && Double.compare(lossPercentage, node.lossPercentage) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(bandwidth, lossPercentage);
        }
    }

    static class Edge {
        String i, j;
        Node node;
        Edge(String i, String j, Node node) { this.i = i; this.j = j; this.node = node; }
        @Override public String toString() { return "(" + i + " - " + j + " : " + node + ")"; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return Objects.equals(i, edge.i) && Objects.equals(j, edge.j) && Objects.equals(node, edge.node);
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j, node);
        }
    }

    public static void put(Node[][] nodes, int i, int j, Node node) {
        nodes[i][j] = node;
        nodes[j][i] = node;
    }

    public static List<Edge> getEdge(int length, String[] names, Node[][] nodes){
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (nodes[i][j] != null) {
                    edges.add(new Edge(names[i], names[j], nodes[i][j]));
                }
            }
        }
        return edges;
    }

    public static void main(String[] args) {
        String[] names = {"A","B","C","D","E","F"};
        Node[][] nodes = new Node[6][6];

        put(nodes, 0,1, new Node(1500,90)); // A-B
        put(nodes, 0,2, new Node(2000,10)); // A-C
        put(nodes, 0,3, new Node(1000,50)); // A-D
        put(nodes, 1,0, new Node(1500,90)); // B-A
        put(nodes, 1,5, new Node(1500,60)); // B-F
        put(nodes, 2,0, new Node(2000,10)); // C-A
        put(nodes, 2,5, new Node(500,20));  // C-F
        put(nodes, 2,4, new Node(900,5));   // C-E
        put(nodes, 3,0, new Node(1000,50)); // D-А
        put(nodes, 3,4, new Node(2500,1));  // D-E
        put(nodes, 4,2, new Node(900,5));   // E-C
        put(nodes, 4,3, new Node(2500,1));  // E-D
        put(nodes, 4,5, new Node(300,85));  // E-F
        put(nodes, 5,1, new Node(1500,60)); // F-B
        put(nodes, 5,2, new Node(500,20));  // F-C
        put(nodes, 5,4, new Node(300,85));  // F-E

        List<Edge> edges = getEdge(nodes.length, names, nodes);

        System.out.println("Матрица смежности :");
        System.out.print("    ");
        for (String n : names) System.out.printf("%-15s", n);
        System.out.println();
        for (int i = 0; i < nodes.length; i++) {
            System.out.printf("%-4s", names[i]);
            for (int j = 0; j < nodes.length; j++) {
                System.out.printf("%-15s", nodes[i][j] == null ? "-" : nodes[i][j].toString());
            }
            System.out.println();
        }

        System.out.println("Список рёбер:");
        for (Edge e : edges) System.out.println("  " + e);
    }

}