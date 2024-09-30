package Program;

import java.io.*;
import java.util.*;

public class CsvReader {
	public static void main(String[] args) {
		ArrayList<SubjectTree> subject = new ArrayList<SubjectTree>();
		String file = "src\\test.csv";
		BufferedReader reader = null;
		String line = "";

		try {
			reader = new BufferedReader(new FileReader(file));
			for(int cLine=0; (line = reader.readLine()) != null; cLine++) {
				String row[] = line.split(",");
				for(int columnIndex=0; columnIndex<row.length; columnIndex++) {
					for(String subCol : row[columnIndex].split("_")) {
						if(subCol.equals("-")) continue;
						switch(columnIndex) {
							case 0:
								subject.add(new SubjectTree(subCol));
								break;
							case 1:
								subject.get(cLine).addChild(subCol);
								break;
							case 2:
								subject.get(cLine).addParent(subCol);
								break;			
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	    	try {
				reader.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		
		for(SubjectTree node : subject) {
			System.out.println(node.getId());
			System.out.print("Child-> ");
			if(node.getChild().isEmpty()) {
				System.out.println("no child");
			}else {
				Iterator<String> i = node.getChild().iterator();
				while(i.hasNext()) {
					System.out.print(i.next());
					if(i.hasNext()) System.out.print(",");
					else System.out.println();
				}
			}
			System.out.print("Parent-> ");		
			if(node.getParent().isEmpty()) {
				System.out.println("no parent");
			}else {
				Iterator<String> i = node.getParent().iterator();
				while(i.hasNext()) {
					System.out.print(i.next());
					if(i.hasNext()) System.out.print(",");
					else System.out.println();
				}
			}
		}
		
		
	}
}
