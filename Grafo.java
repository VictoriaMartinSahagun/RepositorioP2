package Grafo;
import java.util.logging.*;
import java.util.ArrayList;
import java.util.List;
public class Grafo {
	private List<Integer> nodos;
	private List<Edge> arcos;
	private Logger logger;
	
	public Grafo() {
		nodos= new ArrayList<Integer>();
		arcos= new ArrayList<Edge>();
		logger = Logger.getLogger(Grafo.class.getName());
		Handler hand = new ConsoleHandler();
		hand.setLevel(Level.FINE);
		logger.addHandler(hand);
		logger.setLevel(Level.WARNING);
		Logger rootLogger = logger.getParent();
		for(Handler h : rootLogger.getHandlers()) {
			h.setLevel(Level.OFF);
		}
	}
	public void addNode(int node) {
		if(!nodos.contains(node)) {
			logger.fine("El nodo "+node+" no se encuentra en el grafo");
			nodos.add(node);
			logger.fine("El nodo "+node+" fue agregado al grafo");
		}else{
			logger.warning("El nodo "+node+" ya existe en el grafo, no puede agregarse");
		}
	}
	public void addEdge(int node1,int node2) {
		boolean encontre=false;
		int v1,v2;
		if(nodos.contains(node1)&&nodos.contains(node2)) {
			logger.fine("Los nodos "+node1+" "+node2+" se encuentran en el grafo");
			Edge nuevo = new Edge(node1,node2);
			for(Edge e : arcos) {
				v1=e.getVertice1();
				v2=e.getVertice2();
				encontre=(v1==node1 && v2==node2)||(v1==node2 && v2==node1);
				if(encontre) {
					break;
				}
			}
			if(!encontre) {
				arcos.add(nuevo);
				logger.fine("El arco fue agregado al grafo");
			}else {
				logger.warning("El arco ya existe en el grafo, no puede agregarse");
			}
		}else{
			logger.warning("Los nodos "+node1+" "+node2+" no se encuentran en el grafo, no puede agregarse un arco entre ellos");
		}
	}
	public void removeNode(int node) {
		if(nodos.contains(node)) {
			logger.fine("El nodo "+node+" se encuentra en el grafo");
			nodos.remove(node);
			logger.fine("El nodo "+node+" fue eliminado del grafo");
		}else{
			logger.warning("El nodo "+node+" no existe en el grafo, no puede eliminarse");
		}
	}
	public void removeEdge(int node1,int node2) {
		boolean encontre=false;
		int v1,v2;
		Edge eliminado=null;
		if(nodos.contains(node1) && nodos.contains(node2)) {
			logger.fine("Los nodos "+node1+" "+node2+" se encuentran en el grafo");
			for(Edge e : arcos) {
				v1=e.getVertice1();
				v2=e.getVertice2();
				encontre=(v1==node1 && v2==node2)||(v1==node2 && v2==node1);
				if(encontre) {
					eliminado=e;
					break;
				}
			}
			if(encontre) {
				arcos.remove(eliminado);
				logger.fine("El arco fue eliminado del grafo");
			}else {
				logger.warning("El arco no existe en el grafo, no puede eliminarse");
			}
		}else{
			logger.warning("Los nodos "+node1+" "+node2+" no se encuentran en el grafo, no puede eliminarse un arco entre ellos");
		}
	}
}
