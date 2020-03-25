package org.xtext.metadoodle.validation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.*;
import org.eclipse.xtext.nodemodel.INode;

public class ValueConverterImp extends DefaultTerminalConverters {

	@ValueConverter(rule = "DATE")
	public IValueConverter<String> DATE() {
		return new IValueConverter<String>() {

			@Override
			public String toValue(String string, INode node) throws ValueConverterException {
				// Separe les valeurs de la date pour les evaluer
				String[] parts = string.split("/");
				
				String dateFormat;
				if(parts[2].length() == 4) {
					dateFormat = "dd/MM/yyyy";
				} else {
					dateFormat = "dd/MM/yy";
				}
				if(!isValidDate(string, dateFormat)) {
					throw new ValueConverterException("La date donnée n'est pas valide", node, new Exception());
				}

				return string;
			}

			@Override
			public String toString(String value) throws ValueConverterException {
				return value;
			}
		};
	}

	public boolean isValidDate(String dateStr, String dateFormat) {
		DateFormat sdf = new SimpleDateFormat(dateFormat);
		sdf.setLenient(false);
		try {
			sdf.parse(dateStr);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

}
