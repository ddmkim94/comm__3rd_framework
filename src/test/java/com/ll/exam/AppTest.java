package com.ll.exam;

import com.ll.exam.article.controller.ArticleController;
import com.ll.exam.article.repository.ArticleRepository;
import com.ll.exam.article.service.ArticleService;
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
        ArticleController articleController = Container.getObj(ArticleController.class);
        assertThat(articleController).isNotNull();
    }

    @Test
    public void ioc__ArticleController__SingletonTest() {
        ArticleController articleController1 = Container.getObj(ArticleController.class);
        ArticleController articleController2 = Container.getObj(ArticleController.class);

        assertThat(articleController2).isEqualTo(articleController1);
    }

    @Test
    public void ioc__HomeController__SingletonTest() {
        HomeController homeController1 = Container.getObj(HomeController.class);
        HomeController homeController2 = Container.getObj(HomeController.class);

        assertThat(homeController2).isEqualTo(homeController1);
    }


    @Test
    public void ioc__ControllerScanTest() {
        List<String> controllerNames = Container.getControllerNames();

        assertThat(controllerNames).contains("home");
        assertThat(controllerNames).contains("article");
        assertThat(controllerNames).contains("member");
    }

    @Test
    public void ioc__articleService() {
        ArticleService articleService = Container.getObj(ArticleService.class);

        assertThat(articleService).isNotNull();
    }

    @Test
    public void ioc__articleService__싱글톤() {
        ArticleService articleService1 = Container.getObj(ArticleService.class);
        ArticleService articleService2 = Container.getObj(ArticleService.class);

        assertThat(articleService2).isEqualTo(articleService1);
    }

    @Test
    public void articleController를_생성할때_articleService도_같이_생성() {
        ArticleController articleController = Container.getObj(ArticleController.class);

        ArticleService articleService = Ut.reflection.getFieldValue(articleController, "articleService", null);

        assertThat(articleService).isNotNull();
    }

    @Test
    public void articleService를_생성할때_articleRepository도_같이_생성() {
        ArticleService articleService = Container.getObj(ArticleService.class);

        ArticleRepository articleRepository = Ut.reflection.getFieldValue(articleService, "articleRepository", null);

        assertThat(articleRepository).isNotNull();
    }
}
