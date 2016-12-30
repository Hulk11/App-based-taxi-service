import java.util.*;
class Taxi{
	public int tcon = 0;
	public jagah pos;
	public String tname;
	public int availafter;
	
	
	public Taxi(String name,jagah v){
		pos = v;
		tcon = 0;
		availafter = 0;
	    tname = name;
    }
	
	public String givName(){
		return tname;
	}
	
	public int gtime(){
		return availafter;
	}
	public int state(){
		return tcon;
	}
	public jagah taxiPosition(){
	    return pos;	
	}
}