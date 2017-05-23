/**
 * Created by Elina.
 */
public class Main {

    //МетодЮ генериирующий случайный граф
    public static UndirectedGraph Generator(int vertexes, int edges, int weight) {

        //проверка, существует ли такой граф
        if (vertexes * (vertexes - 1) / 2 < edges) {
            System.out.println("слишком много ребер");
            return null;
        }

        //объявление нового графа
        UndirectedGraph undirectedGraph = new UndirectedGraph();

        //объявление вершин нового ребра
        int vertex1;
        int vertex2;

        //добавление всех вершин в граф
        for (int i = 0; i < vertexes; i++) {
            undirectedGraph.addVertex(i);
        }

        //заполнение графа ребрами
        for (int i = 0; i < edges; i++) {

            //случайный выбор вершин
            vertex1 = RandomVertex(vertexes);
            vertex2 = RandomVertex(vertexes);

            //проверка на петли и кратные ребра
            while (vertex1 == vertex2 || undirectedGraph.hasEdgeWithoutWight(vertex1, vertex2)) {
                vertex1 = RandomVertex(vertexes);
                vertex2 = RandomVertex(vertexes);
            }

            //добавление ребра в граф
            undirectedGraph.addEdge(vertex1, vertex2, RandomVertex(weight));


        }

        //возвращение готового графа
        return undirectedGraph;
    }

    //случайный выбор вершин
    public static int RandomVertex(int vertexes) {
        return (int) (Math.random() * vertexes);
    }

    //главный метод
    public static void main(String[] args) {

        //создание объекта алгоритма
        Algorithm algorithm = new Algorithm();
        //генерация графа
        UndirectedGraph undirectedGraph = Generator(1000, 999, 100);
        //отступ
        System.out.println();
        //создание матрицы кратчайших путей по методу Флойда
        int[][] floid = algorithm.DoFloid(undirectedGraph.getVertexMap());
        //засечение времени работы алгоритма поиска медиан
        long start = System.nanoTime();
        //вызов метода поиска медин в графе
        int[] mediani = algorithm.Mediani(3, floid);
        //засечение окончания работы алгоритма
        long finish = System.nanoTime();
        //подсчет времени выполнения работы в наносекундах
        long timeOfWork = finish - start;
        //вывод времени
        System.out.println("Время в наносекундах: " + timeOfWork);
        //вывод вершин, являющимися медианами
        for (int i = 0; i < mediani.length; i++) {
            System.out.print(mediani[i] + ", ");
        }
    }
}
