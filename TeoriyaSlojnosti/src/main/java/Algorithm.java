import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Elina.
 */
public class Algorithm {

    //Алгоритм Флойда
    public int[][] DoFloid(Map<Integer, List<Vertex>> map) {

        int sizeMap = map.size();
        System.out.println("sizeMap = " + sizeMap);
        int[][] floid = new int[sizeMap][sizeMap];

        for (int i = 0; i < sizeMap; i++) {
            for (int j = 0; j < sizeMap; j++) {
                if (i != j) {
                    floid[i][j] = 1000;
                }
            }
        }

        Iterator<Map.Entry<Integer, List<Vertex>>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, List<Vertex>> mapa = iterator.next();
            Iterator<Vertex> iterator1 = mapa.getValue().iterator();
            while (iterator1.hasNext()) {
                Vertex v = iterator1.next();
                floid[mapa.getKey()][v.getDestination()] = v.getWeight();
            }
        }

        for (int k = 0; k < sizeMap; k++) {
            for (int i = 0; i < sizeMap; i++) {
                for (int j = 0; j < sizeMap; j++) {
                    floid[i][j] = Math.min((floid[i][k] + floid[k][j]), floid[i][j]);
                }
            }
        }

//        for (int i = 0; i < sizeMap; i++) {
//            for (int j = 0; j < sizeMap - 1; j++) {
//                System.out.print(floid[i][j] + ", ");
//            }
//            System.out.println(floid[i][sizeMap - 1]);
//        }
        return floid;
    }

    //алгоритм поиска медиан
    public int[] Mediani(int countMedians, int[][] floid) {

        int[] medians = new int[countMedians];
        for (int i = 0; i < countMedians; i++) {
            medians[i] = i;
        }

        for (int i = countMedians; i < floid.length; i++) {
            int[] bestMedians = (int[]) medians.clone();
            int currentS = FoundS(medians, floid);
            for (int j = 0; j < countMedians; j++) {
                int currentNumber = medians[j];
                medians[j] = i;
                if (currentS > FoundS(medians, floid)) {
                    bestMedians = (int[]) medians.clone();
                    currentS = FoundS(medians, floid);
                }
                medians[j] = currentNumber;
            }
            medians = (int[]) bestMedians.clone();
        }
        return medians;
    }

    //поиск кратчайших путей от предположительных медиан до других вершин
    public int FoundS(int[] medians, int[][] floid) {

        int sum = 0;

        for (int i = 0; i < floid.length; i++) {
            int minWay = 1000000;
            for (int j = 0; j < medians.length; j++) {
                if (floid[i][medians[j]] < minWay) {
                    minWay = floid[i][medians[j]];
                    if (minWay == 0) {
                        j = medians.length;
                    }
                }
            }
            sum += minWay;
        }
        return sum;
    }

}
