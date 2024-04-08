module hi.dto2.tveirleikmenn {
    requires javafx.controls;
    requires javafx.fxml;


    opens hi.dto2.tveirleikmenn to javafx.fxml;
    exports hi.dto2.tveirleikmenn;
}