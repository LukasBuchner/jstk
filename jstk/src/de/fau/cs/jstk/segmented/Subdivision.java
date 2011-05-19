/*
	Copyright (c) 2009-2011
		Speech Group at Informatik 5, Univ. Erlangen-Nuremberg, GERMANY
		Korbinian Riedhammer
		Tobias Bocklet

	This file is part of the Java Speech Toolkit (JSTK).

	The JSTK is free software: you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.

	The JSTK is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.

	You should have received a copy of the GNU General Public License
	along with the JSTK. If not, see <http://www.gnu.org/licenses/>.
*/
package de.fau.cs.jstk.segmented;

import java.io.Serializable;

import org.w3c.dom.Node;

public class Subdivision implements Serializable{
	private static final long serialVersionUID = -8814031215182493871L;
	
	/**
	 * the index of the word that initiates this Subdivision
	 */
	private int index;
	
	/**
	 * the index of the character that initiates this Subdivision in the orthographic
	 * transcription of the Utterance
	 */
	//private int firstCharacterInOrthography;
	
	public Subdivision(){
		index = 0;
		//firstCharacterInOrthography = 0;
	}
	
	public Subdivision(int firstWord/*, int firstCharacterInOrthography*/){
		this.setIndex(firstWord);
		//this.setFirstCharacterInOrthography(firstCharacterInOrthography);
	}
	
	public static Subdivision read(Node node) throws Exception{
		String nodeName = node.getNodeName();
		
		if (!nodeName.equals("subdivision"))
			throw new Exception("Expecting node name subdivision, got " + nodeName);
				
		int firstWord = 
			Integer.parseInt(node.getAttributes().getNamedItem("firstWord").getNodeValue());

//		int firstCharacterInOrthography = 
//			Integer.parseInt(node.getAttributes().getNamedItem("firstCharacterInOrthography").getNodeValue());
				

		//System.err.println("subdivision: " + firstWord + ", " + firstCharacterInOrthography);
				
		return new Subdivision(firstWord/*, firstCharacterInOrthography*/);				
	}	
	
	public void setIndex(int firstWord) {
		this.index = firstWord;
	}
	public int getIndex() {
		return index;
	}
	
	// obsolete: see Utterance.getOrthographyIndex
//	public void setFirstCharacterInOrthography(int firstCharacterInOrthography) {
//		this.firstCharacterInOrthography = firstCharacterInOrthography;
//	}
//	public int getFirstCharacterInOrthography() {
//		return firstCharacterInOrthography;
//	}
}
