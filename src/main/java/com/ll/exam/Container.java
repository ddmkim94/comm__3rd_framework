package com.ll.exam;

import com.ll.exam.annotation.Controller;
import com.ll.exam.article.controller.ArticleController;
import com.ll.exam.home.controller.HomeController;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;

public class Container {

    private static final ArticleController articleController;
    private static final HomeController homeController;

    static {
        articleController = Ut.cls.newObj(ArticleController.class, null);
        homeController = Ut.cls.newObj(HomeController.class, null);
    }

    public static ArticleController getArticleController() {
        return articleController;
    }

    public static HomeController getHomeController() {
        return homeController;
    }

    public static List<String> getControllerNames() {

        List<String> names = new ArrayList<>();

        Reflections ref = new Reflections("com.ll.exam");
        for (Class<?> cl : ref.getTypesAnnotatedWith(Controller.class)) {
            String name = cl.getSimpleName();

            char[] charArray = name.toCharArray();
            charArray[0] = Character.toLowerCase(charArray[0]);
            String simpleName = new String(charArray);

            names.add(simpleName.replace("Controller", ""));
        }

        return names;
    }
}
