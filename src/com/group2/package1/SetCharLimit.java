package com.group2.package1;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

@SuppressWarnings("serial")
public class SetCharLimit extends PlainDocument {
	private int limit;

	public SetCharLimit(int limitation) {
		this.limit = limitation;
	}

	@Override
	public void insertString(int offset, String str, AttributeSet set) throws BadLocationException {
		if (str == null) {
			return;
		} else if ((getLength() + str.length()) <= limit) {
			super.insertString(offset, str, set);
		}
	}

}
