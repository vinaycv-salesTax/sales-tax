package com.demo.salestax;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SalesTaxApplicationTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void restoreStreams() {
	    System.setOut(originalOut);
	    System.setErr(originalErr);
	}

	@Test
	public void testTaxCalucation_Quatity1_Success() {
		String[] args = {"src/test/resources/order1.txt"};
		SalesTaxApplication.main(args);
		assertTrue(outContent.toString().contains("Total: 29.83"));
		assertTrue(outContent.toString().contains("Sales Taxes: 1.50"));
	}
	
	
	@Test
	public void testTaxCalucation_Quatity2_Success() {
		String[] args = {"src/test/resources/order4.txt"};
		SalesTaxApplication.main(args);
		assertTrue(outContent.toString().contains("Total: 42.32"));
		assertTrue(outContent.toString().contains("Sales Taxes: 1.50"));
	}
	
	@Test
	public void testTaxCalucation_WrongFilePath_Failed() {
		String[] args = {"src/test/resources/order10.txt"};
		SalesTaxApplication.main(args);
		assertTrue(errContent.toString().contains("Not a valid order file : src/test/resources/order10.txt"));
	}
	
	@Test
	public void testTaxCalucation_WrongItem_Failed() {
		String[] args = {"src/test/resources/order5.txt"};
		SalesTaxApplication.main(args);
		assertTrue(errContent.toString().contains("wrong item: this is nothing"));
	}
	
	@Test
	public void testTaxCalucation_NoInputFiles_Failed() {
		String[] args = {};
		SalesTaxApplication.main(args);
		assertTrue(errContent.toString().contains("Please provide required arguments."));
		assertTrue(errContent.toString().contains("Run as command: java -jar jarname filename1 filename2"));
	}
}
