import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;

/**
 * Both of these unit tests will fail due to a bug in FasterXML.Jackson-Databind
 */
public class DefaultSerializeTest {
	
	/**
	 * Here we are testing to see that the resulting JSON includes defaultOfTrue when it gets set to false,
	 * and that defaultOfFalse is not included because of JSONInclude(Include.NON_DEFAULT)
	 * @throws JsonProcessingException
	 */
	@Test
	public void testDefaultOfTrue() throws JsonProcessingException{
		/** Verify that the default value of DefaultOfTrue is True */
		DefaultPOJO myPOJO = new DefaultPOJO();
		assertTrue(myPOJO.getDefaultOfTrue());
		
		/** Verify that the new value of DefaultOfTrue is False */
		myPOJO.setDefaultOfTrueToFalse();
		assertFalse(myPOJO.getDefaultOfTrue());
		
		String expected = "{\"myString\":\"Hello World!\",\"defaultOfTrue\":false}";
		String actual = new ObjectMapper().writeValueAsString(myPOJO);
		assertEquals(expected, actual);
		
		/** The actual JSON returned here is:
		 * < {"myString":"Hello World!"} >
		 * When we are expecting the non default value of defaultOfTrue to be included in the JSON
		 */
	}
	
	/**
	 * Here we are testing to see that the resulting JSON includes defaultOfFalse when it gets set to true,
	 * and that defaultOfTrue is not included because of JSONInclude(Include.NON_DEFAULT)
	 * @throws JsonProcessingException
	 */
	@Test
	public void testDefaultOfFalse() throws JsonProcessingException{
		/** Verify that the default value of DefaultOfFalse is False */
		DefaultPOJO myPOJO = new DefaultPOJO();
		assertFalse(myPOJO.getDefaultOfFalse());
		
		/**Verify that the new value of DefaultOfFalse is True */
		myPOJO.setDefaultOfFalseToTrue();
		assertTrue(myPOJO.getDefaultOfFalse());
		
		String expected = "{\"myString\":\"Hello World!\",\"defaultOfFalse\":true}";
		String actual = new ObjectMapper().writeValueAsString(myPOJO);
		assertEquals(expected, actual);
		
		/**
		 * The actual JSON returned here is:
		 * < {"myString":"Hello World!","defaultOfTrue":true,"defaultOfFalse":true} >
		 * When we are expecting the defaultOfTrue to not be included, since it's default value is true
		 */
	}
	
	@JsonPropertyOrder({"myString", "defaultOfTrue", "defaultOfFalse"})
	public static class DefaultPOJO {
		
		@JsonProperty
		@JsonInclude(Include.NON_DEFAULT)
		private boolean defaultOfTrue = true;
		
		@JsonProperty
		@JsonInclude(Include.NON_DEFAULT)
		private boolean defaultOfFalse = false;
		
		@JsonProperty
		private String myString;
		
		@JsonCreator
		public DefaultPOJO() {
			myString = "Hello World!";
		}
		
		public DefaultPOJO setDefaultOfTrueToFalse(){
			this.defaultOfTrue = false;
			return this;
		}
		
		public DefaultPOJO setDefaultOfFalseToTrue(){
			this.defaultOfFalse = true;
			return this;
		}
		
		public boolean getDefaultOfTrue(){
			return this.defaultOfTrue;
		}
		
		public boolean getDefaultOfFalse(){
			return this.defaultOfFalse;
		}

	}

}
