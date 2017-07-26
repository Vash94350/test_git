package ch.makery.address.annotation;

import ch.makery.address.managers.LoginManager;
import ch.makery.address.managers.MusicManager;
import ch.makery.address.model.Login;
import ch.makery.address.model.Music;
import ch.makery.address.model.Person;
import ch.makery.address.util.DateUtil;
import ch.makery.address.util.ModuleLoader;
import ch.makery.address.view.LoginOverviewController;
import ch.makery.address.view.MusiqueOverviewController;

import java.lang.annotation.Annotation;

/**
 * Created by chris on 11/07/2017.
 */

public class RunAnnot {
    public void PrintAnnot() {
        System.out.println("Annotations:");

        int passed = 0, failed = 0, count = 0, ignore = 0, i = 1;
        Class<LoginManager> obj = LoginManager.class;
        Class<MusicManager> obj1 = MusicManager.class;
        Class<Login> obj2 = Login.class;
        Class<Music> obj3 = Music.class;
        Class<Person>obj4 = Person.class;
        Class<DateUtil>obj7 = DateUtil.class;
        Class<ModuleLoader>obj8 = ModuleLoader.class;
        Class<LoginOverviewController>obj9 = LoginOverviewController.class;
        Class<MusiqueOverviewController>obj10 = MusiqueOverviewController.class;

        if (obj.isAnnotationPresent(AnnotInfo.class)) {
            Annotation annotation = obj.getAnnotation(AnnotInfo.class);
            AnnotInfo testerInfo = (AnnotInfo) annotation;

            System.out.printf("%nClass :%s", testerInfo.name());
            System.out.printf("%nPriority :%s", testerInfo.priority());
            System.out.printf("%nCreatedBy :%s", testerInfo.createdBy());

            System.out.printf("%nTags :");
            int tagLength = testerInfo.tags().length;
            for (String tag : testerInfo.tags()) {
                if (tagLength > 1) {
                    System.out.print(tag + ", ");
                } else {
                    System.out.print(tag);
                }
                tagLength--;
            }

            System.out.printf("%ncomsdev:%s", testerInfo.comsdev());
            System.out.printf("%nLastModified :%s%n%n", testerInfo.lastModified());

        }




        if (obj1.isAnnotationPresent(AnnotInfo.class)) {
            Annotation annotation = obj1.getAnnotation(AnnotInfo.class);
            AnnotInfo testerInfo = (AnnotInfo) annotation;

            System.out.printf("%nClass :%s", testerInfo.name());
            System.out.printf("%nPriority :%s", testerInfo.priority());
            System.out.printf("%nCreatedBy :%s", testerInfo.createdBy());

            System.out.printf("%nTags :");
            int tagLength = testerInfo.tags().length;
            for (String tag : testerInfo.tags()) {
                if (tagLength > 1) {
                    System.out.print(tag + ", ");
                } else {
                    System.out.print(tag);
                }
                tagLength--;
            }

            System.out.printf("%ncomsdev:%s", testerInfo.comsdev());
            System.out.printf("%nLastModified :%s%n%n", testerInfo.lastModified());

        }

        if (obj2.isAnnotationPresent(AnnotInfo.class)) {
            Annotation annotation = obj2.getAnnotation(AnnotInfo.class);
            AnnotInfo testerInfo = (AnnotInfo) annotation;

            System.out.printf("%nClass :%s", testerInfo.name());
            System.out.printf("%nPriority :%s", testerInfo.priority());
            System.out.printf("%nCreatedBy :%s", testerInfo.createdBy());

            System.out.printf("%nTags :");
            int tagLength = testerInfo.tags().length;
            for (String tag : testerInfo.tags()) {
                if (tagLength > 1) {
                    System.out.print(tag + ", ");
                } else {
                    System.out.print(tag);
                }
                tagLength--;
            }

            System.out.printf("%ncomsdev:%s", testerInfo.comsdev());
            System.out.printf("%nLastModified :%s%n%n", testerInfo.lastModified());

        }

        if (obj3.isAnnotationPresent(AnnotInfo.class)) {
            Annotation annotation = obj3.getAnnotation(AnnotInfo.class);
            AnnotInfo testerInfo = (AnnotInfo) annotation;

            System.out.printf("%nClass :%s", testerInfo.name());
            System.out.printf("%nPriority :%s", testerInfo.priority());
            System.out.printf("%nCreatedBy :%s", testerInfo.createdBy());

            System.out.printf("%nTags :");
            int tagLength = testerInfo.tags().length;
            for (String tag : testerInfo.tags()) {
                if (tagLength > 1) {
                    System.out.print(tag + ", ");
                } else {
                    System.out.print(tag);
                }
                tagLength--;
            }

            System.out.printf("%ncomsdev:%s", testerInfo.comsdev());
            System.out.printf("%nLastModified :%s%n%n", testerInfo.lastModified());

        }

        if (obj4.isAnnotationPresent(AnnotInfo.class)) {
            Annotation annotation = obj4.getAnnotation(AnnotInfo.class);
            AnnotInfo testerInfo = (AnnotInfo) annotation;

            System.out.printf("%nClass :%s", testerInfo.name());
            System.out.printf("%nPriority :%s", testerInfo.priority());
            System.out.printf("%nCreatedBy :%s", testerInfo.createdBy());

            System.out.printf("%nTags :");
            int tagLength = testerInfo.tags().length;
            for (String tag : testerInfo.tags()) {
                if (tagLength > 1) {
                    System.out.print(tag + ", ");
                } else {
                    System.out.print(tag);
                }
                tagLength--;
            }

            System.out.printf("%ncomsdev:%s", testerInfo.comsdev());
            System.out.printf("%nLastModified :%s%n%n", testerInfo.lastModified());

        }




        if (obj7.isAnnotationPresent(AnnotInfo.class)) {
            Annotation annotation = obj7.getAnnotation(AnnotInfo.class);
            AnnotInfo testerInfo = (AnnotInfo) annotation;

            System.out.printf("%nClass :%s", testerInfo.name());
            System.out.printf("%nPriority :%s", testerInfo.priority());
            System.out.printf("%nCreatedBy :%s", testerInfo.createdBy());

            System.out.printf("%nTags :");
            int tagLength = testerInfo.tags().length;
            for (String tag : testerInfo.tags()) {
                if (tagLength > 1) {
                    System.out.print(tag + ", ");
                } else {
                    System.out.print(tag);
                }
                tagLength--;
            }

            System.out.printf("%ncomsdev:%s", testerInfo.comsdev());
            System.out.printf("%nLastModified :%s%n%n", testerInfo.lastModified());

        }

        if (obj8.isAnnotationPresent(AnnotInfo.class)) {
            Annotation annotation = obj8.getAnnotation(AnnotInfo.class);
            AnnotInfo testerInfo = (AnnotInfo) annotation;

            System.out.printf("%nClass :%s", testerInfo.name());
            System.out.printf("%nPriority :%s", testerInfo.priority());
            System.out.printf("%nCreatedBy :%s", testerInfo.createdBy());

            System.out.printf("%nTags :");
            int tagLength = testerInfo.tags().length;
            for (String tag : testerInfo.tags()) {
                if (tagLength > 1) {
                    System.out.print(tag + ", ");
                } else {
                    System.out.print(tag);
                }
                tagLength--;
            }

            System.out.printf("%ncomsdev:%s", testerInfo.comsdev());
            System.out.printf("%nLastModified :%s%n%n", testerInfo.lastModified());

        }

        if (obj9.isAnnotationPresent(AnnotInfo.class)) {
            Annotation annotation = obj9.getAnnotation(AnnotInfo.class);
            AnnotInfo testerInfo = (AnnotInfo) annotation;

            System.out.printf("%nClass :%s", testerInfo.name());
            System.out.printf("%nPriority :%s", testerInfo.priority());
            System.out.printf("%nCreatedBy :%s", testerInfo.createdBy());

            System.out.printf("%nTags :");
            int tagLength = testerInfo.tags().length;
            for (String tag : testerInfo.tags()) {
                if (tagLength > 1) {
                    System.out.print(tag + ", ");
                } else {
                    System.out.print(tag);
                }
                tagLength--;
            }

            System.out.printf("%ncomsdev:%s", testerInfo.comsdev());
            System.out.printf("%nLastModified :%s%n%n", testerInfo.lastModified());

        }

        if (obj10.isAnnotationPresent(AnnotInfo.class)) {
            Annotation annotation = obj10.getAnnotation(AnnotInfo.class);
            AnnotInfo testerInfo = (AnnotInfo) annotation;

            System.out.printf("%nClass :%s", testerInfo.name());
            System.out.printf("%nPriority :%s", testerInfo.priority());
            System.out.printf("%nCreatedBy :%s", testerInfo.createdBy());

            System.out.printf("%nTags :");
            int tagLength = testerInfo.tags().length;
            for (String tag : testerInfo.tags()) {
                if (tagLength > 1) {
                    System.out.print(tag + ", ");
                } else {
                    System.out.print(tag);
                }
                tagLength--;
            }

            System.out.printf("%ncomsdev:%s", testerInfo.comsdev());
            System.out.printf("%nLastModified :%s%n%n", testerInfo.lastModified());

        }
    }
}
