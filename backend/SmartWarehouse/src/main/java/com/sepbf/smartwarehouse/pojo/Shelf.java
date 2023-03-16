import java.sql.Timestamp;
import com.baomidou.mybatisplus.annotation.*;

@TableId(type = IdType.AUTO)
public class Shelf {
    private Integer id;
    private String location;
    private String status;
    private Integer warehouseId;
    private Integer capacity;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Getters and setters
}
