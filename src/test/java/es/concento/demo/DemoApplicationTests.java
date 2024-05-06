package es.concento.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import es.concento.demo.service.PriceService;
import es.concento.demo.model.Price;
import es.concento.demo.repository.PriceRepo;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class DemoApplicationTests {

	@InjectMocks
 	private PriceService priceService;

	@Mock
	private PriceRepo priceRepo;

	@ParameterizedTest
	//@Sql(scripts = {"/data.sql"}, executionPhase = BEFORE_TEST_CLASS)
	@MethodSource ("providedTestData")
	public void tests(long brand, long product, String fecha, long resultado ) throws Exception {
		System.out.println("brand:" + brand + "/" + "product:" + product + "/" + "fecha:" + fecha + "/" + "resultado:" + resultado);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    	Date midate = dateFormat.parse(fecha);
		Price miprice = priceService.getPrice(brand,product,midate.getTime());
		assertEquals(resultado, miprice.getPriceList());
	}

	static Stream<Arguments> providedTestData() {
		return Stream.of(
			//brand, product,date,resultado (poner el resuñtado correcto)
			Arguments.of(1,35455, "2020-06-14 10:00:00",1),
			Arguments.of(1,35455, "2020-06-14 16:00:00",1),
			Arguments.of(1,35455, "2020-06-14 21:00:00",1),
			Arguments.of(1,35455, "2020-06-15 10:00:00",1),
			Arguments.of(1,35455, "2020-06-16 21:00:00",1)
		);
	}
}
