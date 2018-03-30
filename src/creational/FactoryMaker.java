package creational;

import eNum.FacLEVEL;

public class FactoryMaker{
	private static Factory pf=null;
	public static Factory getFactory(FacLEVEL l){
		switch(l) {
		case L1:
			pf = new Level_1_Factory();
			break;
		case L2:
			pf = new Level_2_Factory();
			break;
		default:
			break;
		
		}
		return pf;
	}
}

