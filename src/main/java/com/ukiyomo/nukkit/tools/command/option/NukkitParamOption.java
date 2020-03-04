package com.ukiyomo.nukkit.tools.command.option;

import cn.nukkit.math.Vector3f;
import cn.nukkit.math.Vector3i;
import com.ukiyomo.nukkit.tools.command.converter.Vector3fParamConverter;
import com.ukiyomo.nukkit.tools.command.converter.Vector3iParamConverter;
import com.ukiyomo.tools.simpleCommand.CommandManager;
import com.ukiyomo.tools.simpleCommand.option.ParamOption;

public class NukkitParamOption {

    public final static ParamOption<Vector3f> VECTOR3F = ParamOption.valueOf("VECTOR3F", Vector3f.class);
    public final static ParamOption<Vector3i> VECTOR3I = ParamOption.valueOf("VECTOR3I", Vector3i.class);

    static {
        CommandManager.registerConverter(VECTOR3F, new Vector3fParamConverter());
        CommandManager.registerConverter(VECTOR3I, new Vector3iParamConverter());
    }

}
