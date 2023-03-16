import java.sql.Timestamp;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;

@TableId(type = IdType.AUTO)
public class Product {
    private Integer id;
    private String name;
    private BigDecimal price;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Getters and setters
}
