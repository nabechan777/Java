/*
 * PathTransitionのサンプル
 */

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animation01 extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();

        Circle aCircle = new Circle(100);
        aCircle.setFill(null);
        aCircle.setStroke(Color.BLUE);
        aCircle.setLayoutX(200);
        aCircle.setLayoutY(200);
        aCircle.setOpacity(0.5);
        root.getChildren().add(aCircle);

        Circle redCircle = new Circle(5);
        redCircle.setFill(Color.RED);
        redCircle.setStroke(Color.WHITE);
        root.getChildren().add(redCircle);

        PathTransition pt = new PathTransition();
        pt.setNode(redCircle);
        pt.setDuration(Duration.millis(5000));
        pt.setPath(aCircle);
        pt.setInterpolator(Interpolator.LINEAR);
        pt.setCycleCount(PathTransition.INDEFINITE);

        Scene aScene = new Scene(root, 400, 400);

        primaryStage.setScene(aScene);
        primaryStage.show();

        pt.play();
    }

    public static void main(String... args){
        launch(args);
    }
}
