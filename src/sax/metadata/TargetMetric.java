package sax.metadata;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TargetMetric {
	
	private String _metricName;
	
	private String _metricDescription;
	
	private Map<String, String> _metricColumns = new HashMap<String, String>();
	
	private String _source;

	public String getMetricName() {
		return _metricName;
	}

	public void setMetricName(String metricName) {
		_metricName = metricName;
	}

	public String getMetricDescription() {
		return _metricDescription;
	}

	public void setMetricDescription(String metricDescription) {
		_metricDescription = metricDescription;
	}

	public Map<String, String> getMetricColumns() {
		return _metricColumns;
	}

	public void setMetricColumns(Map<String, String> metricColumns) {
		_metricColumns = metricColumns;
	}

	public String getSource() {
		return _source;
	}

	public void setSource(String source) {
		_source = source;
	}

	public void addMetricColumn(String columnName, String columnDescription){
		_metricColumns.put(columnName, columnDescription);
	}

	@Override
	public String toString() {
		String metricData = "";
		metricData = "\t$"+_metricDescription +" - "+ _metricName + "\n" ;
		Iterator<String> keyIt = _metricColumns.keySet().iterator();
		while(keyIt.hasNext()){
			String key = keyIt.next();
			String value = _metricColumns.get(key);
			metricData += "\t\t#" + value + " - " + key + "\n";
		}
		return metricData;
	}
	
	
}
