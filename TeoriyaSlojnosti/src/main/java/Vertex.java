/**
 * Created by Elina.
 */
public class Vertex implements Comparable {

    //второй конец ребра
    private Integer destination;
    //вес ребра
    private int weight;

    //возврат значения веса ребра
    public int getWeight() {
        return weight;
    }

    //добавить значение ребра
    public void setWeight(int weight) {
        this.weight = weight;
    }

    //возврат второго конца ребра
    public Integer getDestination() {
        return destination;
    }

    //добавить второй конец ребра
    public void setDestination(Integer rdestination) {
        this.destination = destination;
    }

    //Конструктор
    public Vertex(Integer destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return destination.toString();
    }

    public int compareTo(Object o) {
        return toString().compareTo(o.toString());
    }
}
