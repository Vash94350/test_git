package ch.makery.address.util;

import ch.makery.address.MainApp;
import ch.makery.address.model.Person;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;

/**
 * Created by Michaël on 06/07/2017.
 */
public interface IModule {
    public void plug(ChoiceBox<String> friends, MainApp mainApp, Person person, BorderPane rLayout);
    public void unplug(ChoiceBox<String> friends);
    public String getName();
}
