/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.model;

import org.wahlzeit.utils.EnumValue;

/**
 * The gender denotes some user's/person's/character's/whatever gender. The undefined value denotes that no value was
 * provided or the entity is not human.
 */
public enum CoordinateType implements EnumValue {

	/**
	 * UNDEFINED = user never entered anything
	 */
	UNDEFINED(0), CARTESIAN(1), ;

	/**
	 *
	 */
	private static CoordinateType[] allValues = {
		UNDEFINED, CARTESIAN
	};

	/**
	 * @methodtype conversion
	 */
	public static CoordinateType getFromInt(int myValue) throws IllegalArgumentException {
		assertIsValidGenderAsInt(myValue);
		return allValues[myValue];
	}

	/**
	 *
	 */
	protected static void assertIsValidGenderAsInt(int myValue) throws IllegalArgumentException {
		if ((myValue < 0) || (myValue > 3)) {
			throw new IllegalArgumentException("invalid Gender int: " + myValue);
		}
	}

	/**
	 *
	 */
	private static final String[] valueNames = {
		"undefined", "cartesian"
	};

	/**
	 * @methodtype conversion
	 */
	public static CoordinateType getFromString(String coordType) throws IllegalArgumentException {
		for (CoordinateType coordinateType : CoordinateType.values()) {
			if (valueNames[coordinateType.asInt()].equals(coordType)) {
				return coordinateType;
			}
		}

		throw new IllegalArgumentException("invalid Coordinatetype string: " + coordType);
	}

	/**
	 *
	 */
	private int value;

	/**
	 *
	 */
	private CoordinateType(int myValue) {
		value = myValue;
	}
			
	/**
	 * 
	 */
	public int asInt() {
		return value;
	}
	
	/**
	 * 
	 */
	public String asString() {
		return valueNames[value];
	}
	
	/**
	 * 
	 */
	public CoordinateType[] getAllValues() {
		return allValues;
	}
	
	/**
	 * 
	 */
	public String getTypeName() {
		return "CoordinateType";
	}
		
	/**
	 * 
	 */
	public boolean isUndefined() {
		return (this == UNDEFINED);
	}
	
	/**
	 * 
	 */
	public boolean isCartesian() {
		return (this == CARTESIAN);
	}


}
