package com.ll.exam;

import com.ll.exam.article.controller.ArticleController;
import com.ll.exam.home.controller.HomeController;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

    @Test
    void sumTest() throws Exception {
        int result = 10 + 20;
        assertThat(result).isEqualTo(30);
    }

    @Test
    void ioc__ArticleControllerTest() throws Exception {
        ArticleController articleController = (ArticleController) Container.getObj(ArticleController.class);
        assertThat(articleController).isNotNull();
    }

    @Test
    public void ioc__ArticleController__SingletonTest() {
        ArticleController articleController1 = (ArticleController) Container.getObj(ArticleController.class);
        ArticleController articleController2 = (ArticleController) Container.getObj(ArticleController.class);

        assertThat(articleController2).isEqualTo(articleController1);
    }

    @Test
    public void ioc__HomeController__SingletonTest() {
        HomeController homeController1 = (HomeController) Container.getObj(HomeController.class);
        HomeController homeController2 = (HomeController) Container.getObj(HomeController.class);

        assertThat(homeController2).isEqualTo(homeController1);
    }


    @Test
    public void ioc__ControllerScanTest() {
        List<String> controllerNames = Container.getControllerNames();

        assertThat(controllerNames).contains("home");
        assertThat(controllerNames).contains("article");
        assertThat(controllerNames).contains("member");
    }
}
