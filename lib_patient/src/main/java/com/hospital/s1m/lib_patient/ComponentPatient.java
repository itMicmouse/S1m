package com.hospital.s1m.lib_patient;

import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.IComponent;
import com.hospital.s1m.lib_base.constants.Components;

public class ComponentPatient implements IComponent {
    @Override
    public String getName() {
        return Components.ComponentPatient;
    }

    @Override
    public boolean onCall(CC cc) {
        return false;
    }
}
