package com.kymera.scripting.postalmethods;

import com.inductiveautomation.ignition.common.script.ScriptManager;
import com.inductiveautomation.ignition.designer.model.AbstractDesignerModuleHook;
import com.kymera.scripting.postalmethods.MailScripts;

public class DesignerHook extends AbstractDesignerModuleHook {


	@Override
	public void initializeScriptManager(ScriptManager manager) {

		super.initializeScriptManager(manager);
        manager.addScriptModule("system.mail", new MailScripts());


	}
}
