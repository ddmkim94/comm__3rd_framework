package com.ll.exam;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    void sumTest() throws Exception {
        int result = 10 + 20;
        assertThat(result).isEqualTo(30);
    }
}
