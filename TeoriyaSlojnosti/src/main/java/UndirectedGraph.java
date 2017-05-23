/**
 * Created by Elina.
 */

import java.util.*;

public class UndirectedGraph {

    //список смежности
    private HashMap<Integer, List<Vertex>> vertexMap = new HashMap<Integer, List<Vertex>>();

    //добавить вершину
    public void addVertex(Integer vertexName) {
        //если ещё нет такой вершины
        if (!hasVertex(vertexName)) {
            //добавляем вершину
            vertexMap.put(vertexName, new ArrayList<Vertex>());
        }
    }

    //проверка есть ли такая вершина уже в графе
    public boolean hasVertex(Integer vertexName) {
        return vertexMap.containsKey(vertexName);
    }

    //проверка есть ли уже такое ребро в графе
    public boolean hasEdge(Integer vertexName1, Integer vertexName2, int weight) {
        if (!hasVertex(vertexName1)) return false;
        List<Vertex> edges = vertexMap.get(vertexName1);
        for (Vertex v :
                edges) {
            if (v.getDestination() == vertexName2 && v.getWeight() == weight) return true;
        }
        return false;
    }

    //проверка есть ли уже такое ребро в графе, без учета его веса
    public boolean hasEdgeWithoutWight(Integer vertexName1, Integer vertexName2) {
        if (!hasVertex(vertexName1)) return false;
        List<Vertex> edges = vertexMap.get(vertexName1);
        for (Vertex v :
                edges) {
            if (v.getDestination() == vertexName2) return true;
        }
        return false;
    }

    //добавить ребро
    public void addEdge(Integer vertexName1, Integer vertexName2, int weight) {
        if (!hasVertex(vertexName1)) addVertex(vertexName1);
        if (!hasVertex(vertexName2)) addVertex(vertexName2);
        List<Vertex> edges1 = vertexMap.get(vertexName1);
        List<Vertex> edges2 = vertexMap.get(vertexName2);
        edges1.add(new Vertex(vertexName2, weight));
        edges2.add(new Vertex(vertexName1, weight));
        Collections.sort(edges1);
        Collections.sort(edges2);
    }

    //вернуть список смежности
    public Map<Integer, List<Vertex>> getVertexMap() {
        return vertexMap;
    }

    //выод списка смежности
    public void ShowGpaph(Map<Integer, List<Vertex>> map) {
        Iterator<Map.Entry<Integer, List<Vertex>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, List<Vertex>> mapa = iterator.next();
            System.out.print(mapa.getKey() + ": ");
            Iterator<Vertex> iterator1 = mapa.getValue().iterator();
            while (iterator1.hasNext()) {
                Vertex v = iterator1.next();
                System.out.print(v.getDestination() + "(" + v.getWeight() + ") ");
            }
            System.out.println();
        }
    }

}

