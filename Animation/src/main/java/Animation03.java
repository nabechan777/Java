/*
 * AnimationTimerのサンプル
 */
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Animation03 extends Application {
    public static void main(String... args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();

        Text aText = new Text("あめんぼ赤いなアイウエオ\n柿の木、栗の木、カキクケコ");
        aText.setLayoutX(20);
        aText.setLayoutY(100);
        root.getChildren().add(aText);

        TextAnimation ta = new TextAnimation(aText, 200);

        Button aButton = new Button("テキストアニメーション開始");
        aButton.setPrefSize(200, 40);
        aButton.setLayoutX(20);
        aButton.setLayoutY(0);
        root.getChildren().add(aButton);

        aButton.addEventHandler(ActionEvent.ACTION, e -> ta.start());

        Scene aScene = new Scene(root, 240, 150);

        primaryStage.setScene(aScene);
        primaryStage.show();
    }

    private class TextAnimation extends AnimationTimer {
        private Text node = null;
        private String str = null;
        private long duration = 1;
        private long startTime = 0;

        public TextAnimation(Text node, long millisSec){
            this.node = node;
            this.str = node.getText();
            this.duration = millisSec * 1000000L;
            this.node.setText("");
        }

        @Override
        public void handle(long t){
            if(startTime == 0){
                startTime = t;
                this.node.setText("");
            }

            if(node.getText().length() < str.length()){
                int count = (int)((t - startTime) / duration);
                if(count > str.length() + 1){
                    count = str.length() + 1;
                }
                if(count > 0){
                    node.setText(str.substring(0, count - 1));
                }
            }else{
                startTime = 0;
                stop();
            }
        }

    }
}
