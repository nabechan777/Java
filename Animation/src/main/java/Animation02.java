

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animation02 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();

        Circle aCircle = new Circle();
        aCircle.setRadius(15);
        aCircle.setLayoutX(100);
        aCircle.setLayoutY(100);
        aCircle.setFill(Color.AQUAMARINE);
        root.getChildren().add(aCircle);

        Scene aScene = new Scene(root, 200, 200);

        primaryStage.setScene(aScene);
        primaryStage.show();

        Timeline tl = new Timeline();
        KeyValue kv0 = new KeyValue(aCircle.radiusProperty(), 15);
        KeyFrame kf0 = new KeyFrame(Duration.ZERO, kv0);
        KeyValue kv1 = new KeyValue(aCircle.radiusProperty(), 100, Interpolator.EASE_BOTH);
        KeyFrame kf1 = new KeyFrame(Duration.millis(1000), kv1);
        KeyValue kv2 = new KeyValue(aCircle.radiusProperty(), 0, Interpolator.EASE_OUT);
        KeyFrame kf2 = new KeyFrame(Duration.millis(2000), kv2);
        KeyValue kv3 = new KeyValue(aCircle.radiusProperty(), 15, Interpolator.EASE_IN);
        KeyFrame kf3 = new KeyFrame(Duration.millis(3000), kv3);

        tl.getKeyFrames().add(kf0);
        tl.getKeyFrames().add(kf1);
        tl.getKeyFrames().add(kf2);
        tl.getKeyFrames().add(kf3);
        tl.setCycleCount(Timeline.INDEFINITE);
        tl.setAutoReverse(true);
        tl.play();
    }

    static void main(String... args){
        launch(args);
    }
}
