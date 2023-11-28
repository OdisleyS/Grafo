import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Grafo {

    List<Vertice> vertices;

    public Grafo() {
        this.vertices = new ArrayList<>();
    }

    public void adicionarVertice(Vertice vertice) {
        vertices.add(vertice);
    }

    public void adicionarAresta(Vertice origem, Vertice destino, int peso) {
        Aresta aresta = new Aresta(origem, destino, peso);
        origem.arestas.add(aresta);
    }

    public List<Vertice> encontrarMenorCaminho(Vertice origem, Vertice destino) {
        origem.distancia = 0;
        PriorityQueue<Vertice> filaPrioridade = new PriorityQueue<>();
        filaPrioridade.add(origem);

        while (!filaPrioridade.isEmpty()) {
            Vertice verticeAtual = filaPrioridade.poll();

            for (Aresta aresta : verticeAtual.arestas) {
                Vertice v = aresta.destino;
                int pesoTotal = verticeAtual.distancia + aresta.peso;

                if (pesoTotal < v.distancia) {
                    filaPrioridade.remove(v);
                    v.distancia = pesoTotal;
                    v.anterior = verticeAtual;
                    filaPrioridade.add(v);
                }
            }
        }

        List<Vertice> caminho = new ArrayList<>();
        for (Vertice v = destino; v != null; v = v.anterior) {
            caminho.add(v);
        }
        Collections.reverse(caminho);
        return caminho;
    }

}
