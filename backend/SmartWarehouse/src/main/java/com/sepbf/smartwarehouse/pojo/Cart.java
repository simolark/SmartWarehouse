import java.sql.Timestamp;
import com.baomidou.mybatisplus.annotation.*;

@TableId(type = IdType.AUTO)
public class Cart {
    private Integer id;
    private String name;
    private String type;
    private String status;
    private Integer batteryLevel;
    private Integer capacity;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Getters and setters
}
