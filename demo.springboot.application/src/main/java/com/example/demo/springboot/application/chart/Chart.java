package com.example.demo.springboot.application.chart;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import java.awt.Color;


public class Chart {
	
	private JFreeChart jchart;
	
	public void CreaBarChart(String title,String topic,DefaultCategoryDataset data) {
	try {
		this.jchart= ChartFactory.createBarChart(title, "City Name", topic, data, PlotOrientation.VERTICAL, true, true, false);
		CategoryPlot plot = jchart.getCategoryPlot();
		plot.setRangeGridlinePaint(Color.black);
		jchart.setBorderVisible(true);
		jchart.setBorderPaint(Color.red);
	}
	catch(NullPointerException e) {e.getLocalizedMessage(); }
	}
	
	public JFreeChart getChart() {
		return jchart;
	}
}