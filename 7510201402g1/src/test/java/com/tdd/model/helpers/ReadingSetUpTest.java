package com.tdd.model.helpers;

import com.tdd.model.languageTools.SpanishXMLConstants;
import java.io.File;
import org.junit.Before;

public abstract class ReadingSetUpTest {

    protected XMLConstants constants;
	protected String XMLpath;
	
	@Before
    public void setUp() {
		this.constants = new SpanishXMLConstants();
		XMLReader.configureLanguage(constants);
		this.XMLpath  = System.getProperty("user.dir") + File.separator + "doc";
		this.XMLpath += File.separator + "xmls" + File.separator + "xmls";
		this.XMLpath += File.separator + "laberintos" + File.separator + "LaberintoSimple.xml";
	}

}