package ms_JUnit_Ex_28Aug2017;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import ms_JUnit_Ex_28Aug2017.MS_JUnit_TC1_28Aug2017;
import ms_JUnit_Ex_28Aug2017.MS_JUnit_TC2_28Aug2017;
	
	
	// JUnit Suite Test
	
	@RunWith(Suite.class)
	
	@Suite.SuiteClasses({
		
		MS_JUnit_TC1_28Aug2017.class,
		MS_JUnit_TC2_28Aug2017.class
		
	})
	public class MS_JUnit_TestSuit_28Aug2017
	
	{
		
	}
	
	
	

