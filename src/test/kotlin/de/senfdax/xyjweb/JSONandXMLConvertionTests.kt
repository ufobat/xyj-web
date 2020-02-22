package de.senfdax.xyjweb

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.core.format.DataFormatDetector
import com.fasterxml.jackson.core.format.MatchStrength
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.xml.XmlFactory
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class JSONandXMLConvertionTests {
	val xmlMapper = XmlMapper()
	val jsonMapper = ObjectMapper()
	val xmlString = "<a omg='1'><b foo='bar' /></a>"
	val jsonString = "{ \"foo\": 1, \"b\": { \"bar\": \"baz\"} }"
	val detector = DataFormatDetector(JsonFactory(), XmlFactory(), YAMLFactory())
			.withMinimalMatch(MatchStrength.WEAK_MATCH)
			.withOptimalMatch(MatchStrength.SOLID_MATCH)

	@Test
	fun convert_xml_to_json() {
		val node = xmlMapper.readTree(xmlString)
		val jsonString = jsonMapper.writeValueAsString(node)
		assertEquals("{\"omg\":\"1\",\"b\":{\"foo\":\"bar\"}}", jsonString);
	}

	@Test
	fun convert_json_to_xml() {
		val node = jsonMapper.readTree(jsonString)
		val xmlString = xmlMapper.writeValueAsString(node);
		assertEquals("<ObjectNode><foo>1</foo><b><bar>baz</bar></b></ObjectNode>", xmlString)
	}

	@Test
	fun detect_json() {
		val match = detector.findFormat(jsonString.toByteArray())
		assertEquals(match.matchedFormatName, JsonFactory().formatName)
	}

	@Test
	fun detect_yml() {
		val match = detector.findFormat(xmlString.toByteArray())
		assertEquals(match.matchedFormatName, XmlFactory().formatName)
	}
}
