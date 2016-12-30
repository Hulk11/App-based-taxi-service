import java.io.*;
import java.util.*;
class Graph {
    public Map<String, Vertex> graph;
    public int rishi =0;
 
    public Graph(){
	 graph = new HashMap<String,Vertex>();
    }
 
 
    public void dijkstra(String start) {
      if (!graph.containsKey(start)) {
         System.out.print(" vertex "+start+"not present");
         return;
      }
       Vertex tmp = graph.get(start);
      NavigableSet<Vertex> q = new TreeSet<>();
 
      
      for (Vertex v : graph.values()) {
                if(v.equals(tmp)){
			    	v.previous = tmp;
			    	v.dist = 0;
			    }
				else{
					v.previous = null;
					v.dist = Integer.MAX_VALUE;
				}
         
            q.add(v);
            }
 
      shorpath(q);
    }
      public Vertex deFirst(Set<Vertex> ste){
	   Iterator<Vertex> ti = ste.iterator();
	   Vertex d1 = ti.next();
	   ste.remove(d1);
	   return d1;
       }
	   
	   
      public void addin(Set<Vertex> ster,Vertex vc){
	   Iterator<Vertex> xs = ster.iterator();
	   Vertex ad = xs.next();
	   
       }
   int otherdist=0;
  ArrayList<Integer> bat = new ArrayList<Integer>();
	public void shorpath(NavigableSet<Vertex> q) {      
      Vertex tmp1,tmp2;
      while (!q.isEmpty()) {
          tmp1 = q.pollFirst();
         if (tmp1.dist == Integer.MAX_VALUE) break;
		 for (Map.Entry<Vertex, Integer> a : tmp1.neighbours.entrySet()) {
            tmp2 = a.getKey();
		    otherdist = tmp1.dist + a.getValue();
            bat.add(tmp1.dist);
			if(otherdist<tmp2.dist){
               q.remove(tmp2);
               tmp2.previous = tmp1;
			   tmp2.dist = otherdist;
               
               q.add(tmp2);
            } 
          }
        }
      }
	
	 
      public void printPath(String fin) {
      if (!graph.containsKey(fin)) {
         System.err.printf("Vertex not present");
         return;
      }
 
      graph.get(fin).printPath();
	  
       rishi = graph.get(fin).getDist();
   }
    
      public int rahul(){
		  return rishi;
	  } 
	  
	 
   
      public void addedge(String a,String b,int i){
	     if(!graph.containsKey(a)){
		 graph.put(a, new Vertex(a));}
		 
         if(!graph.containsKey(b)){
			 graph.put(b, new Vertex(b));
		 }
       graph.get(a).neighbours.put(graph.get(b),i);
       graph.get(b).neighbours.put(graph.get(a),i);
     }
}

class ferrop{
	public static void main(String args[]){
		Graph zulmi = new Graph();
		zulmi.addedge("rahul","iit",8);
		zulmi.addedge("rahul","iim",56);
		zulmi.addedge("iim","iit",22);
		zulmi.addedge("iim","rishi",25);
	    
		zulmi.addedge("indiagate","chanakyapuri",30);
zulmi.addedge("indiagate","AIIMS",30);
zulmi.addedge("indiagate","lajpatnagar",50);
zulmi.addedge("chanakyapuri","AIIMS",20);
zulmi.addedge("AIIMS","lajpatnagar",15);
zulmi.addedge("chanakyapuri","iitmaingate",50);
zulmi.addedge("AIIMS","iitmaingate",30);
zulmi.addedge("lajpatnagar","iitmaingate",40);

	}
}

