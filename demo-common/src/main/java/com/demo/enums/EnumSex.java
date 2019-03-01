package com.demo.enums;

import com.geekplus.optimus.tool.i18n.Lang;

public enum EnumSex {
    male(0, Lang.msg("lang.venus.divice.common.sex.male")),
    female(1, Lang.msg("lang.venus.divice.common.sex.female"));

    private int value;
    private String key;

    private EnumSex(int value, String key) {
        this.value = value;
        this.key = key;
    }
}
