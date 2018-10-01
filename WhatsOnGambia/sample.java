package WhatsOnGambia;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;


public class sample extends StackPane {

    private final Label label;

    public sample(){
        label = new Label();
        getChildren().add(label);
    }

    public void setLabel(String text){
        label.setText(text);
    }

}
