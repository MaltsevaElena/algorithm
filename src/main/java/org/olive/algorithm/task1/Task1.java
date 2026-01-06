package org.olive.algorithm.task1;

import java.util.HashMap;
import java.util.Map;

/**
 * Task1.
 *
 * @author Elena Maltseva
 */
public class Task1 {
    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E", "F"};

        String[][] resultMatrix = new String[6][6];
        Map<String, Node> allNodes = new HashMap<>();
        for (String name : names) {
            allNodes.put(name, new Node(name));
        }

        Map<String, Integer> nodeNames = new HashMap<>();
        nodeNames.put("A", 0);
        nodeNames.put("B", 1);
        nodeNames.put("C", 2);
        nodeNames.put("D", 3);
        nodeNames.put("E", 4);
        nodeNames.put("F", 5);

        String[][] data = {
                {"A", "B", "1500, 90%"},
                {"A", "C", "2000, 10%"},
                {"A", "D", "1000, 50%"},
                {"B", "F", "1500, 60%"},
                {"C", "E", "900, 5%"},
                {"C", "F", "500, 20%"},
                {"D", "E", "2500, 1%"},
                {"E", "F", "300, 85%"},
        };

        for (String[] node : data) {
            String oneName = node[0];
            String twoName = node[1];
            String bandwidthAndLossPercentage = node[2];

            int oneIdx = nodeNames.get(oneName);
            int twoIdx = nodeNames.get(twoName);
            Node oneNode = allNodes.get(oneName);
            Node twoNode = allNodes.get(twoName);

            resultMatrix[oneIdx][twoIdx] = bandwidthAndLossPercentage;
            resultMatrix[twoIdx][oneIdx] = bandwidthAndLossPercentage;
            oneNode.addConnection(twoName, bandwidthAndLossPercentage);
            twoNode.addConnection(oneName, bandwidthAndLossPercentage);
        }

        System.out.println("Представление сети в виде массива:");
        for (String name : names) {
            System.out.printf("%-15s", "     " + name);
        }
        System.out.println();
        for (int i = 0; i < 6; i++) {
            System.out.printf("%-4s ", names[i]);
            for (int j = 0; j < 6; j++) {
                System.out.printf("%-15s", resultMatrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("__________________________________________");
        System.out.println("Представление сети с использованием узлов:");
        for (String nodeName : names) {
            System.out.println(allNodes.get(nodeName));
        }
    }
}

class Node {
    String name;
    Map<String, String> connections;

    public Node(String name) {
        this.name = name;
        this.connections = new HashMap<>();
    }

    public void addConnection(String neighborNodeName, String bandwidthAndLossPercentage) {
        connections.put(neighborNodeName, bandwidthAndLossPercentage);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Соединения узла ").append(name).append(": {");
        boolean first = true;
        for (Map.Entry<String, String> entry : connections.entrySet()) {
            if (!first) {
                sb.append(", ");
            }
            sb.append(entry.getKey()).append(": ").append(entry.getValue());
            first = false;
        }
        sb.append("}");
        return sb.toString();
    }
}
