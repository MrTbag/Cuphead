module Cuphead {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires com.google.gson;

    opens Cuphead to javafx.fxml;
    exports Cuphead;

    opens Cuphead.View to javafx.fxml;
    exports Cuphead.View;

    opens Cuphead.Controller to com.google.gson;
    exports Cuphead.Controller;

    opens Cuphead.Model to com.google.gson;
    exports Cuphead.Model;

}