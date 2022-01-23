package tw.com.fcb.coffee;

import lombok.ToString;
import org.junit.jupiter.api.Test;
import tw.com.fcb.coffee.Coffee;
import tw.com.fcb.coffee.CoffeeService;
import tw.com.fcb.coffee.CoffeeServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class CoffeeServiceImplTest {

    @Test
    void getFromTaste() {
        CoffeeService service = new CoffeeServiceImpl();
        List<Coffee> coffee = service.getFromTaste("果");
        assertEquals(3, coffee.size());
    }

    @Test
    void getFromLowQuantity() {
        CoffeeService service = new CoffeeServiceImpl();
        List<Coffee> coffee = service.getFromLowQuantity(5);
        assertEquals("IN01",coffee.get(0).getCoffeeId());
    }

    @Test
    void getLowestPrice() {
        CoffeeService service = new CoffeeServiceImpl();
        List<Coffee> coffee = service.getLowestPrice();
        assertEquals(2,coffee.size());
        assertEquals(380,coffee.get(0).getPrice());
        assertEquals("耶加雪夫-果丁丁",coffee.get(0).getCoffeeName());
        assertEquals("薇薇特南果",coffee.get(1).getCoffeeName());
    }
}