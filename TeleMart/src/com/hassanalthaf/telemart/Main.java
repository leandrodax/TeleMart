/*
 * Program developed by Hassan Althaf.
 * Copyright © 2015, Hassan Althaf.
 * Website: http://hassanalthaf.com
 */
package com.hassanalthaf.telemart;

import com.hassanalthaf.telemart.viewmodels.MainViewModel;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author hassan
 */
public class Main extends Application {
    
    public static final String APPLICATION_TITLE = "TeleMart - ERP System";
    private Parent root;
    private Image favicon;
    private MainViewModel mainViewModel;

    @Override
    public void init() throws Exception {
        notifyPreloader(new Preloader.ProgressNotification(0));
        this.root = FXMLLoader.load(getClass().getResource("/com/hassanalthaf/telemart/views/MainView.fxml"));
        notifyPreloader(new Preloader.ProgressNotification(0));
        this.favicon = new Image("/com/hassanalthaf/telemart/views/images/icon.png");
        notifyPreloader(new Preloader.ProgressNotification(0));
        DatabaseDriver.getInstance();
        notifyPreloader(new Preloader.ProgressNotification(0));
        Thread.sleep(250);
        super.init();
    }
      
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(this.root);
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(this.favicon);
        stage.setTitle(Main.APPLICATION_TITLE);
        stage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
