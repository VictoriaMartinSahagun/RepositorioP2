package Grafo;

public class PruebaLogger {
	public static void main (String arg[]) {
		Grafo g1 = new Grafo();	
		//agrego los nodos 1,2,3,4 al grafo
		for(int i=1;i<5;i++) {
			g1.addNode(i);
		}
		//agrego tres arcos con nodos pertenecientes al grafo
		g1.addEdge(1,2);
		g1.addEdge(2,3);
		g1.addEdge(3,4);
		//agrego un arco con un nodo no perteneciente al grafo
		g1.addEdge(4,5);
		//elimino un nodo perteneciente al grafo
		g1.removeNode(1);
		//elimino un nodo no perteneciente al grafo
		g1.removeNode(6);
		//elimino un arco perteneciente al grafo con un nodo no perteneciente
		g1.removeEdge(1,2);
		//eliminoi un arco perteneciente al grado con nodos pertenecientes
		g1.removeEdge(3,4);
		//elimino un arco no perteneciente al grafo
		g1.removeEdge(4,5);
	}
}
