package lk.com.foodOrdering.setUI;

import javafx.event.Event;
import javafx.scene.layout.AnchorPane;

public interface SuperSetUI {
    public void setUI(Event event, String location)throws Exception;
    public void setFxml(AnchorPane pane,String location)throws Exception;
}
