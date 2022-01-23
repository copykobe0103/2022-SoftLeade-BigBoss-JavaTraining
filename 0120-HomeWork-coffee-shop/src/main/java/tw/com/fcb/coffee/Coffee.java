package tw.com.fcb.coffee;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class Coffee {
    private String coffeeId;
    private String coffeeName;
    private String taste;
    private String origin;
    private String roast;
    private String processType;
    private int    price;
    private int    quantity;

}
