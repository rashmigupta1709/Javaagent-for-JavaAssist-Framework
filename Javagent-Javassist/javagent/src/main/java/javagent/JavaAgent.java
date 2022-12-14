package javagent;

import java.lang.instrument.Instrumentation;

public class JavaAgent {
	
	public static void premain(String agentArgs, Instrumentation inst) {

        System.out.println("Starting Java Agent ");
        inst.addTransformer(new JavaAssistTransformer());
        
    }
}
