package ch.makery.address.util;

import ch.makery.address.MainApp;
import ch.makery.address.annotation.AnnotInfo;
import ch.makery.address.model.Person;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;

/**
 * Created by Michaël on 06/07/2017.
 */
@AnnotInfo(
        priority = AnnotInfo.Priority.MEDIUM,
        tags = {"interface", "module"},
        lastModified = "24/07/2017",
        comsdev = "interface permettant de serialiser l'ajout de plugin",
        name= "IModule"
)
public interface IModule {
    public void plug(Person person, BorderPane rLayout, String selectedFriendId);
    public void unplug();
    public String getName();
}
