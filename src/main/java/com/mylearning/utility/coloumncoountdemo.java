package com.mylearning.utility;

import java.io.IOException;

public class coloumncoountdemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
	
		GetColumnCount gc = new GetColumnCount();
		
	
		short lastcol= gc.columncount((short) 4);
		
		
		System.out.println(lastcol);
			}
	


}
