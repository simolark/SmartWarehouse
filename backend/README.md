## 后端部分

### 开发规范：

#### 文件树
```
SmartWarehouse
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── seobf
│   │   │           └── SmartWarehouse
│   │   │               ├── SmartWarehouseApplication.java (主应用程序类)
│   │   │               ├── controller (控制器层)
│   │   │               │   └── UserController.java
│   │   │               ├── service (服务层)
│   │   │               │   ├── UserService.java
│   │   │               │   └── impl
│   │   │               │       └── UserServiceImpl.java
│   │   │               ├── mapper (数据访问层)
│   │   │               │   └── UserMapper.java
│   │   │               ├── pojo (实体类)
│   │   │               │   └── User.java
│   │   │               └── config (配置类)
│   │   │                   └── DataSourceConfig.java
│   │   └── resources (资源文件)
│   │       ├── application.properties (或application.yml，主配置文件)
│   │       ├── static (静态资源，如CSS、JS、图像等)
│   │       └── templates (Thymeleaf模板等)
│   └── test (单元测试和集成测试)
│       ├── java
│       │   └── com
│       │       └── example
│       │           └── myapp
│       │               ├── MyappApplicationTests.java
│       │               ├── controller
│       │               │   └── UserControllerTest.java
│       │               └── service
│       │                   └── UserServiceTest.java
│       └── resources
│           └── application-test.properties (或application-test.yml，用于测试的配置文件)
├── .gitignore (用于指定在Git版本控制中忽略的文件和目录)
├── pom.xml (Maven项目配置文件)
├── build.gradle (Gradle项目配置文件，如果使用Gradle)
└── README.md (项目说明文档)
```

#### 数据库设计
```sql
-- 创建客户信息表
CREATE TABLE customer (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  address VARCHAR(255) NOT NULL,
  phone VARCHAR(20) NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 创建商品信息表
CREATE TABLE product (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  price DECIMAL(10,2) NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 创建订单信息表
CREATE TABLE order_list (
  id INT AUTO_INCREMENT PRIMARY KEY,
  customer_id INT NOT NULL,
  product_id INT NOT NULL,
  quantity INT NOT NULL,
  amount DECIMAL(10,2) NOT NULL,
  status VARCHAR(20) NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (customer_id) REFERENCES customer(id),
  FOREIGN KEY (product_id) REFERENCES product(id)
);

-- 创建货物信息表
CREATE TABLE goods (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  quantity INT NOT NULL,
  location VARCHAR(255) NOT NULL,
  shelf_id INT NOT NULL,
  order_id INT NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (shelf_id) REFERENCES shelf(id),
  FOREIGN KEY (order_id) REFERENCES order_list(id)
);

-- 创建货架信息表
CREATE TABLE shelf (
  id INT AUTO_INCREMENT PRIMARY KEY,
  location VARCHAR(255) NOT NULL,
  status VARCHAR(20) NOT NULL,
  warehouse_id INT NOT NULL,
  capacity INT NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (warehouse_id) REFERENCES warehouse(id)
);

-- 创建仓库信息表
CREATE TABLE warehouse (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  total_capacity INT NOT NULL,
  used_capacity INT NOT NULL DEFAULT 0,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 创建机器人信息表
CREATE TABLE robot (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  type VARCHAR(255) NOT NULL,
  status VARCHAR(20) NOT NULL,
  battery_level INT NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 创建小车信息表
CREATE TABLE cart (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  type VARCHAR(255) NOT NULL,
  status VARCHAR(20) NOT NULL,
  battery_level INT NOT NULL,
  capacity INT NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


```

### 代码编写规范

1. 所有的业务的具体实现均放在service.impl中，service下需要对具体功能进行集成
2. 后端返回给前端的所有信息均通过Result类进行包装后返回，不随意返回任何数据
3. service层需要进行逻辑判断并对结果进行包装，controller层只负责接收请求、转发请求和响应结果
4. 未完待续......
