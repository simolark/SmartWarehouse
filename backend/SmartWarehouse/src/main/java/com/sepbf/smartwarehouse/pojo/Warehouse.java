import java.sql.Timestamp;
import com.baomidou.mybatisplus.annotation.*;

@TableId(type = IdType.AUTO)
public class Warehouse {
    private Integer id;
    private String name;
    private Integer totalCapacity;
    private Integer usedCapacity;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Getters and setters
}
