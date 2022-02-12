module com.example.msal4jdemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.httpserver;
    requires msal4j;


    opens com.example.msal4jdemo to javafx.fxml;
    exports com.example.msal4jdemo;
}