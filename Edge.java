class Edge {
      public String v1, v2;
      public int dist;
      public Edge(String ver1, String ver2, int distanc) {
         v1 = ver1;
         v2 = ver2;
         dist = distanc;
      }
	  public String pdo(){
		  return v1;
	  }
	  public String ddo(){
		  return v2;
	  }
	  public int dido(){
		  return dist;
	  }
}