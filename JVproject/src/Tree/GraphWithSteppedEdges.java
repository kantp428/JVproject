package Tree;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class GraphWithSteppedEdges extends Application {


    class Node {
        String id;
        double x, y;
        Circle circle;
        Text label;
        
        Node(String id, double x, double y) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.circle = new Circle(x, y, 20, Color.LIGHTBLUE);
            this.circle.setStroke(Color.STEELBLUE);
            this.circle.setStrokeWidth(3);
            this.label = new Text(x + 25, y + 5, id);
            
            // Event to handle click
            this.circle.setOnMouseClicked(event -> {
                System.out.println("Node clicked: " + id);
            });
        }
    }
    
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        
        // Define nodes
        Map<String, Node> nodes = new HashMap<>();
        nodes.put("A", new Node("A", 100, 100));
        nodes.put("B", new Node("B", 200, 200));
        nodes.put("C", new Node("C", 200, 100));
        nodes.put("D", new Node("D", 300, 150));
        nodes.put("E", new Node("E", 400, 150));
        
        // Add nodes to the pane
        for (Node node : nodes.values()) {
            root.getChildren().addAll(node.circle, node.label);
        }
        
        // Define stepped edges (right-angled)
        addSteppedEdge(root, nodes.get("A"), nodes.get("B"));
        addSteppedEdge(root, nodes.get("A"), nodes.get("C"));
        addSteppedEdge(root, nodes.get("B"), nodes.get("D"));
        addSteppedEdge(root, nodes.get("C"), nodes.get("D"));
        addSteppedEdge(root, nodes.get("D"), nodes.get("E"));

        // Create the scene and show the stage
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Graph with Stepped Edges");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    // Method to create stepped edges (right-angled paths)
    private void addSteppedEdge(Pane root, Node source, Node target) {
        double midX = (source.x + target.x) / 2;
        
        Path path = new Path();
        path.getElements().add(new MoveTo(source.x, source.y)); // Move to source node
        path.getElements().add(new LineTo(midX, source.y));     // Horizontal line to middle X
        path.getElements().add(new LineTo(midX, target.y));     // Vertical line to target Y
        path.getElements().add(new LineTo(target.x, target.y)); // Horizontal line to target X
        
        path.setStroke(Color.GRAY);
        path.setStrokeWidth(2);
        
        root.getChildren().add(path);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}


