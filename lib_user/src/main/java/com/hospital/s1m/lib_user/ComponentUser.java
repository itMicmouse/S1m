package com.hospital.s1m.lib_user;

import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.CCResult;
import com.billy.cc.core.component.IComponent;
import com.hospital.s1m.lib_base.constants.Components;
import com.hospital.s1m.lib_user.applogic.ApplogicUser;

/**
 * 配置组件 组件名称 Components.ComponentUser(lib_user)
 */
public class ComponentUser implements IComponent {
    @Override
    public String getName() {
        return Components.ComponentUser;
    }

    @Override
    public boolean onCall(CC cc) {
        String actionName = cc.getActionName();
        switch (actionName) {
            case "getApplogic":
                CC.sendCCResult(cc.getCallId(), CCResult.success("getApplogic",new ApplogicUser()).addData("key","22222"));
                break;
            default:
        }
        return true;
    }
}
