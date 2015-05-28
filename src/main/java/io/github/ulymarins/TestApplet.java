package io.github.ulymarins;

import java.applet.Applet;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 *
 * @author Ulysses Marins <marins.ulysses@gmail.com>
 */
public final class TestApplet extends Applet
{

	private static final long serialVersionUID = 1L;

	String ret;  

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String signFile(final String pmessage)
	{
		AccessController.doPrivileged(new PrivilegedAction()
		{
			public Object run()
			{  
				try
				{                             
					String sl = "{\"success\":true," + "\"message\":\"" + pmessage + "\"}";
					ret = sl;					
				}
				catch (Exception e)
				{
					String sl = "{\"success\":false," + "\"message\":\"" + e.getMessage() + "\"}";
					ret = sl;
					System.out.println(sl);					
				}
				
				return null;
			}
		});
				
		return ret;
	}
	
	
	public void init(){		
		// Here you can put the code which will be executed when the applet starts
	}
	
	public void destroy(){	
		// Here you can put the code which will be executed when the applet stops
	}
	
}

