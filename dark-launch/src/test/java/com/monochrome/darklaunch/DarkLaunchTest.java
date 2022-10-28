package com.monochrome.darklaunch;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author monochrome
 * @date 2022/10/28
 */
class DarkLaunchTest {

    DarkLaunch darkLaunch;

    @BeforeEach
    void setUp() {
        darkLaunch = new DarkLaunch();
    }

    @Test
    void getDarkFeature() {
        DarkFeature darkFeature = darkLaunch.getDarkFeature("call_newapi_getUserById");
        boolean dark = darkFeature.dark(893);
        assertThat(dark).isTrue();
        boolean dark1 = darkFeature.dark(894);
        assertThat(dark1).isFalse();
        boolean dark2 = darkFeature.dark(1021);
        assertThat(dark2).isTrue();

    }
}