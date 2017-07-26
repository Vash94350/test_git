package ch.makery.address.modules;

import ch.makery.address.annotation.AnnotInfo;
import ch.makery.address.model.Person;
import ch.makery.address.util.IModule;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;

@AnnotInfo(
        priority = AnnotInfo.Priority.LOW,
        tags = {"implementation", "interface", "IModule"},
        lastModified = "25/07/2017",
        comsdev = "Transition chargement pluginoverview",
        name= "SimpleModule"
)
public class SimpleModule implements IModule {
    @Override
    public void plug(Person person, BorderPane rLayout, String selectedFriendId) {
        PluginOverviewControler.getInstance().showPluginOverview(rLayout,person, selectedFriendId);
    }

    @Override
    public void unplug() {
        System.out.println("unplug");
    }

    @Override
    public String getName() {
        return "SocialNetwork Module";
    }
}
