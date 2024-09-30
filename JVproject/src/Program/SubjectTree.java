package Program;

import java.util.*;

public class SubjectTree{
	private String id;	
	private ArrayList<String> child = new ArrayList<String>();
	private ArrayList<String> parent = new ArrayList<String>();
	
	public void addChild(String c) {
		child.add(c);
	}
	public void addParent(String c) {
		parent.add(c);
	}
	public ArrayList<String> getChild() {
		return child;
	}
	public ArrayList<String> getParent() {
		return parent;
	}
	
	public SubjectTree(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
}
