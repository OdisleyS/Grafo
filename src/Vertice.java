import java.util.ArrayList;
import java.util.List;

public class Vertice implements Comparable<Vertice> {

    String nome;
    List<Aresta> arestas;
    int distancia;
    Vertice anterior;

    public Vertice(String nome) {
        this.nome = nome;
        this.arestas = new ArrayList<>();
        this.distancia = Integer.MAX_VALUE;
        this.anterior = null;
    }

    @Override
    public int compareTo(Vertice outro) {
        return Integer.compare(this.distancia, outro.distancia);
    }
}
