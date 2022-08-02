package com.ll.exam;

import com.ll.exam.article.controller.ArticleController;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

    @Test
    void sumTest() throws Exception {
        int result = 10 + 20;
        assertThat(result).isEqualTo(30);
    }

    @Test
    void ioc__ArticleControllerTest() throws Exception {
        ArticleController articleController = Container.getArticleController();
        assertThat(articleController).isNotNull();
    }

    @Test
    public void ioc__ArticleController__SingletonTest() {
        ArticleController articleController1 = Container.getArticleController();
        ArticleController articleController2 = Container.getArticleController();

        assertThat(articleController2).isEqualTo(articleController1);
    }
}
