// MorseCodeConverterTest.java
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MorseCodeConverterTest {

    @Test
    public void testTextToMorse() {
        assertEquals("***-- *- -*** -*** *- --**-- *-*-*- **--**", MorseCodeConverter.textToMorseCode("3ABBA,.?"));
        assertEquals("***** -- --- *-* *** * --**-- *-*-*- **--**", MorseCodeConverter.textToMorseCode("5MORSE,.?"));

    }

    @Test
    public void testMorseToText() {
        assertEquals("3ABBA,.?", MorseCodeConverter.morseCodeToText("***-- *- -*** -*** *- --**-- *-*-*- **--**"));
        assertEquals("5MORSE,.?", MorseCodeConverter.morseCodeToText("***** -- --- *-* *** * --**-- *-*-*- **--**"));

    }


    @Test(expected = IllegalArgumentException.class)
    public void testSymbolToMorse() {
        MorseCodeConverter.textToMorseCode("&%£");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidMorse() {
        MorseCodeConverter.morseCodeToText("*-*-*");

    }




}
