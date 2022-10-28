package com.monochrome.darklaunch;

/**
 * @author monochrome
 * @date 2022/10/28
 */
public class UserPromotionDarkFeature implements IDarkFeature {
    @Override
    public boolean enabled() {
        return true;
    }

    @Override
    public boolean dark(long darkTarget) {
        return false;
    }

    @Override
    public boolean dark(String darkTarget) {
        return false;
    }
}
