package com.ll.exam;

import com.ll.exam.annotation.Controller;
import com.ll.exam.annotation.GetMapping;
import com.ll.exam.article.controller.ArticleController;
import com.ll.exam.home.controller.HomeController;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class Container {

    private static ArticleController articleController;
    private static HomeController homeController;

    static {
        articleController = (ArticleController) Ut.cls.newObj(ArticleController.class, null);
        homeController = (HomeController) Ut.cls.newObj(HomeController.class, null);
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
