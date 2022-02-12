package com.example.msal4jdemo;

import com.microsoft.aad.msal4j.IAuthenticationResult;
import com.microsoft.aad.msal4j.InteractiveRequestParameters;
import com.microsoft.aad.msal4j.PublicClientApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;

public class HelloApplication extends Application {
    private String PUBLIC_CLIENT_ID = "my client id from azure";
    private String AUTHORITY = "https://login.microsoftonline.com/organizations/";
    @Override
    public void start(Stage stage) throws IOException, URISyntaxException {
        PublicClientApplication app = PublicClientApplication
                .builder(PUBLIC_CLIENT_ID)
                .logPii(true)
                .authority(AUTHORITY)
                .build();

        InteractiveRequestParameters parameters = InteractiveRequestParameters
                .builder(new URI("http://localhost"))
                .scopes(Collections.singleton("user.read"))
                .build();

        IAuthenticationResult result = app.acquireToken(parameters).join();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
