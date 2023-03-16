import java.sql.Timestamp;
import com.baomidou.mybatisplus.annotation.*;

@TableId(type = IdType.AUTO)
public class Customer {
    private Integer id;
    private String name;
    private String address;
    private String phone;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Getters and setters
}
