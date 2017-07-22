package ch.makery.address.modules;

import ch.makery.address.MainApp;
import ch.makery.address.model.Person;
import ch.makery.address.util.IModule;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;


/**
 * Module d'exemple tout simple.
 *
 * @author Baptiste Wicht
 */
public class SimpleModule implements IModule {

    @Override
    public void plug(ChoiceBox<String> friends, MainApp mainApp, Person person, BorderPane rLayout) {
        System.out.println("plug2");
        friends.setVisible(true);
        PluginOverviewControler pOC=new PluginOverviewControler();
        System.out.println(rLayout.toString());
        pOC.showMusiqueOverview(rLayout);
    }

    @Override
    public void unplug(ChoiceBox<String> friends) {
        System.out.println("unplug");
        friends.setVisible(false);
    }

    @Override
    public String getName() {
        return "Module super simple";
    }
}
