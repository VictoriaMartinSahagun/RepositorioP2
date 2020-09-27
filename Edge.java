package Grafo;

public class Edge {
	private int v1,v2;
	public Edge(int p, int s) {
		v1=p;
		v2=s;
	}
	public void setVertice1(int v) {
		v1=v;
	}
	public void setVertice2(int v) {
		v2=v;
	}
	public int getVertice1() {
		return v1;
	}
	public int getVertice2() {
		return v2;
	}
}
