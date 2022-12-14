package javagent;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.List;

import org.apache.commons.io.input.SwappedDataInputStream;

import javassist.* ;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.bytecode.AttributeInfo;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.ClassFile;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.FieldInfo;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.Mnemonic;
import javassist.bytecode.Opcode;
import javassist.tools.Dump;

public class JavaAssistTransformer implements ClassFileTransformer {
    public byte[] transform(ClassLoader loader, String str,
        Class<?> className, ProtectionDomain protectionDomain,
        byte[] bytes) throws IllegalClassFormatException 
    {
    	
    	//byte[] byteCode = bytes;
    	
    	String targetClassName = str.replaceAll("\\.", "/");  
    	String arr[] = targetClassName.split("/");
    	String mainClassName = null ;
    	
    	for(int i=0;i<arr.length;i++) 
    	{
    		if(arr[i].equals("testingapp")) 
    		{
    			mainClassName = arr[i]+"."+arr[i+1];
    		}
    	}
    	
    	
    	if(mainClassName != null) 
    	{
        		
        		System.out.println("Class Name" +mainClassName); 
        		
        		ClassPool cp = ClassPool.getDefault();
        		
        		try {
					CtClass ctClass = cp.get(mainClassName);
					
					
					for (CtMethod method : ctClass.getDeclaredMethods()) 
					{
					
						System.out.println("Class name : " +mainClassName +" & Method name : "+ method.getName());
						
						MethodInfo methodInfo = method.getMethodInfo();
						
						System.out.println("methodInfo :: " +methodInfo) ;
						
						CodeAttribute codeAttribute = methodInfo.getCodeAttribute() ;
						
						
						
						for (CodeIterator ci = codeAttribute.iterator() ;ci.hasNext();) {
						    int index = ci.next();
						    int op = ci.byteAt(index);

						    System.out.println(op + "=" + Mnemonic.OPCODE[op] + ": " + methodInfo.getLineNumber(index));
						    
						}
												
						
					}
					
				} 
        		catch (NotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BadBytecode e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
        		
        		
        		
        		
    	}
        
        return bytes ;
    }
 }
