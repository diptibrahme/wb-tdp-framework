package com.wb.tdp.ms.common.validation;

import java.io.Serializable;

import lombok.Data;

/**
 * This class holds validation configuration of an attribute involved in validation operation
 * @author satprasa
 *
 */
@Data
public class Configuration implements Serializable{

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -8780904275330770211L;
	
	/**
	 * Attribute datatype
	 */
	private String datatype;
	/**
	 * Attribute defaultValue
	 */
	private String defaultValue;
	/**
	 * Defines whether validation is active for the Attribute
	 */
	private boolean active;
	/**
	 * Defines Mandatory validation rule for the Attribute
	 */
	private MandatoryRule mandatoryRules;
	/**
	 * Defines minMax validation rule for the Attribute
	 */
	private MinMaxRule minMaxRule;
	/**
	 * Defines Pattern Matching validation rule for the Attribute
	 */
	private PatternMatchingRule patternMatchingRule;
	/**
	 * Defines Level Based Pattern Matching validation rule for the Attribute
	 */
	private LevelBasedDataPatternRule levelBasedDataPatternRule;
	
	/** The list of value type rule. */
	private EnumTypeRule enumTypeRule;
}
