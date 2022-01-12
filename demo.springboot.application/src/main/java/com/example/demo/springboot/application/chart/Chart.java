package com.example.demo.springboot.application.chart;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;

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
	
	public void CreaLineChart(String title,String categoryAxis, String topic,DefaultCategoryDataset data) {
		try {
			this.jchart= ChartFactory.createLineChart(title, categoryAxis, topic, data);
			LineAndShapeRenderer rendererFormaSpessore = new LineAndShapeRenderer();
			CategoryPlot plot = jchart.getCategoryPlot();
			rendererFormaSpessore.setSeriesPaint(0, Color.RED);
			rendererFormaSpessore.setSeriesPaint(1, Color.GREEN);
			rendererFormaSpessore.setSeriesPaint(2, Color.BLUE);
			rendererFormaSpessore.setSeriesPaint(3, Color.PINK);
			rendererFormaSpessore.setSeriesPaint(4, Color.BLACK);
			rendererFormaSpessore.setSeriesPaint(5, Color.YELLOW);
			plot.setRenderer(rendererFormaSpessore);
			plot.setRangeGridlinePaint(Color.black);
			jchart.setBorderVisible(true);
			jchart.setBorderPaint(Color.black);
		}
		catch(NullPointerException e) {e.getLocalizedMessage(); }
		}
	
	public JFreeChart getChart() {
		return jchart;
	}
}