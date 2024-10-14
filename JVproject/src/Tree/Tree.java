package Tree;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class Tree extends Application {
	
	private void addSteppedEdge(Pane root, Node source, Node target) {
        double midX = (source.x + target.x) / 2;
        
        Path path = new Path();
        path.getElements().add(new MoveTo(source.x, source.y)); // Move to source node
        path.getElements().add(new LineTo(midX, source.y));     // Horizontal line to middle X
        path.getElements().add(new LineTo(midX, target.x));     // Horizontal line to middle X
        
        //path.getElements().add(new LineTo(target.x, target.y));     // Vertical line to target Y
        //path.getElements().add(new LineTo(target.x, target.y)); // Horizontal line to target X
        
        path.setStroke(Color.RED);
        path.setStrokeWidth(2);
        
        root.getChildren().add(path);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane root = new Pane();
        
        // Define nodes

        Map<String, Node> nodes = new HashMap<>();
        
        Node z = new Node("Z",1,100);
        
        	nodes.put("MATH I", new Node("MATH I",1,100));
            nodes.put("Physics I", new Node("Physics I",1,200));
            nodes.put("Structure", new Node("Structure",1,300));
            nodes.put("MATH II", new Node("MATH II",1.5,100));
            nodes.put("Physics II", new Node("Physics II",1.5,200));
            nodes.put("Digital", new Node("Digital",1.5,300));
            nodes.put("Linux", new Node("Linux",1.5,400));
            nodes.put("Make", new Node("Make",1.5,500));
        
        
        // Add nodes to the paneS
        for (Node node : nodes.values()) {
            root.getChildren().addAll(node.square, node.label);
        }
        
        // Define stepped edges (right-angled)
        addSteppedEdge(root, nodes.get("MATH I"), nodes.get("MATH II"));
        addSteppedEdge(root, nodes.get("Physics I"), nodes.get("Physics II"));
        addSteppedEdge(root, nodes.get("MATH I"), nodes.get("Physics II"));
        addSteppedEdge(root, nodes.get("Structure"), nodes.get("Linux"));
        addSteppedEdge(root, nodes.get("Structure"), nodes.get("Make"));
        


        // Create the scene and show the stage
        Scene scene = new Scene(root, 800, 450);
        primaryStage.setTitle("Project Subject List");
        primaryStage.setScene(scene);
        primaryStage.show();
	}

}
