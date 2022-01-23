package tw.com.fcb.coffee;

import java.util.List;

public interface CoffeeService {
    public List<Coffee> getFromTaste(String singerName);

    public List<Coffee> getFromLowQuantity(int quantity);

    public List<Coffee> getLowestPrice();

}
