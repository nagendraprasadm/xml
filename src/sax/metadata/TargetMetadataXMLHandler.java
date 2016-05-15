package sax.metadata;

import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class TargetMetadataXMLHandler extends DefaultHandler {

	private static final String TARGE_METADATA = "TargetMetadata";
	private static final String TARGET_TYPE_ATTRIBUTE = "TYPE";
	private static final String METRIC_TAG = "Metric";
	private static final String METRIC_NAME_ATTRIBUTE = "NAME";
	private static final String METRIC_COLUMN_TAG = "ColumnDescriptor";
	private static final String METRIC_COLUMN_NAME_ATTRIBUTE = "NAME";
	private static final String LABEL_TAG = "Label";
	private static final String PROPERTY_TAG = "InstanceProperty";
	private static final String PROPERTY_NAME_ATTRIBUTE = "NAME";
	

	private TargetMetadata _metadata;
	private TargetMetric _metricData;
	private String _curColumnName;
	private String _curColDesc;
	private String _curPropName;
	private String _curPropDesc;
	private Stack<String> _currentStack = new Stack<String>();
	private boolean _isLabel = false;

	@Override
	public void characters(char[] arg0, int arg1, int arg2) throws SAXException {
		super.characters(arg0, arg1, arg2);
		if (_isLabel) {
			String currentElem = _currentStack.peek();			
			if (currentElem.equals(METRIC_COLUMN_TAG)) {
				_curColDesc = new String(arg0, arg1, arg2);
			} else if (currentElem.equals(METRIC_TAG)) {
				_metricData.setMetricDescription(new String(arg0, arg1, arg2));
			} else if (currentElem.equals(PROPERTY_TAG)) {
				_curPropDesc = new String(arg0, arg1, arg2);
			}
		}
	}

	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
	}

	@Override
	public void endElement(String arg0, String arg1, String arg2)
			throws SAXException {
		super.endElement(arg0, arg1, arg2);
		if (arg1.equals(METRIC_TAG)) {
			_metadata.addMetric(_metricData);
			_metricData = null;
		} else if (arg1.equals(METRIC_COLUMN_TAG)) {
			_metricData.addMetricColumn(_curColumnName, _curColDesc);
		}else if (arg1.equals(PROPERTY_TAG)) {
			_metadata.addProperty(_curPropName, _curPropDesc);
		}
		if (arg1.equals(METRIC_TAG) || arg1.equals(METRIC_COLUMN_TAG)
				|| arg1.equals(TARGE_METADATA) || arg1.equals(PROPERTY_TAG)) {
			_currentStack.pop();
		}
		_isLabel = false;
	}

	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
	}

	@Override
	public void startElement(String arg0, String arg1, String arg2,
			Attributes arg3) throws SAXException {
		super.startElement(arg0, arg1, arg2, arg3);
		if (arg1.equals(TARGE_METADATA)) {
			_metadata = new TargetMetadata();
			_metadata.setTargetName(arg3.getValue(TARGET_TYPE_ATTRIBUTE));
			_currentStack.push(TARGET_TYPE_ATTRIBUTE);
			_isLabel = false;
		} else if (arg1.equals(METRIC_TAG)) {
			_metricData = new TargetMetric();
			_metricData.setMetricName(arg3.getValue(METRIC_NAME_ATTRIBUTE));
			_currentStack.push(METRIC_TAG);
			_isLabel = false;			
		} else if (arg1.equals(METRIC_COLUMN_TAG)) {
			_curColumnName = arg3.getValue(METRIC_COLUMN_NAME_ATTRIBUTE);
			_currentStack.push(METRIC_COLUMN_TAG);
			_isLabel = false;			
		}else if (arg1.equals(PROPERTY_TAG)) {
			_curPropName = arg3.getValue(PROPERTY_NAME_ATTRIBUTE);
			_currentStack.push(PROPERTY_TAG);
			_isLabel = false;			
		}
		else if (arg1.equals(LABEL_TAG)) {
			_isLabel = true;
		}
	}

	public TargetMetadata getMetadata() {
		return _metadata;
	}

	public void setMetadata(TargetMetadata metadata) {
		_metadata = metadata;
	}

}
