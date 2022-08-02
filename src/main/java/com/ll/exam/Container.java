package com.ll.exam;

import com.ll.exam.annotation.Controller;
import com.ll.exam.annotation.GetMapping;
import com.ll.exam.article.controller.ArticleController;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Container {

    private static final ArticleController articleController;

    static {
        articleController = new ArticleController();
    }

    public static ArticleController getArticleController() {
        return articleController;
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
