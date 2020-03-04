package com.ukiyomo.nukkit.tools.command.converter;

import cn.nukkit.math.Vector3f;
import com.ukiyomo.tools.simpleCommand.converter.DoubleParamConverter;
import com.ukiyomo.tools.simpleCommand.converter.ParamConverter;

public class Vector3fParamConverter implements ParamConverter<Vector3f> {

    @Override
    public Vector3f execute(String param) {
        return Vector3fParamConverter.parse(param, ":");
    }

    public static Vector3f parse(String str, String split) {
        if(null == split || split.equals("") || null == str || str.equals("")) {
            return null;
        }

        String[] strings = str.split(split);
        if(strings.length != 3) {
            return null;
        }

        double[] v3 = new double[3];

        for (int i = 0; i < strings.length; i++) {
            Double temp = DoubleParamConverter.parse(strings[i]);
            if(null == temp) {
                return null;
            }
            v3[i] = temp;
        }

        return new Vector3f(v3[0], v3[1], v3[2]);

    }
}
