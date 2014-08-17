package com.kymera.scripting.postalmethods;

import com.inductiveautomation.factorypmi.application.runtime.AbstractClientModuleHook;
import com.inductiveautomation.ignition.common.script.ScriptManager;
import com.kymera.scripting.postalmethods.MailScripts;

public class ClientHook extends AbstractClientModuleHook {

	@Override
	public void initializeScriptManager(ScriptManager manager) {

		super.initializeScriptManager(manager);

        manager.addScriptModule("system.mail", new MailScripts());
	}

}
