package com.wb.tdp.ms.common.validation;

import java.io.Serializable;
import java.util.Map;

import lombok.Data;
/**
 * This class defines Level Based Pattern Matching validation rule for a Attribute
 * @author satprasa
 *
 */
@Data
public class LevelBasedDataPatternRule implements Serializable {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 7596361485158186237L;
	/**
	 * Defines selected strength level from available pattern rules
	 */
	private String strengthLevel;
	/**
	 * Defines list of all available pattern rules and strength level as key
	 */
	private Map<String, PatternMatchingRule> patternMatchingRules;

	/**
	 * This method provides pattern matching based on selected strength level
	 * @return the patternMatchingRules
	 */
	public PatternMatchingRule getActivePatternMatchingRule() {
		return patternMatchingRules.get(strengthLevel);
	}
	
}
