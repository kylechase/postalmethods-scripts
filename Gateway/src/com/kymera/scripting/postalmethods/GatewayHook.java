package com.kymera.scripting.postalmethods;

import com.inductiveautomation.ignition.common.licensing.LicenseState;
import com.inductiveautomation.ignition.common.script.ScriptManager;
import com.inductiveautomation.ignition.gateway.model.AbstractGatewayModuleHook;
import com.inductiveautomation.ignition.gateway.model.GatewayContext;
import com.kymera.scripting.postalmethods.MailScripts;

public class GatewayHook extends AbstractGatewayModuleHook {

    @Override
    public void setup(GatewayContext gatewayContext) {

    }

    @Override
    public void startup(LicenseState licenseState) {

    }

    @Override
    public void shutdown() {

    }

    @Override
	public void initializeScriptManager(ScriptManager manager) {

		super.initializeScriptManager(manager);
        manager.addScriptModule("system.mail", new MailScripts());
	}
}
