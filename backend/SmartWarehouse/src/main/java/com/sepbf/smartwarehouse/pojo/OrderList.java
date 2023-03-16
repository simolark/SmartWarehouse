import java.sql.Timestamp;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;

@TableId(type = IdType.AUTO)
public class OrderList {
    private Integer id;
    private Integer customerId;
    private Integer productId;
    private Integer quantity;
    private BigDecimal amount;
    private String status;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Getters and setters
}
