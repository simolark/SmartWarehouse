import java.sql.Timestamp;
import com.baomidou.mybatisplus.annotation.*;

@TableId(type = IdType.AUTO)
public class Robot {
    private Integer id;
    private String name;
    private String type;
    private String status;
    private Integer batteryLevel;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Getters and setters
}
