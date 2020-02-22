package de.senfdax.xyjweb

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class JSONandXMLConvertionTests {
	val xmlMapper = XmlMapper()
	val jsonMapper = ObjectMapper()

	@Test
	fun convert_xml_to_json() {
		val string = "<a omg='1'><b foo='bar' /></a>"
		val node = xmlMapper.readTree(string)
		val jsonString = jsonMapper.writeValueAsString(node)
		assertEquals("{\"omg\":\"1\",\"b\":{\"foo\":\"bar\"}}", jsonString);
	}

	@Test
	fun convert_json_to_xml() {
		val string = "{ \"foo\": 1, \"b\": { \"bar\": \"baz\"} }"
		val node = jsonMapper.readTree(string)
		val xmlString = xmlMapper.writeValueAsString(node);
		assertEquals("<ObjectNode><foo>1</foo><b><bar>baz</bar></b></ObjectNode>", xmlString)
	}

}
