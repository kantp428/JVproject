package Tree;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Node {
	
	String id;
    double x, y;
    double year;
    Rectangle square;  // Changed from Circle to Rectangle
    Text label;
    
    Node(String id,double year,double h) {
        this.id = id;
        double set=0;
        
        if(year==1) {
        	set=100;
        	this.x = set;
	        this.y = h;
        }
        if(year==1.5) {
        	set=250;
        	this.x = set;
	        this.y = h;	
        }

        this.year = year;
        this.square = new Rectangle(x-40, y-22.5, 80, 45);  // Square with width and height of 40
        this.square.setFill(Color.LIGHTGREEN);
        this.square.setStroke(Color.SEAGREEN);
        this.square.setStrokeWidth(3);
        this.label = new Text(x-20, y+35, id);
        
        // Event to handle click
        this.square.setOnMouseClicked(event -> {
            System.out.println("Node clicked: " + id);
        });
    }
	
}
