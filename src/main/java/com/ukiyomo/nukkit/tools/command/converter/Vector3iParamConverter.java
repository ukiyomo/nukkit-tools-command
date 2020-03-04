package com.ukiyomo.nukkit.tools.command.converter;

import cn.nukkit.math.Vector3i;
import com.ukiyomo.tools.simpleCommand.converter.IntegerParamConverter;
import com.ukiyomo.tools.simpleCommand.converter.ParamConverter;

public class Vector3iParamConverter implements ParamConverter<Vector3i> {

    @Override
    public Vector3i execute(String param) {
        return Vector3iParamConverter.parse(param, ":");
    }

    public static Vector3i parse(String str, String split) {
        if(null == split || split.equals("") || null == str || str.equals("")) {
            return null;
        }

        String[] strings = str.split(split);
        if(strings.length != 3) {
            return null;
        }

        int[] v3 = new int[3];

        for (int i = 0; i < strings.length; i++) {
            Integer temp = IntegerParamConverter.parse(strings[i]);
            if(null == temp) {
                return null;
            }
            v3[i] = temp;
        }

        return new Vector3i(v3[0], v3[1], v3[2]);

    }
}
