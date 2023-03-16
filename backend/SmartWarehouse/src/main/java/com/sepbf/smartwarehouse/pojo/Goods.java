import java.sql.Timestamp;
import com.baomidou.mybatisplus.annotation.*;

@TableId(type = IdType.AUTO)
public class Goods {
    private Integer id;
    private String name;
    private Integer quantity;
    private String location;
    private Integer shelfId;
    private Integer orderId;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Getters and setters
}
