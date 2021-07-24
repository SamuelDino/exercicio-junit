package tests.entities;

import org.junit.jupiter.api.Test;
import entities.Financing;
import tests.factory.FinancingFactory;

import org.junit.jupiter.api.Assertions;
public class FinancingTests {

	@Test
	public void constructorShouldCreateObjectWhenValidParameters() {
		double totalAmount = 100000.0;
		double income = 2000.0;
		Integer months = 80;
		double entry = totalAmount * 0.20;
		double quota = 1000.0;
		Financing fin = FinancingFactory.createFinancing(totalAmount, income, months);
		
		Assertions.assertTrue(fin!=null);
		Assertions.assertEquals(quota, fin.getIncome()/2);
	}
	
	@Test
	public void constructorShouldThrowExceptionWhenInvalidParameters() {
		double totalAmount = 100000.0;
		double income = 2000.0;
		Integer months = 40;
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			Financing fin = FinancingFactory.createFinancing(totalAmount, income, months);
		});
	}
	
	@Test
	public void setTotalAmountShouldUpdateWhenValidParameters() {
		double totalAmount = 100000.0;
		double income = 2000.0;
		Integer months = 80;
		Financing fin = FinancingFactory.createFinancing(totalAmount, income, months);
		
		totalAmount = 99000.0;
		fin.setTotalAmount(totalAmount);
		
		Assertions.assertEquals(totalAmount, fin.getTotalAmount());
	}
	
	@Test
	public void setTotalAmountShouldThrowExceptionWhenInvalidParameters() {	
	
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			double totalAmount = 100000.0;
			double income = 2000.0;
			Integer months = 80;
			Financing fin = FinancingFactory.createFinancing(totalAmount, income, months);
			totalAmount = 101000.0;
			fin.setTotalAmount(totalAmount);
		});	
	}
	
	@Test
	public void setIncomeShouldUpdateWhenValidParameters() {
		double totalAmount = 100000.0;
		double income = 2000.0;
		Integer months = 80;
		Financing fin = FinancingFactory.createFinancing(totalAmount, income, months);
		
		income = 2100.0;
		fin.setIncome(income);
		
		Assertions.assertEquals(income, fin.getIncome());
	}
	
	@Test
	public void setIncomeShouldThrowExceptionWhenInvalidParameters() {	
	
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			double totalAmount = 100000.0;
			double income = 2000.0;
			Integer months = 80;
			Financing fin = FinancingFactory.createFinancing(totalAmount, income, months);
			
			income = 1999.0;
			fin.setIncome(income);
		});	
	}
	
	@Test
	public void setMonthsShouldUpdateWhenValidParameters() {
		double totalAmount = 100000.0;
		double income = 2000.0;
		Integer months = 80;
		Financing fin = FinancingFactory.createFinancing(totalAmount, income, months);
		
		months = 81;
		fin.setMonths(months);
		
		Assertions.assertEquals(months, fin.getMonths());
	}
	
	@Test
	public void setMonthsShouldThrowExceptionWhenInvalidParameters() {	
	
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			double totalAmount = 100000.0;
			double income = 2000.0;
			Integer months = 80;
			Financing fin = FinancingFactory.createFinancing(totalAmount, income, months);
			
			months = 79;
			fin.setMonths(months);
		});	
	}
	
	@Test
	public void entryShouldCalculateCorrectValueEntry() {
		double totalAmount = 100000.0;
		double income = 2000.0;
		Integer months = 80;
		double entry = totalAmount * 0.20;
		Financing fin = FinancingFactory.createFinancing(totalAmount, income, months);
		
		Assertions.assertEquals(entry, fin.entry());
	}
	
	@Test
	public void quotaShouldCalculateCorrectValueQuota() {
		double totalAmount = 100000.0;
		double income = 2000.0;
		Integer months = 80;
		double quota = (totalAmount-(totalAmount * 0.20))/months;
		Financing fin = FinancingFactory.createFinancing(totalAmount, income, months);
		
		Assertions.assertEquals(quota, fin.quota());
	}
}
