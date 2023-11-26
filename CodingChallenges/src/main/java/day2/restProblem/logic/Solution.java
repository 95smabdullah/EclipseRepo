package day2.restProblem.logic;

import java.util.List;

import day2.restProblem.controller.Controller;
import day2.restProblem.controller.Parser;
import day2.restProblem.entities.IotResponse;


public class Solution {
	
	public static void main(String[] args) {
		int resp = Parser.parseJsonResponse("STOPPED", (double)45, "04-2019");
		System.out.println(resp);
	}
	
	

}
