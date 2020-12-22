/*
 * The MIT License
 *
 * Copyright (c) 2010-2015 Jason Priem, Bruno P. Kinoshita
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.tupilabs.human_name_parser;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests for {@code Name} and {@code HumanNameParserParser}. Utilizes the same
 * input file as the PHP library 0.2 version.
 *
 * @since 0.1
 */
public class UpdatesTest {

    private Name name;
    private String leadingInit;
    private String first;
    private String nicknames;
    private String middle;
    private String last;
    private String suffix;
    private String salutation;
    private String postnominal;

    private List<String> suffixes;
    private List<String> salutations;
    private List<String> prefixes;
    private List<String> postnominals;

    @Before
    public void setUp() {

        this.salutations = Arrays.asList(new String[] {"mr", "master", "mister",
                "mrs", "miss", "ms", "dr", "prof", "rev", "fr", "judge", "honorable", "hon" });
        this.suffixes = Arrays.asList(new String[] { "jr", "sr", "2", "ii",
                "iii", "iv", "v", "senior", "junior" });
        this.postnominals = Arrays.asList(new String[] { "phd", "ph.d.", "ph.d",
                "esq", "esquire", "apr", "rph", "pe", "md", "ma", "dmd", "cme",
                "dds", "cpa", "dvm" });
        this.prefixes = Arrays.asList(new String[] { "bar", "ben", "bin", "da", "dal",
                "de la", "de", "del", "der", "di", "ibn", "la", "le",
                "san", "st", "ste", "van", "van der", "van den", "vel",
                "von", "o'"});

    }

    @Test
    public void testLastNameUpdates() {

        String prefixes = StringUtils.join(this.prefixes, " |") + " ";

        String lastRegex = "(?i)\\b([^ ]+ y |"+prefixes+")*[^ ]+$";

        this.name = new Name("O'Malley");
        String s = this.name.chopWithRegex(lastRegex, 0);

        assertEquals("O'Malley", s);
    }


    
}
