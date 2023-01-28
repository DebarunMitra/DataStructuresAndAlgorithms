package Graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    int noOfNodes = 0;
    HashMap<Integer,ArrayList<Integer>> graphList = new HashMap<Integer, ArrayList<Integer>>();

    public void addVertex(int node){
        noOfNodes++;
        graphList.put(node, new ArrayList<>());
    }

    public void addEdge(int node1, int node2){
        if(graphList.get(node1)!=null){
            graphList.get(node1).add(node2);
        }else{
            System.out.println("Error: "+node1+" Node Not Found!");
            graphList.put(node1, new ArrayList<>());
            System.out.println(node1+" Node Created!");
            graphList.get(node1).add(node2);
        }

        if(graphList.get(node2)!=null){
            graphList.get(node2).add(node1);
        }else{
            System.out.println("Error: "+node2+" Node Not Found!");
            graphList.put(node2, new ArrayList<>());
            System.out.println(node2+" Node Created!");
            graphList.get(node2).add(node1);
        }
    }

    public void viewNodeConnections(){
        Object[] keys = graphList.keySet().toArray();
        for (Object key : keys) {
            System.out.println(key + " ---> " + graphList.get(Integer.parseInt(key.toString())));
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(5,4);
        graph.addEdge(8,1);
        graph.viewNodeConnections();
    }
}

