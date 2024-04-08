package hi.dto2.tveirleikmenn;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.HashMap;

public class Controller {

    @FXML
    private Circle p1;
    @FXML
    private Circle p2;
    private HashMap<KeyCode, Boolean> t1 = new HashMap<>();
    private HashMap<KeyCode, Boolean> t2 = new HashMap<>();

    private Timeline timeline;

    private final double HRADI = 3;

    @FXML
    public void initialize(){
        t1 = new HashMap<>();
        t1.put(KeyCode.UP, false);
        t1.put(KeyCode.DOWN, false);
        t1.put(KeyCode.LEFT, false);
        t1.put(KeyCode.RIGHT, false);

        t2 = new HashMap<>();
        t2.put(KeyCode.W, false);
        t2.put(KeyCode.S, false);
        t2.put(KeyCode.A, false);
        t2.put(KeyCode.D, false);

        initGameLoop();
    }
    public void initControls(){
        p1.requestFocus();

        p1.getScene().setOnKeyPressed(keyEvent -> {
            if (t1.containsKey(keyEvent.getCode())){
                t1.put(keyEvent.getCode(), true);
            }
            else if (t2.containsKey(keyEvent.getCode())){
                t2.put(keyEvent.getCode(), true);
            }
        });
        p1.getScene().setOnKeyReleased(keyEvent -> {
            if (t1.containsKey(keyEvent.getCode())){
                t1.put(keyEvent.getCode(), false);
            }
            else if (t2.containsKey(keyEvent.getCode())){
                t2.put(keyEvent.getCode(), false);
            }
        });
    }

    public void initGameLoop(){
        KeyFrame k = new KeyFrame(Duration.millis(20),
                e -> {
                    gameLoop();
                });

        timeline = new Timeline(k);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void gameLoop(){
        if(t1.get(KeyCode.RIGHT)){
            p1.setCenterX(p1.getCenterX() + HRADI);
        }
        if(t1.get(KeyCode.LEFT)){
            p1.setCenterX(p1.getCenterX() - HRADI);
        }
        if(t1.get(KeyCode.UP)){
            p1.setCenterY(p1.getCenterY() - HRADI);
        }
        if(t1.get(KeyCode.DOWN)){
            p1.setCenterY(p1.getCenterY() + HRADI);
        }

        if(t2.get(KeyCode.D)){
            p2.setCenterX(p2.getCenterX() + HRADI);
        }
        if(t2.get(KeyCode.A)){
            p2.setCenterX(p2.getCenterX() - HRADI);
        }
        if(t2.get(KeyCode.W)){
            p2.setCenterY(p2.getCenterY() - HRADI);
        }
        if(t2.get(KeyCode.S)){
            p2.setCenterY(p2.getCenterY() + HRADI);
        }
    }
}